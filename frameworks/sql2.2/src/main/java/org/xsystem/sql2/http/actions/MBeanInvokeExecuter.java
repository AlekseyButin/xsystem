/*
 * Copyright 2017 Andrey Timofeev.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.xsystem.sql2.http.actions;

import java.lang.management.ManagementFactory;
import java.util.Map;
import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.RuntimeMBeanException;
import org.w3c.dom.Element;
import org.xsystem.sql2.convertor.Converter;
import org.xsystem.sql2.convertor.DefaultConvertor;
import org.xsystem.sql2.http.Enviroment;
import org.xsystem.sql2.http.Executer;
import org.xsystem.utils.MBeanUtil;
import org.xsystem.utils.XMLUtil;


/**
 *
 * @author Andrey Timofeev
 */
public class MBeanInvokeExecuter implements Executer{
   
    String name;
    String operation;
    private static final Converter converter = new DefaultConvertor();

    ObjectName getObjectName(String work) {
        Enviroment env = Enviroment.getEnviroment();
        Map<String, String> objectNames = env.getObjectNames();
        String realName = objectNames.get(work);
        ObjectName objname = MBeanUtil.createObjectName(realName);
        return objname;
    }

    public MBeanInfo getMBeanInfo(String work) throws RuntimeException {
        ObjectName objname = getObjectName(work);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        try {
            MBeanInfo info = mbs.getMBeanInfo(objname);
            return info;
        } catch (InstanceNotFoundException | IntrospectionException | ReflectionException ex) {
            throw new Error(ex);

        }
    }

    MBeanOperationInfo getOperation(MBeanInfo info, String work) {
        MBeanOperationInfo[] opList = info.getOperations();
        for (MBeanOperationInfo opInfo : opList) {
            String test = opInfo.getName();
            if (work.equals(test)) {
                return opInfo;
            }
        }
        return null;
    }

    String[] getParamSignature(MBeanParameterInfo[] paramInfo) {
        String[] ret = new String[paramInfo.length];
        for (int i = 0; i < paramInfo.length; i++) {
            ret[i] = paramInfo[i].getType();
        }
        return ret;
    }

    Object[] getParams(Map params, MBeanParameterInfo[] paramInfo) {
        Object[] ret = new Object[paramInfo.length];
        try {
            for (int i = 0; i < paramInfo.length; i++) {
                MBeanParameterInfo info = paramInfo[i];
                String paramName = info.getName();
                if (!params.containsKey(paramName)) {
                    throw new Error("Parametr " + paramName + " not define");
                }
                String paramType = info.getType();

                Class cparam = Class.forName(paramType);
                Object paramValue = params.get(paramName);
                if (paramValue != null) {
                    if (cparam.isInstance(paramValue)) {
                        ret[i] = paramValue;
                    } else {
                        Object v = converter.convert(paramValue, cparam);
                        ret[i] = v;
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            throw new Error(ex);
        }
        return ret;
    }

    Object excec(String work, String operation, Object[] params, String[] signature) {
        ObjectName objname = getObjectName(work);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        try {
            Object ret = mbs.invoke(objname, operation, params, signature);
            return ret;
        } catch (InstanceNotFoundException |  ReflectionException ex) {
            throw new Error(ex);
        } catch (MBeanException ex2) {
            throw new RuntimeException(ex2);
        }
    }
      

    @Override
    public Object execute(Map params) throws RuntimeException {
        String workName = (String) params.get("objectname");
        if (workName == null) {
            workName = name;
        }
        String workOperation = (String) params.get("operation");
        if (workOperation == null) {
            workOperation = operation;
        }
        MBeanInfo info = getMBeanInfo(workName);
        MBeanOperationInfo opInfo = getOperation(info, workOperation);

        MBeanParameterInfo[] paramInfo = opInfo.getSignature();

        String[] signature = getParamSignature(paramInfo);
        Object[] methodparams = getParams(params, paramInfo);

        Object ret = excec(workName, workOperation, methodparams, signature);

        return ret;
    }


    @Override
    public void parse(Element element) {
        name = element.getAttribute("name");
        operation = element.getAttribute("operation");

    }
    
}

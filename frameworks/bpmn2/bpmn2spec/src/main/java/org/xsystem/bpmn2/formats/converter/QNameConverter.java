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
package org.xsystem.bpmn2.formats.converter;
import org.apache.commons.beanutils.converters.AbstractConverter;
import javax.xml.namespace.QName;

/**
 *
 * @author Andrey Timofeev
 */
public class QNameConverter extends AbstractConverter {
    
    
    public QNameConverter() {
        super();
    }
    
    @Override
    protected Class getDefaultType() {
       return QName.class;
    }

    
    
    @Override
    protected Object convertToType(Class type, Object value) throws Throwable {
        if (QName.class.equals(type)) {
            QName ret=new QName("AAA");
            return type.cast(ret);
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

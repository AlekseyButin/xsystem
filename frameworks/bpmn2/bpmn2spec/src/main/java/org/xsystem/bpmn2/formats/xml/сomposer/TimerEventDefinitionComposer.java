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
package org.xsystem.bpmn2.formats.xml.сomposer;

import org.w3c.dom.Element;
import org.xsystem.bpmn2.model.common.FormalExpression;
import org.xsystem.bpmn2.model.events.TimerEventDefinition;
import org.xsystem.utils.XMLUtil;

/**
 *
 * @author Andrey Timofeev
 */
public class TimerEventDefinitionComposer extends BaseElementComposer{
    
    @Override
    public Element composer(Element root, Object src) {
        TimerEventDefinition  timerEventDefinition=( TimerEventDefinition) src;
        Element ret = makeBaseElement(root, "timerEventDefinition",timerEventDefinition);
        
        FormalExpression formalExpression=(FormalExpression)timerEventDefinition.getTimeDate();
        
        if (formalExpression!=null){
            String exp=formalExpression.getBody();
            Element expElement=XMLUtil.createNewElement(ret, "timeDate");
            XMLUtil.createNewCDATA(expElement,exp);
        }
        
        return ret;
    }
}

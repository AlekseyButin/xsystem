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

import java.util.List;
import org.w3c.dom.Element;
import org.xsystem.bpmn2.model.activities.Activity;
import org.xsystem.bpmn2.model.events.BoundaryEvent;
import org.xsystem.bpmn2.model.events.EventDefinition;
import org.xsystem.bpmn2.model.events.IntermediateCatchEvent;
import org.xsystem.bpmn2.model.system.Reference;

/**
 *
 * @author Andrey Timofeev
 */
public class BoundaryEventComposer extends CatchEventComposer{

    @Override
    public Element composer(Element root, Object src) {
        
        BoundaryEvent boundaryEvent = (BoundaryEvent) src;
        Element ret = makeBaseElement(root, "boundaryEvent", boundaryEvent);
        
        Reference<Activity> ref=boundaryEvent.getAttachedToRef();
        
        ComposerFactory.setAttr(ret, "attachedToRef",ref);
        
        List<EventDefinition> eventDefinitions=boundaryEvent.getEventDefinitions();
        eventDefinitions.stream().forEach(action->{
           ComposerFactory.makeDiagramElement(ret,action);
        });
        return ret;
        
        
    }
    // extends CatchEventComposer
}

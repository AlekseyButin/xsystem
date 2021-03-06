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
package org.xsystem.bpmn2.model.collaboration;

import org.xsystem.bpmn2.model.common.PartnerEntity;
import org.xsystem.bpmn2.model.common.PartnerRole;
import org.xsystem.bpmn2.model.foundation.BaseElement;
import org.xsystem.bpmn2.model.service.Interface;
import org.xsystem.bpmn2.model.system.Reference;
import org.xsystem.bpmn2.model.process.Process;

/**
 *
 * @author Andrey Timofeev
 */
public interface Participant    extends BaseElement{
    public String getName();
    public void setName(String name);
    
    //processRef: Process [0..1]
    public Reference<Process> getProcessRef(); 
    public void setProcessRef(Reference<Process> process);
    
    //partnerRoleRef: PartnerRole [0..*]
    public Reference<PartnerRole> getPartnerRole();
    public void setPartnerRole(Reference<PartnerRole> partnerRole);
    
    //partnerEntityRef: PartnerEntity [0..*]
    public Reference<PartnerEntity> getPartnerEntity();
    public void setPartnerEntity(Reference<PartnerEntity> partnerRole);
    
    
    //interfaceRef: Interface [0..*]
    public Reference<Interface> getInterface();
    public void setInterface(Reference<Interface> _interface);
    
    public ParticipantMultiplicity getParticipantMultiplicity();
    public void setParticipantMultiplicity(ParticipantMultiplicity participantMultiplicity);
    //participantMultiplicity: participant-Multiplicity [0..1]
    //endPointRefs: EndPoint [0..*]

}

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
package org.xsystem.bpmn2.modelimpl.collaboration;

import org.xsystem.bpmn2.model.collaboration.ParticipantMultiplicity;
import org.xsystem.bpmn2.modelimpl.foundation.BaseElementImpl;
import org.xsystem.bpmn2.modelimpl.infrastructure.DefinitionsImpl;


/**
 *
 * @author Andrey Timofeev
 */
public class ParticipantMultiplicityImpl extends BaseElementImpl implements ParticipantMultiplicity{
    Integer minimum=0;
    Integer maximum=1;
    
    public ParticipantMultiplicityImpl(DefinitionsImpl definitions) {
        super(definitions);
    }

    @Override
    public Integer getMinimum() {
        return this.minimum;
    }

    @Override
    public void setMinimum(Integer minimum) {
        this.minimum=minimum;
    }

    @Override
    public Integer getMaximum() {
        return this.maximum;
    }

    @Override
    public void setMaximum(Integer maximum) {
        this.maximum=maximum;
    }

    
}

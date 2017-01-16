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

import org.xsystem.bpmn2.model.foundation.BaseElement;

/**
 *
 * @author Andrey Timofeev
 */
public interface ParticipantMultiplicity extends BaseElement {
    // minimum: integer = 0
    // maximum: integer [0..1] = 1
    public Integer getMinimum();
    public void    setMinimum(Integer minimum);
    public Integer getMaximum();
    public void    setMaximum(Integer maximum);
    
}

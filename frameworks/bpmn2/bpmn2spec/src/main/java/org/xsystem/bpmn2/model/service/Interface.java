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
package org.xsystem.bpmn2.model.service;

import java.util.List;
import org.xsystem.bpmn2.model.common.CallableElement;
import org.xsystem.bpmn2.model.foundation.RootElement;
import org.xsystem.bpmn2.model.system.Reference;



/**
 *
 * @author Andrey Timofeev
 */
public interface Interface extends RootElement {
    public String getImplementationRef();

    public void setImplementationRef(String implementationRef);
    public String getName();

    public void setName(String name);

    public List<CallableElement> getCallableElements();

    public List<Operation> getOperations();
}

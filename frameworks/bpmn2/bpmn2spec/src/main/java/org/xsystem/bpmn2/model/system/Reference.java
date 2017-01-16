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
package org.xsystem.bpmn2.model.system;

import javax.xml.namespace.QName;
/**
 *
 * @author Andrey Timofeev
 */
public interface Reference<V>  {
    public QName getQName();
    public V resolvedReference();
    
    public default String getLocalPart(){
        QName ret=getQName();
        return ret.getLocalPart();
    }
    
}


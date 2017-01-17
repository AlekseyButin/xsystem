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
package org.xsystem.bpmn2.modelimpl.foundation;

import org.xsystem.bpmn2.model.foundation.BaseElement;
import org.xsystem.bpmn2.model.system.Reference;
import org.xsystem.bpmn2.modelimpl.infrastructure.DefinitionsImpl;
import org.xsystem.bpmn2.modelimpl.system.DefinitionElementImpl;

/**
 *
 * @author Andrey Timofeev
 */
public class BaseElementImpl extends DefinitionElementImpl implements BaseElement{
    String id;
    
       @Override
    public String TypeName(){
        return "BaseElement";
    }
    
    
    public Object getExtensionElements(){
        return null;
    };
    
    public void   setExtensionElements(Object extensionElements){
    }
    
    public BaseElementImpl(DefinitionsImpl definitions){
        super(definitions);
    }
    
    public String toString(){
      return "("+TypeName()+") " +id;  
    }
    
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        if (this.id!=null)
          definitions.unRegístrate(this);
        this.id = id;
        definitions.regístrate(this);
    }
}

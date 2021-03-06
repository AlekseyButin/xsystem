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
import org.xsystem.bpmn2.formats.xml.XMLComposer;
import org.xsystem.bpmn2.model.common.FlowElement;
import org.xsystem.bpmn2.model.foundation.BaseElement;

/**
 *
 * @author Andrey Timofeev
 */

abstract class FlowElementComposer extends BaseElementComposer {

    @Override
    Element makeBaseElement(Element root, String tag, BaseElement src) {
        Element ret = super.makeBaseElement(root, tag, src);
        FlowElement flowElement = (FlowElement) src;
        ComposerFactory.setAttr(ret, "name", flowElement.getName());
        return ret;
    }
}

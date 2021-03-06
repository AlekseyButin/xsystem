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
package org.xsystem.sql2.http.actions;

import java.util.Map;
import org.xsystem.sql2.http.Executer;

/**
 *
 * @author Andrey Timofeev
 */
public class SelectExecuter extends DMLExecuter {

    @Override
    public Object execute(Map params) throws RuntimeException {
        Long skip = null;
        Integer total = null;
        Object obj = params.get("skip");
        if (obj instanceof String) {
            String strSkip = (String) obj;
            if (!strSkip.isEmpty()) {
                skip = Long.getLong(strSkip);
            }
        } else if (obj instanceof Long) {
            skip = (Long) obj;
        }

        obj = params.get("total");
        if (obj instanceof String) {
            String strTotal = (String) obj;
            if (!strTotal.isEmpty()) {
                total = Integer.getInteger(strTotal);
            }
        } else if (obj instanceof Integer) {
            total = (Integer) obj;
        }

        Object ret = Executer.list(path, skip, total, params);
        return ret;
    }
}

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
import org.xsystem.sql2.http.ErrorHandler;
import org.xsystem.utils.Auxilary;

/**
 *
 * @author Andrey Timofeev
 */
public class StandartErrorHandler implements ErrorHandler{
    
    @Override
    public Object handler(Throwable e) {
        e.printStackTrace();
        Map errRet = Auxilary.makeJsonThrowable(e);
        return errRet;
    }
}

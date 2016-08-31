/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
 * %%
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
 * #L%
 */
package gwt.material.design.client.constants;

import gwt.material.design.client.base.helper.EnumHelper;

/**
 * Types of NavBar<br>
 * - FIXED<br>
 * - TALL<br>
 * @author kevzlou7979
 * @author Ben Dol
 */
public enum NavBarType implements CssType {
    FIXED("navbar-fixed"),
    TALL("navbar-tall"),
    SHRINK("navbar-shrink");

    private final String cssClass;

    NavBarType(final String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String getCssName() {
        return cssClass;
    }

    public static NavBarType fromStyleName(final String styleName) {
        return EnumHelper.fromStyleName(styleName, NavBarType.class, FIXED);
    }
}

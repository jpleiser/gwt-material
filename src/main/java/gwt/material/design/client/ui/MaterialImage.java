package gwt.material.design.client.ui;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 GwtMaterialDesign
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

import gwt.material.design.client.custom.HasGrid;
import gwt.material.design.client.constants.ImageType;

import com.google.gwt.user.client.ui.Image;

//@formatter:off
/**
* Images can be styled in different ways using Material Design
* <h3>UiBinder Usage:</h3>
* 
* <pre>
*{@code//Simple Image
* <m:MaterialImage url="http://assets.materialup.com/uploads/0587e4a8-6a46-4e27-b8bf-836e4350fe82/candycons.gif"/>
* 
* // Circle Image
* <m:MaterialImage url="http://assets.materialup.com/uploads/0587e4a8-6a46-4e27-b8bf-836e4350fe82/candycons.gif" type="CIRCLE"/>
* 
* // MaterialBoxed Image
* <m:MaterialImage url="http://assets.materialup.com/uploads/0587e4a8-6a46-4e27-b8bf-836e4350fe82/candycons.gif" type="MATERIALBOXED"/>
* }
* </pre>
* 
* @author kevzlou7979
* @see <a href="http://gwt-material-demo.herokuapp.com/#media">Material Media</a>
*/
//@formatter:on
public class MaterialImage extends Image implements HasGrid {
	
	private String caption = "";
	private String opacity;
	
	/**
	 * Creates an empty image.
	 */
	public MaterialImage() {}
	
	/**
	 * Creates a simple image.
	 */
	public MaterialImage(String url){
		setUrl(url);
	}
	
	/**
	 * Creates an image with Specific type.
	 */
	public MaterialImage(String url, ImageType type) {
		setUrl(url);
		setType(type);
	}

	@Override
	public void onLoad() {
		super.onLoad();
		this.addStyleName("responsive-img");
		onInitMaterialDesign();
	}
	
	@Override
	protected void onUnload() {
		super.onUnload();
	}

	public native void onInitMaterialDesign() /*-{
		$wnd.jQuery(document).ready(function(){
	    	$wnd.jQuery('.materialboxed').materialbox();
	    });
	}-*/;

	public void setType(ImageType type) {
		this.addStyleName(type.getCssName());
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
		this.getElement().setAttribute("data-caption", caption);
	}
	
	public String getOpacity() {
		return opacity;
	}

	public void setOpacity(String opacity) {
		this.opacity = opacity;
		this.getElement().getStyle().setOpacity(Double.parseDouble(opacity));
	}

	@Override
	public void setGrid(String grid) {
		this.addStyleName("col " + grid);
	}
	
	@Override
	public void setOffset(String offset) {
		String cssName = "";
		for(String val : offset.split(" ")){
			cssName = cssName + " offset-" +  val;
		}
		this.addStyleName(cssName);
	}
}

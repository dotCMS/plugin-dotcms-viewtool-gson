package com.dotcms.viewtools.gson;

import org.apache.velocity.tools.view.context.ViewContext;
import org.apache.velocity.tools.view.servlet.ServletToolInfo;

public class GsonToolInfo extends ServletToolInfo {

    @Override
    public String getKey () {
        return "gson";
    }

    @Override
    public String getScope () {
        return ViewContext.APPLICATION;
    }

    @Override
    public String getClassname () {
        return GsonTool.class.getName();
    }

    @Override
    public Object getInstance ( Object initData ) {

    	GsonTool viewTool = new GsonTool();
        viewTool.init( initData );

        setScope( ViewContext.APPLICATION );

        return viewTool;
    }

}
package com.dotcms.viewtools.gson;

import javax.servlet.http.HttpServletRequest;

import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.context.ViewContext;
import org.apache.velocity.tools.view.tools.ViewTool;

import com.dotmarketing.business.APILocator;
import com.dotmarketing.business.web.WebAPILocator;
import com.dotmarketing.portlets.contentlet.model.Contentlet;
import com.dotmarketing.util.Logger;
import com.dotmarketing.viewtools.content.ContentMap;
import com.google.gson.Gson;
import com.liferay.portal.model.User;

public class GsonTool implements ViewTool {
	private HttpServletRequest request;
	Context ctx;
	User user = null;

	public void init(Object obj) {

	}

	public String toJson(Object src) {

		Gson gson = new Gson();
		return gson.toJson(src);

	}

	public String toJson(Contentlet src) {
		Gson gson = new Gson();
		return gson.toJson(src);

	}

	public String toJson(ContentMap src) {
		Gson gson = new Gson();

		Contentlet c;
		try {
			c = APILocator.getContentletAPI().find(String.valueOf(src.get("inode")), user, true);
			return gson.toJson(c.getMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;


	}

	public Object fronJson(String src, String className) {
		try {
			Class clazz = Class.forName(className);

			Gson gson = new Gson();
			return (Object) gson.fromJson(src, clazz);
		} catch (ClassNotFoundException e) {
			Logger.error(this.getClass(), e.getMessage());
			e.printStackTrace();
		}

		return null;
	}


}

package com.siztao.ailicili.manage.web.servlet;

import com.siztao.framework.utils.PropertiesConfigUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 初始化全局参数
 */
public class ConfigServlet extends HttpServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigServlet.class);

	@Override
    public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		servletContext.setAttribute("_path", servletContext.getContextPath());
		try {
			servletContext.setAttribute("_cdnStaticResourcesPath", PropertiesConfigUtil.getProperty("cdn.static.resources.url"));
			LOGGER.info("ConfigServlet - 系统初始化参数配置成功");
		}
		catch (Exception e) {
			LOGGER.error("ConfigServlet - 系统初始化参数配置有误", e);
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		super.service(req, res);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}

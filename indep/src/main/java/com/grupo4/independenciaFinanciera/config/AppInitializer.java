package com.grupo4.independenciaFinanciera.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.catalina.servlets.DefaultServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.apache.jasper.servlet.JspServlet;

public class AppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.setServletContext(container);

        ServletRegistration.Dynamic jspServlet = container.addServlet(
                "jspDispatcher", new JspServlet());

        jspServlet.setLoadOnStartup(1);
        jspServlet.addMapping("/WEB-INF/views/*");


        ServletRegistration.Dynamic cssServlet = container.addServlet(
                "cssDispatcher", new DefaultServlet());

        cssServlet.setLoadOnStartup(1);
        cssServlet.addMapping("/assets/css/*", "/assets/js/*", "/assets/fonts/*", "/assets/sass/*", "/images/*");

        ServletRegistration.Dynamic servlet = container.addServlet(
                "dispatcher", new DispatcherServlet(ctx));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");
    }

}
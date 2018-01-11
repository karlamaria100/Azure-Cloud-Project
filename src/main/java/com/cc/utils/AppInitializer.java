package com.cc.utils;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.logging.Level;

/**
 * Created by Karla on 11-Jan-18.
 */
public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        servletContext.addListener(new ContextLoaderListener(ctx));
        ctx.setServletContext(servletContext);
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
//        java.util.logging.Logger.getLogger("log4j.rootLogger").setLevel(Level.SEVERE);

        /**
         * create smartmart actor and proxy actor and retain ActorRefs in static values because we need to
         * send messages through this actors in the future
         */
        //  Helpers.StaticValues.SMARTMART_ACTOR = system.actorOf(Props.create(MainActor.class, ctx), "smart1");

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/");


    }


}

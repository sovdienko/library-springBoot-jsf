package org.ovd.edu.springbootJsf.config;

import org.ovd.edu.springbootJsf.objects.LibraryFacade;
import org.ovd.edu.springbootJsf.servlets.PdfContent;
import org.ovd.edu.springbootJsf.servlets.ShowImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.faces.mvc.JsfView;
import org.springframework.faces.webflow.JsfResourceRequestHandler;
import org.springframework.web.context.support.ServletContextAttributeExporter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/**
 * Spring MVC configuration.
 * Configures Spring WebFlow in context of spring MVC.
 */
@EnableWebMvc
@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private WebFlowConfiguration webFlowConfig;

    @Autowired
    LibraryFacade libraryFacade;
    @Autowired
    ShowImage showImage;
    @Autowired
    PdfContent pdfContent;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       registry.addViewController("/login").setViewName("login");
    }

/*    @Bean(name = "resourceHandlerJSF")
    public JsfResourceRequestHandler jsfResourceRequestHandler() {
        return new JsfResourceRequestHandler();
    }

    @Bean
    public SimpleUrlHandlerMapping simpleUrlHandlerMapping(){
        SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
        simpleUrlHandlerMapping.setOrder(1);
        Properties urlProperties = new Properties();
        urlProperties.put("/javax.faces.resource*//**", "resourceHandlerJSF");
        simpleUrlHandlerMapping.setMappings(urlProperties);
        return simpleUrlHandlerMapping;
    }*/

    @Bean
    public FlowHandlerMapping flowHandlerMapping() {
        FlowHandlerMapping handlerMapping = new FlowHandlerMapping();
       // handlerMapping.setOrder(2);
        //-- Locale Support (I18N) --//
        handlerMapping.setInterceptors(new Object[] {localeChangeInterceptor()});
        handlerMapping.setFlowRegistry(this.webFlowConfig.flowRegistry());
        return handlerMapping;
    }

    @Bean
    public FlowHandlerAdapter flowHandlerAdapter() {
        FlowHandlerAdapter handlerAdapter = new FlowHandlerAdapter();
        handlerAdapter.setFlowExecutor(this.webFlowConfig.flowExecutor());
        handlerAdapter.setSaveOutputToFlashScopeOnRedirect(true);
        return handlerAdapter;
    }

    @Bean
    public ViewResolver urlBasedViewResolver() {
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setViewClass(JsfView.class);
        urlBasedViewResolver.setPrefix("/WEB-INF/views/");
        urlBasedViewResolver.setSuffix(".xhtml");
        return urlBasedViewResolver;
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet ();
    }

    @Bean
    public ServletRegistrationBean dispatcherServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet(), "/app/*" );
        registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME );
        return registration;
    }


    @Bean
    public ServletRegistrationBean showImageServletRegistrationBean() {
        return new ServletRegistrationBean(showImage, "/ShowImage");
    }

    @Bean
    public ServletRegistrationBean pdfContentServletRegistrationBean() {
        return new ServletRegistrationBean(pdfContent, "/PdfContent");
    }

/*    @Bean
    public ServletContextAttributeExporter servletContextAttributeExporter(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("libraryFacade",libraryFacade);
        ServletContextAttributeExporter servletContextAttributeExporter = new ServletContextAttributeExporter();
        servletContextAttributeExporter.setAttributes(map);
        return servletContextAttributeExporter;
    }*/

    //-- Start Locale Support (I18N) --//
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("ru")); // Set default Locale as RU
        return slr;
    }

    @Bean(name = "msg")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("i18n/messages");  // name of the resource bundle
        source.setUseCodeAsDefaultMessage(true);
        source.setDefaultEncoding("UTF-8");
        return source;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }


/*    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor()).addPathPatterns("*//**");
    }*/
    //-- Start Locale Support (I18N) --//

}

package org.ovd.edu.springbootJsf.config;

/**
 * Created by Sergey.Ovdienko on 15.10.2016.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.faces.config.AbstractFacesFlowConfiguration;
import org.springframework.faces.webflow.FlowFacesContextLifecycleListener;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.security.SecurityFlowExecutionListener;

/**
 * Spring WebFlow configuration.
 */
@Configuration
public class WebFlowConfiguration extends AbstractFacesFlowConfiguration {

    @Bean
    public FlowDefinitionRegistry flowRegistry() {
        return getFlowDefinitionRegistryBuilder()
            .setBasePath("/WEB-INF/flows" )
            .addFlowLocationPattern("*.xml" )
            .setFlowBuilderServices(flowBuilderServices())
            .build();
    }

    @Bean
    public FlowExecutor flowExecutor() {
        return getFlowExecutorBuilder(flowRegistry())
            .addFlowExecutionListener(new FlowFacesContextLifecycleListener())
           // .addFlowExecutionListener(new SecurityFlowExecutionListener())
            .setRedirectInSameState(false)
            .build();
    }

    @Bean
    public FlowBuilderServices flowBuilderServices() {
        return getFlowBuilderServicesBuilder()
            .setDevelopmentMode( true )
            .build();
    }

}
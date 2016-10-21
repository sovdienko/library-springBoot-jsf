package org.ovd.edu.springbootJsf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;

@SpringBootApplication
public class LibraryApplication implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        ((TomcatEmbeddedServletContainerFactory) container)
            .addContextCustomizers(context -> context.addWelcomeFile("index.html"));
    }
}
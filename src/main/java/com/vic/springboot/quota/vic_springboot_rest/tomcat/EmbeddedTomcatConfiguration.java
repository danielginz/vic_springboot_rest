package com.vic.springboot.quota.vic_springboot_rest.tomcat;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

//This class is intended to run more than one instance
//Uncomment commented code and you'll be able to run the application on a few ports simultaneously

@Configuration
public class EmbeddedTomcatConfiguration {
    
    @Bean
    public ServletWebServerFactory servletContainer() {

        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        
		/*Arrays.asList(3333,8081).forEach(port -> {
            Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
            connector.setPort(port);
            tomcat.addAdditionalTomcatConnectors(connector);
        });*/
        
        return tomcat;
    }
}
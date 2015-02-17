package com.steve.research;

import org.apache.camel.builder.RouteBuilder;

public class MyRoute extends RouteBuilder {
    private String webserviceEndpoint = "cxf:bean:helloService";

    @Override
    public void configure() throws Exception {
        from("timer:foo?period=1s&repeatCount=1")
            .log("Hello!!!")
        ;

        from(webserviceEndpoint)
            .log("WebService opearation: ${header.operationName}")
            .log("WebService body: ${body}")
            .setBody(simple("Hello, ${body}"))
        ;
    }

    public void setWebserviceEndpoint(String webserviceEndpoint) {
        this.webserviceEndpoint = webserviceEndpoint;
    }
}

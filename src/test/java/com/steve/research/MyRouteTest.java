package com.steve.research;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MyRouteTest extends CamelTestSupport {

    @Produce(uri = "direct:webservice")
    ProducerTemplate webservice;

    @Test
    public void testFoo() throws InterruptedException {
        Object result = webservice.requestBody("Dude");
        System.out.println("Result from web service call was: " + result);
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        MyRoute myRoute = new MyRoute();
        myRoute.setWebserviceEndpoint("direct:webservice");
        return myRoute;
    }
}

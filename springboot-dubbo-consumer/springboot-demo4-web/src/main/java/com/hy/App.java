package com.hy;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class App
{
    public static void main( String[] args )
    { 
        new SpringApplicationBuilder(App.class).properties("server.port=8099")
        .run(args);
    }
	
}

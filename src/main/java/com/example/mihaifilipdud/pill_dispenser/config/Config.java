package com.example.mihaifilipdud.pill_dispenser.config;

import com.example.mihaifilipdud.pill_dispenser.implementations.HelloWorldRMIimpl;
import com.example.mihaifilipdud.pill_dispenser.interfaces.HelloWorldRMI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.remoting.support.RemoteExporter;


@Configuration
public class Config {

    @Bean
    RemoteExporter registerRMIExporter() {

        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("helloworldrmi");
        exporter.setServiceInterface(HelloWorldRMI.class);
        exporter.setService(new HelloWorldRMIimpl());
        return exporter;
    }
}
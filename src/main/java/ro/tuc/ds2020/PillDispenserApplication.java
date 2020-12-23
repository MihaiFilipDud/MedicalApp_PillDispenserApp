package ro.tuc.ds2020;

import org.springframework.boot.builder.SpringApplicationBuilder;
import ro.tuc.ds2020.entities.MedicationPlan;
import ro.tuc.ds2020.hessian_rmi.MedicationPlanTransfer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

@SpringBootApplication
public class PillDispenserApplication {

    @Bean
    public HessianProxyFactoryBean hessianInvoker() {
        HessianProxyFactoryBean invoker = new HessianProxyFactoryBean();
        invoker.setServiceUrl("https://mihaifilipdud-backend-sd.herokuapp.com/medPlanTransfer");
        invoker.setServiceInterface(MedicationPlanTransfer.class);
        return invoker;
    }

    public static void main(String[] args) {
        SpringApplicationBuilder pillDispenser = new SpringApplicationBuilder(PillDispenserApplication.class);
        pillDispenser.headless(false);
        ConfigurableApplicationContext context = pillDispenser.run(args);


    }

    @PostConstruct
    void started() {
        // set JVM timezone as UTC
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

}

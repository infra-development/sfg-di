package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controller.ConstructorInjectedController;
import guru.springframework.sfgdi.controller.MyController;
import guru.springframework.sfgdi.controller.PropertyInjectedController;
import guru.springframework.sfgdi.controller.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);
        MyController myController = (MyController) ctx.getBean("myController");
        String greetings = myController.sayHello();
        System.out.println(greetings);

        System.out.println("--- Property ---");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        String greetingProp = propertyInjectedController.getGreeting();
        System.out.println(greetingProp);

        System.out.println("--- Setter ---");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        String greetingSetter = setterInjectedController.getGreeting();
        System.out.println(greetingSetter);

        System.out.println("--- Constructor ---");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        String greetingConst = setterInjectedController.getGreeting();
        System.out.println(greetingConst);
    }

}

package dev.mflash.guides.spring.aop;

import dev.mflash.guides.spring.aop.service.FarewellService;
import dev.mflash.guides.spring.aop.service.GreetingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Launcher implements CommandLineRunner {

  private final GreetingService greetingService;
  private final FarewellService farewellService;

  /**
   * If do not work @Autowire in Aspect
   */
//  @Bean
//  public LogEntryExitAspect interceptor() {
//    LogEntryExitAspect aspect = Aspects.aspectOf(LogEntryExitAspect.class);
//    // ... inject dependencies here if not using @Autowired
//    return aspect;
//  }

  public Launcher(GreetingService greetingService, FarewellService farewellService) {
    this.greetingService = greetingService;
    this.farewellService = farewellService;
  }

  public static void main(String... args) {
    SpringApplication.run(Launcher.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    greetingService.greet("Joe");
    greetingService.greet("Jane");
    farewellService.bye("Joe");
    farewellService.bye("Jane");
  }
}

package dev.mflash.guides.spring.aop.service;

import dev.mflash.guides.spring.aop.annotation.LogEntryExit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
public class FarewellService {

  @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  public String bye(String name) {
    return "Bye, " + resolveName(name) + "!";
  }

  @LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  public String resolveName(String name) {
    return !name.isBlank() ? name : "world";
  }
}

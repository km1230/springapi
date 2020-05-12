package com.devjunior.springapi;

import java.util.concurrent.atomic.AtomicLong;
import java.util.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//====================================================================
/* @RestController of Spring tells class GreetingController is a controller
 * such that it return domain objects instead of views from its methods */
//====================================================================
@RestController
public class GreetingController {
  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();
  private static List allGreeting = new ArrayList();

  //====================================================================
  /* @GetMapping, @PostMapping, or @RequestMapping(method=GET), etc
   * HTTP GET Method at pathname "/greeting"
   * mapped to setGreeting method which return a Greeting object */
  //====================================================================
  /* @RequestParam binds URL parameter "name"'s value to <<String name>>
   * if param is absent, defaultValue is binded instead */
  //====================================================================
  //====================================================================
  /* returned Greeting object is automatically converted as JSON
   * by Spring's MappingJackson2HttpMessageConverter */
  //====================================================================
  @GetMapping("/greeting")
  public Greeting setGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    Greeting g = new Greeting (counter.incrementAndGet(), String.format(template, name));
    allGreeting.add(g);
    return g;
  }

  @GetMapping("/allgreeting")
  public List getAllGreeting() {
    return allGreeting;
  }
}

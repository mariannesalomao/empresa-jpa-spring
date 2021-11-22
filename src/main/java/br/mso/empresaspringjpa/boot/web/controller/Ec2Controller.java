package br.mso.empresaspringjpa.boot.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ec2Controller {
  
  @RequestMapping(method = RequestMethod.GET, value = "/aws")
  public String aws() {
    return "Nossa aplicação está rodando na AWS";
  }
}

package br.mso.empresaspringjpa.boot.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cargos")
public class CargoController {
  
  @RequestMapping(method = RequestMethod.GET, value = "/cadastrar")
//  @GetMapping(path = "/cadastrar")
  public String cadastrar() {
    return "/cargo/cadastro.html";
  }
  
  @RequestMapping(method = RequestMethod.GET, value = "/listar")
//  @GetMapping("/listar")
  public String listar() {
    return "/cargo/lista.html";
  }
}

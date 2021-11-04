package br.mso.empresaspringjpa.boot.web.controller;

import br.mso.empresaspringjpa.boot.domain.Cargo;
import br.mso.empresaspringjpa.boot.domain.Departamento;
import br.mso.empresaspringjpa.boot.service.CargoService;
import br.mso.empresaspringjpa.boot.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(path = "/cargos")
public class CargoController {
  
  @Autowired
  private CargoService cargoService;
  
  @Autowired
  private DepartamentoService departamentoService;
  
  @RequestMapping(method = RequestMethod.GET, value = "/cadastrar")
//  @GetMapping(path = "/cadastrar")
  public String cadastrar(Cargo cargo) {
    return "/cargo/cadastro.html";
  }
  
  @RequestMapping(method = RequestMethod.GET, value = "/listar")
//  @GetMapping("/listar")
  public String listar(ModelMap model) {
    model.addAttribute("cargos", cargoService.buscarTodos());
    return "/cargo/lista.html";
  }
  
  @RequestMapping(method = RequestMethod.POST, value = "/salvar")
  public String salvar(Cargo cargo, RedirectAttributes attr) {
    cargoService.salvar(cargo);
    attr.addFlashAttribute("success", "Cargo inserido com sucesso");
    return "redirect:/cargos/cadastrar";
  }
  
  @RequestMapping(method = RequestMethod.GET, value = "/editar/{id}")
  public String preEditar(@PathVariable("id") Long id, ModelMap model) {
    model.addAttribute("cargo", cargoService.buscarPorId(id));
    return "cargo/cadastro.html";
  }
  
  @RequestMapping(method = RequestMethod.POST, value = "/editar")
  public String editar(Cargo cargo, RedirectAttributes attr) {
    cargoService.editar(cargo);
    attr.addFlashAttribute("success", "Registro atualizado com sucesso!");
    return "redirect:/cargos/cadastrar";
  }
  
  @ModelAttribute("departamentos")
  public List<Departamento> listaDeDepartamentos() {
    return departamentoService.buscarTodos();
  }
}

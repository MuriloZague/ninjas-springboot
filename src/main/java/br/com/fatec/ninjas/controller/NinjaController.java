package br.com.fatec.ninjas.controller;

import br.com.fatec.ninjas.model.Ninja;
import br.com.fatec.ninjas.service.NinjaService;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @PostMapping
    public Ninja cadastrarNinja(@Valid @RequestBody Ninja ninja){
        return ninjaService.cadastrarNinja(ninja);
    }

    @GetMapping 
    public List<Ninja> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    @GetMapping("/id/{id}")
    public Optional<Ninja> pesquisarNinja(@PathVariable Long id) {
        return ninjaService.pesquisarNinja(id);
    }
    
    @GetMapping("/nome/{nome}")
    public Ninja pesquisarNinjaPorNome(@PathVariable String nome) {
        return ninjaService.pesquisarNinjaPorNome(nome);
    }
    
    @GetMapping("/partenome/{nome}")
    public List<Ninja> pesquisarNinjaPorParteDoNome(@PathVariable String nome){
        return ninjaService.pesquisarNinjaPorParteDoNome(nome);
    }

    @PutMapping("/{id}")
    public Ninja atualizarNinja(@PathVariable Long id, @Valid @RequestBody Ninja ninja){
        return ninjaService.atualizarNinja(id, ninja);
    }

    @DeleteMapping("/{id}")
    public void deletarNinja(@PathVariable Long id){
        ninjaService.deletarNinjar(id);
    }

}

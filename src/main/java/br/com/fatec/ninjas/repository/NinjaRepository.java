package br.com.fatec.ninjas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.ninjas.model.Ninja;

public interface NinjaRepository extends JpaRepository <Ninja, Long> {
    
}

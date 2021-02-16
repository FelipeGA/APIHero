package com.ProjetoInterJavaDeveloper.APIHero.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.ProjetoInterJavaDeveloper.APIHero.repository.HeroesRepository;
import com.ProjetoInterJavaDeveloper.APIHero.modelo.Heroes;
import com.ProjetoInterJavaDeveloper.APIHero.service.HeroesService;
import static com.ProjetoInterJavaDeveloper.APIHero.constantes.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RestController
public class HeroesController {
    HeroesService heroesService;
    HeroesRepository heroesRepository;

    private static final org.slf4j.Logger log=
            org.slf4j.LoggerFactory.getLogger(HeroesController.class); //Reporta logs sempre que acontece uma requisição do cliente.

    public HeroesController(HeroesService heroesService, HeroesRepository heroesRepository) {
        this.heroesService = heroesService;
        this.heroesRepository = heroesRepository;
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Heroes> getAllItems() {
        log.info("Chamando todos os Heróis!!");
        return heroesService.findAll();

    }

    @GetMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Heroes>> findByIdHero(@PathVariable String id) {
        log.info("Chamando o Herói com id {}", id);
        return heroesService.findByIdHero(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Heroes> createHero(@RequestBody Heroes heroes) {
        log.info("Um novo Herói surgiu!!");
        return heroesService.save(heroes);

    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deletebyIDHero(@PathVariable String id) {
        heroesService.deletebyIDHero(id);
        log.info("Demitindo o Herói com id {} :/", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }
}

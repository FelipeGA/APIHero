package com.ProjetoInterJavaDeveloper.APIHero.repository;

import com.ProjetoInterJavaDeveloper.APIHero.modelo.Heroes;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface HeroesRepository extends  CrudRepository<Heroes,String> {

}

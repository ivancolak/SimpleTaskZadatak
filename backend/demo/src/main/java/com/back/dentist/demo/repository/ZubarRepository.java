package com.back.dentist.demo.repository;

import com.back.dentist.demo.entity.Zubar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZubarRepository extends CrudRepository<Zubar, Integer> {
    Zubar findByJmbg(Integer jmbg);


}

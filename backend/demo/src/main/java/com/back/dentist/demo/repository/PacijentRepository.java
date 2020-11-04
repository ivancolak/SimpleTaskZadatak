package com.back.dentist.demo.repository;

import com.back.dentist.demo.entity.Pacijent;
import com.back.dentist.demo.entity.Zubar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacijentRepository extends CrudRepository<Pacijent, Integer> {
    Pacijent findByJmbg(Integer jmbg);

}

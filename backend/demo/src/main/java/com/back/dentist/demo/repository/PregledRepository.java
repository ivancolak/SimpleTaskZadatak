package com.back.dentist.demo.repository;

import com.back.dentist.demo.entity.Pregled;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PregledRepository extends CrudRepository<Pregled, Integer> {
    Pregled findByVreme(LocalDateTime vreme);
    Iterable<Pregled> findAllByOrderByVreme();
    Iterable<Pregled> findByIdOrderByVreme(Integer id);
}

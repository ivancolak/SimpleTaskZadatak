package com.back.dentist.demo.controller;

import com.back.dentist.demo.entity.Pregled;
import com.back.dentist.demo.repository.PregledRepository;
import com.back.dentist.demo.service.PregledService;
import com.back.dentist.demo.view.PregledView;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RequestMapping(path="/pregled")
public class PregledController {
    @Autowired
    private PregledService pregledService;
    @Autowired
    private PregledRepository pregledRepository;

    @RequestMapping(path="/add", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity addNewUser(@RequestBody PregledView pv){
        pregledService.save(pv);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(path="/all")
    public @ResponseBody
    List<PregledView> getAllPregledi() {
        return pregledService.all();
    }

    @RequestMapping(path="/{id}/allById")
    public @ResponseBody
    List<PregledView> getAllPreglediById(@PathVariable Integer id) {
        return pregledService.allById(id);
    }

    @DeleteMapping(path = "/{pregledId}/delete")
    public void deletePregled(@PathVariable Integer pregledId) throws NotFoundException {
        Pregled p = pregledRepository.findById(pregledId).orElseThrow(() -> new NotFoundException("Ne postoji id"));
        LocalDateTime currentTime = LocalDateTime.now();
        if(!currentTime.plusHours(24).isAfter(p.getVreme()))

            pregledRepository.deleteById(pregledId);

        else throw new java.lang.RuntimeException("Ostalo je manje od 24h do pregleda.");
    }
}

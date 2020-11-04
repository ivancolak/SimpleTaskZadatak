package com.back.dentist.demo.controller;


import com.back.dentist.demo.entity.Pregled;
import com.back.dentist.demo.entity.Zubar;
import com.back.dentist.demo.repository.PregledRepository;
import com.back.dentist.demo.repository.ZubarRepository;
import com.back.dentist.demo.view.PregledViewModel;
import com.back.dentist.demo.view.ZubarViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RequestMapping(path="/zubar")
public class ZubarController {
    @Autowired
    private ZubarRepository zubarRepository;
    private PregledRepository pregledRepository;
    @RequestMapping(path="/add", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity addNewUser (@RequestBody Zubar z) {
        zubarRepository.save(z);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(path="/all")
    public @ResponseBody Iterable<ZubarViewModel> getAllZubars() {

        Iterable<Zubar> zubars = zubarRepository.findAll();

        List<ZubarViewModel> zvmList = new ArrayList<ZubarViewModel>();

        for(Zubar z : zubars){
            ZubarViewModel zvm = new ZubarViewModel();
            zvm.setId(z.getId());
            zvm.setIme(z.getIme());
            zvm.setJmbg(z.getJmbg());
            zvm.setPregledi(new ArrayList<PregledViewModel>());

            for(Pregled p: z.getPregledi()){
                PregledViewModel pvm = new PregledViewModel();

                pvm.setId(p.getId());
                pvm.setZubarIme(p.getZubar().getIme());
                pvm.setPacijentIme(p.getPacijent().getIme());
                pvm.setTrajanje(p.getTrajanje());
                pvm.setVreme(p.getVreme());
                zvm.getPregledi().add(pvm);

            }

            zvmList.add(zvm);

        }
        return zvmList;
    }

    @RequestMapping(path="/{zubarId}")
    public ZubarViewModel getSpecificDoctor(@PathVariable Integer zubarId){
        ZubarViewModel zvm = new ZubarViewModel();
        Zubar z = zubarRepository.findById(zubarId).get();
        zvm.setId(z.getId());
        zvm.setIme(z.getIme());
        zvm.setJmbg(z.getJmbg());
        zvm.setPregledi(new ArrayList<PregledViewModel>());


        for(Pregled p: z.getPregledi()){
            PregledViewModel pvm = new PregledViewModel();

            pvm.setId(p.getId());
            pvm.setZubarIme(p.getZubar().getIme());
            pvm.setPacijentIme(p.getPacijent().getIme());
            pvm.setVreme(p.getVreme());
            pvm.setTrajanje(p.getTrajanje());

            zvm.getPregledi().add(pvm);
        }
        return zvm;
    }

}

package com.back.dentist.demo.controller;

import com.back.dentist.demo.entity.Pacijent;
import com.back.dentist.demo.entity.Pregled;
import com.back.dentist.demo.entity.Zubar;
import com.back.dentist.demo.repository.PacijentRepository;
import com.back.dentist.demo.view.PacijentViewModel;
import com.back.dentist.demo.view.PregledViewModel;
import com.back.dentist.demo.view.ZubarViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RequestMapping(path="/pacijent")
public class PacijentController {
    @Autowired
    private PacijentRepository pacijentRepository;

    @RequestMapping(path="/add", method= RequestMethod.POST)
    public @ResponseBody String addNewUser(@RequestBody Pacijent p){
        pacijentRepository.save(p);
        return "Saved";
    }

    @RequestMapping(path="/{pacijentId}")
    public PacijentViewModel getSpecificDoctor(@PathVariable Integer pacijentId){
        PacijentViewModel pvm = new PacijentViewModel();
        Pacijent p = pacijentRepository.findById(pacijentId).get();
        pvm.setId(p.getId());
        pvm.setIme(p.getIme());
        pvm.setJmbg(p.getJmbg());
        pvm.setPregledi(new ArrayList<PregledViewModel>());


        for(Pregled pr: p.getPregledi()){
            PregledViewModel prvm = new PregledViewModel();

            prvm.setId(pr.getId());
            prvm.setZubarIme(pr.getZubar().getIme());
            prvm.setPacijentIme(pr.getPacijent().getIme());
            prvm.setVreme(pr.getVreme());
            prvm.setTrajanje(pr.getTrajanje());

            pvm.getPregledi().add(prvm);
        }
        return pvm;
    }
}

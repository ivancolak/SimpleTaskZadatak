package com.back.dentist.demo.controller;

import com.back.dentist.demo.entity.Pacijent;
import com.back.dentist.demo.entity.Zubar;
import com.back.dentist.demo.repository.PacijentRepository;
import com.back.dentist.demo.repository.ZubarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // This means that this class is a Controller
//@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET, RequestMethod.DELETE})
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RequestMapping(path="/login") // This means URL's start with /demo (after Application path)
public class LoginController {
    @Autowired
    private ZubarRepository zubarRepository;
    private PacijentRepository pacijentRepository;

    public LoginController(PacijentRepository pacijentRepository) {
        this.pacijentRepository = pacijentRepository;
    }

    @RequestMapping(path="/{username}", produces="text/plain")
    public String checkUserType(@PathVariable Integer username) {
        Zubar zubar = null;
        Pacijent pacijent = null;
        zubar = zubarRepository.findByJmbg(username);

        try {
            if (zubar != null) {
                return "zubar/"+zubar.getId();
            }

            pacijent = pacijentRepository.findByJmbg(username);

            if (pacijent != null) {
                return "pacijent/" + pacijent.getId();
            }

        }
        catch(NullPointerException e ){
            return "null";
        }
        return "null";
    }

}

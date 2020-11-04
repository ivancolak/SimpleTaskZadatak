package com.back.dentist.demo.service;

import com.back.dentist.demo.entity.Pacijent;
import com.back.dentist.demo.entity.Pregled;
import com.back.dentist.demo.entity.Zubar;
import com.back.dentist.demo.repository.PacijentRepository;
import com.back.dentist.demo.repository.PregledRepository;
import com.back.dentist.demo.repository.ZubarRepository;
import com.back.dentist.demo.view.PacijentView;
import com.back.dentist.demo.view.PregledView;
import com.back.dentist.demo.view.ZubarView;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PregledService {
    @Autowired
    private PregledRepository pregledRepository;
    @Autowired
    private PacijentRepository pacijentRepository;
    @Autowired
    private ZubarRepository zubarRepository;
    public void save(PregledView view) {

        Optional<Pacijent> pacijent = pacijentRepository.findById(view.getPacijent().getId());
        Optional<Zubar> zubar = zubarRepository.findById(view.getZubar().getId());

        if(!pacijent.isPresent() || !zubar.isPresent()){
//            throw new NotFoundException
        }

        Pregled entity = new Pregled();
        if(view.getVreme().getHour()>=9 && view.getVreme().plusMinutes(view.getTrajanje()).getHour()<=17) {
            if ((pregledRepository.findByVreme(view.getVreme())) == null) {
                if (((pregledRepository.findByVreme(view.getVreme().minusMinutes(30)) != null
                        && pregledRepository.findByVreme(view.getVreme().minusMinutes(30)).getTrajanje() == 30) ||
                        pregledRepository.findByVreme(view.getVreme().minusMinutes(30)) == null)
                        && ((pregledRepository.findByVreme(view.getVreme().plusMinutes(30)) != null
                        && view.getTrajanje() == 30) || pregledRepository.findByVreme(view.getVreme().plusMinutes(30)) == null)) {

                    entity.setZubar(zubar.get());
                    entity.setPacijent(pacijent.get());
                    entity.setVreme(view.getVreme());
                    entity.setTrajanje(view.getTrajanje());
                    pregledRepository.save(entity);
                } else throw new java.lang.RuntimeException("Preklapanje pregleda.");
            } else throw new java.lang.RuntimeException("Postoji pregled koji pocinje u to vreme.");
        } else throw new java.lang.RuntimeException("Radno vreme je od 9 do 17h.");
    }

    public List<PregledView> all() {
        Iterable<Pregled> all = pregledRepository.findAllByOrderByVreme();

        ArrayList<PregledView> pregledViews = new ArrayList<>();

        for (Pregled pregled: all){
            PregledView pregledView = new PregledView();
            pregledView.setId(pregled.getId());

            PacijentView pacijentView = new PacijentView();
            pacijentView.setId(pregled.getPacijent().getId());
            pacijentView.setIme(pregled.getPacijent().getIme());
            pacijentView.setJmbg(pregled.getPacijent().getJmbg());
            pregledView.setPacijent(pacijentView);


            ZubarView zubarView = new ZubarView();
            zubarView.setId(pregled.getZubar().getId());
            zubarView.setIme(pregled.getZubar().getIme());
            zubarView.setJmbg(pregled.getZubar().getJmbg());
            pregledView.setZubar(zubarView);

            pregledView.setVreme(pregled.getVreme());
            pregledView.setTrajanje(pregled.getTrajanje());

            pregledViews.add(pregledView);

        }

        return pregledViews;
    }

    public List<PregledView> allById(Integer id){
        Iterable<Pregled> all = pregledRepository.findAllByOrderByVreme();

        ArrayList<PregledView> pregledViews = new ArrayList<>();

        for (Pregled pregled: all){
            if (pregled.getPacijent().getId() == id) {
                PregledView pregledView = new PregledView();
                pregledView.setId(pregled.getId());

                PacijentView pacijentView = new PacijentView();
                pacijentView.setId(pregled.getPacijent().getId());
                pacijentView.setIme(pregled.getPacijent().getIme());
                pacijentView.setJmbg(pregled.getPacijent().getJmbg());
                pregledView.setPacijent(pacijentView);


                ZubarView zubarView = new ZubarView();
                zubarView.setId(pregled.getZubar().getId());
                zubarView.setIme(pregled.getZubar().getIme());
                zubarView.setJmbg(pregled.getZubar().getJmbg());
                pregledView.setZubar(zubarView);

                pregledView.setVreme(pregled.getVreme());
                pregledView.setTrajanje(pregled.getTrajanje());

                pregledViews.add(pregledView);
            }
        }

        return pregledViews;
    }
}

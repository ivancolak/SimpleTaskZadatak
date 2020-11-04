package com.back.dentist.demo.view;

import java.util.ArrayList;

public class PacijentViewModel {
    private Integer id, jmbg;
    private String ime;
    private ArrayList<PregledViewModel> pregledi;


    public PacijentViewModel(Integer id, Integer jmbg, String ime, ArrayList<PregledViewModel> pregledi) {
        this.id = id;
        this.jmbg = jmbg;
        this.ime = ime;
        this.pregledi = pregledi;
    }

    public PacijentViewModel() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJmbg() {
        return jmbg;
    }

    public void setJmbg(Integer jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public ArrayList<PregledViewModel> getPregledi() {
        return pregledi;
    }

    public void setPregledi(ArrayList<PregledViewModel> pregledi) {
        this.pregledi = pregledi;
    }



}

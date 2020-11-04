package com.back.dentist.demo.view;

import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

public class PregledViewModel {
    private Integer id;
    private String zubarIme;
    private String pacijentIme;
    private LocalDateTime vreme;
    private Integer trajanje;


    public PregledViewModel(Integer id, String zubarIme, String pacijentIme, LocalDateTime vreme, Integer trajanje) {
        this.id = id;
        this.zubarIme = zubarIme;
        this.pacijentIme = pacijentIme;
        this.vreme = vreme;
        this.trajanje = trajanje;
    }

    public PregledViewModel(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZubarIme() {
        return zubarIme;
    }

    public void setZubarIme(String zubarIme) {
        this.zubarIme = zubarIme;
    }

    public String getPacijentIme() {
        return pacijentIme;
    }

    public void setPacijentIme(String pacijentIme) {
        this.pacijentIme = pacijentIme;
    }

    public LocalDateTime getVreme() {
        return vreme;
    }

    public void setVreme(LocalDateTime vreme) {
        this.vreme = vreme;
    }

    public Integer getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(Integer trajanje) {
        this.trajanje = trajanje;
    }
}

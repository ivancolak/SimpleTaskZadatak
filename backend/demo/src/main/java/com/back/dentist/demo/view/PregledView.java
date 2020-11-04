package com.back.dentist.demo.view;


import java.time.LocalDateTime;

public class PregledView {

    private Integer id;
    private ZubarView zubar;
    private PacijentView pacijent;
    private LocalDateTime vreme;
    private Integer trajanje;

    public PregledView(Integer id, ZubarView zubar, PacijentView pacijent, LocalDateTime vreme, Integer trajanje) {
        this.id = id;
        this.zubar = zubar;
        this.pacijent = pacijent;
        this.vreme = vreme;
        this.trajanje = trajanje;


    }
    public PregledView(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ZubarView getZubar() {
        return zubar;
    }

    public void setZubar(ZubarView zubar) {
        this.zubar = zubar;
    }

    public PacijentView getPacijent() {
        return pacijent;
    }

    public void setPacijent(PacijentView pacijent) {
        this.pacijent = pacijent;
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

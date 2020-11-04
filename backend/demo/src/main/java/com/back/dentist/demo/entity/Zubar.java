package com.back.dentist.demo.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="zubar")
public class Zubar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String ime;
    private Integer jmbg;



    @OneToMany(mappedBy = "zubar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Pregled> pregledi;


    public Zubar() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Integer getJmbg() {
        return jmbg;
    }

    public void setJmbg(Integer jmbg) {
        this.jmbg = jmbg;
    }



    public Set<Pregled> getPregledi() {
        return pregledi;
    }

    public void setPregledi(Set<Pregled> pregledi) {
        this.pregledi = pregledi;
    }
}

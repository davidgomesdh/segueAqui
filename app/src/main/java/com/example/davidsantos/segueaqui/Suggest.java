package com.example.davidsantos.segueaqui;

/**
 * Created by david.santos on 01/03/2018.
 */

public class Suggest {
    private String suggest;
    private String uid;
    private String usuario;


    public Suggest(){

    }

    public Suggest(String suggest, String uid, String usuario) {
        this.suggest = suggest;
        this.uid = uid;
        this.usuario = usuario;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}

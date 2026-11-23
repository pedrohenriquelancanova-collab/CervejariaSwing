/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 2025007300
 */
public class Comentarios {
    int id;
    String sabor;
    String aroma;
    String corpo;
    String aparencia;

    public Comentarios() {
    }

    public Comentarios(String sabor, String aroma, String corpo, String aparencia) {
        this.sabor = sabor;
        this.aroma = aroma;
        this.corpo = corpo;
        this.aparencia = aparencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getAroma() {
        return aroma;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public String getAparencia() {
        return aparencia;
    }

    public void setAparencia(String aparencia) {
        this.aparencia = aparencia;
    }

    @Override
    public String toString() {
        return "Sabor: " + sabor + "\n" +
                "Aroma: " + aroma + "\n"+ 
                "Corpo: " + corpo + "\n" + 
                "Aparencia: " + aparencia;
    }
}

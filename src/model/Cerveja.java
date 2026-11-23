/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author 2025007300
 */
public class Cerveja {
    int id;
    String nome;
    String tipo;
    double teorAlcoolico;
    String ibu;
    String paisOrigem;
    String fabricante;
    Date data;
    String localDegustacao;
    double avaliacao;
    String comentarios;

    public Cerveja() {
    }

    public Cerveja(String nome, String tipo, double teorAlcoolico, String ibu, String paisOrigem, String fabricante, Date data, String localDegustacao, double avaliacao, String comentarios) {
        this.nome = nome;
        this.tipo = tipo;
        this.teorAlcoolico = teorAlcoolico;
        this.ibu = ibu;
        this.paisOrigem = paisOrigem;
        this.fabricante = fabricante;
        this.data = data;
        this.localDegustacao = localDegustacao;
        this.avaliacao = avaliacao;
        this.comentarios = comentarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getTeorAlcoolico() {
        return teorAlcoolico;
    }

    public void setTeorAlcoolico(double teorAlcoolico) {
        this.teorAlcoolico = teorAlcoolico;
    }

    public String getIbu() {
        return ibu;
    }

    public void setIbu(String ibu) {
        this.ibu = ibu;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocalDegustacao() {
        return localDegustacao;
    }

    public void setLocalDegustacao(String localDegustacao) {
        this.localDegustacao = localDegustacao;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return 
                "Nome: " + nome + "\n" + 
                "Tipo: " + tipo + "\n "+
                "Teor Alcoolico: " + teorAlcoolico + "\n "
                +"IBU: " + ibu + "\n "+
                "Pais de origem: " + paisOrigem + "\n" +
                "Fabricante: " + fabricante + "\n"+
                "Data: " + data + "\n" +
                "Local de degustacao: " + localDegustacao + "\n" + 
                "Avaliacao: " + avaliacao + "\n" + 
                "Comentarios: " + comentarios;
    }
}

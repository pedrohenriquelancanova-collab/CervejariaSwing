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
public class Comparacao {
    int id;
    String nome_cerveja;
    String tipo_estilo;
    String teor_alcoolico;
    String IBU;
    String pais_origem;
    String fabricante;
    String avaliacao_atribuia;
    int cer_id;

    public Comparacao() {
    }

    public Comparacao(String nome_cerveja, String tipo_estilo, String teor_alcoolico, String IBU, String pais_origem, String fabricante, String avaliacao_atribuia, int cer_id) {
        this.nome_cerveja = nome_cerveja;
        this.tipo_estilo = tipo_estilo;
        this.teor_alcoolico = teor_alcoolico;
        this.IBU = IBU;
        this.pais_origem = pais_origem;
        this.fabricante = fabricante;
        this.avaliacao_atribuia = avaliacao_atribuia;
        this.cer_id = cer_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_cerveja() {
        return nome_cerveja;
    }

    public void setNome_cerveja(String nome_cerveja) {
        this.nome_cerveja = nome_cerveja;
    }

    public String getTipo_estilo() {
        return tipo_estilo;
    }

    public void setTipo_estilo(String tipo_estilo) {
        this.tipo_estilo = tipo_estilo;
    }

    public String getTeor_alcoolico() {
        return teor_alcoolico;
    }

    public void setTeor_alcoolico(String teor_alcoolico) {
        this.teor_alcoolico = teor_alcoolico;
    }

    public String getIBU() {
        return IBU;
    }

    public void setIBU(String IBU) {
        this.IBU = IBU;
    }

    public String getPais_origem() {
        return pais_origem;
    }

    public void setPais_origem(String pais_origem) {
        this.pais_origem = pais_origem;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getAvaliacao_atribuia() {
        return avaliacao_atribuia;
    }

    public void setAvaliacao_atribuia(String avaliacao_atribuia) {
        this.avaliacao_atribuia = avaliacao_atribuia;
    }

    public int getCer_id() {
        return cer_id;
    }

    public void setCer_id(int cer_id) {
        this.cer_id = cer_id;
    }

    @Override
    public String toString() {
        return "Nome da cerveja: " + nome_cerveja + "\n"+
                "Tipo: " + tipo_estilo + "\n"+
                "Teor alcoolico: " + teor_alcoolico + "\n"+
                "IBU: " + IBU + "\n" +
                "Pais de origem: " + pais_origem +"\n" + 
                "Fabricante: " + fabricante + "\n" +
                "Avaliacao: " + avaliacao_atribuia;
    }
}

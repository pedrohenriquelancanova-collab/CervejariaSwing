package model;

import java.sql.Date;

public class Cerveja {

    int id;
    String nome_cerveja;
    String tipo_estilo;
    String teor_alcoolico;
    String IBU;
    String pais_origem;
    String fabricante;
    Date data_degustacao;
    String local_degustacao;
    double avaliacao;

    public Cerveja() {
    }

    public Cerveja(String nome_cerveja, String tipo_estilo,
            String teor_alcoolico, String IBU, String pais_origem,
            String fabricante, Date data_degustacao,
            String local_degustacao, double avaliacao) {

        this.nome_cerveja = nome_cerveja;
        this.tipo_estilo = tipo_estilo;
        this.teor_alcoolico = teor_alcoolico;
        this.IBU = IBU;
        this.pais_origem = pais_origem;
        this.fabricante = fabricante;
        this.data_degustacao = data_degustacao;
        this.local_degustacao = local_degustacao;
        this.avaliacao = avaliacao;
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

    public Date getData_degustacao() {
        return data_degustacao;
    }

    public void setData_degustacao(Date data_degustacao) {
        this.data_degustacao = data_degustacao;
    }

    public String getLocal_degustacao() {
        return local_degustacao;
    }

    public void setLocal_degustacao(String local_degustacao) {
        this.local_degustacao = local_degustacao;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return "Nome: " + nome_cerveja + "\n"
                + "Tipo: " + tipo_estilo + "\n"
                + "Teor Alcoolico: " + teor_alcoolico + "\n"
                + "IBU: " + IBU + "\n"
                + "Pais de origem: " + pais_origem + "\n"
                + "Fabricante: " + fabricante + "\n"
                + "Data: " + data_degustacao + "\n"
                + "Local de degustacao: " + local_degustacao + "\n"
                + "Avaliacao: " + avaliacao;
    }
}

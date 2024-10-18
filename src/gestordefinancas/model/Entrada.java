package gestordefinancas.model;

import java.time.LocalDate;

// Classe que representa uma entrada financeira
public class Entrada {
    private int id;
    private String nome;
    private String classificacao;
    private double valor;
    private LocalDate dataEntrada;
    private LocalDate dataCadastro;
    private String tipo;

    public Entrada(String nome, String classificacao, double valor, LocalDate dataEntrada, LocalDate dataCadastro, String tipo) {
        this.nome = nome;
        this.classificacao = classificacao;
        this.valor = valor;
        this.dataEntrada = dataEntrada;
        this.dataCadastro = dataCadastro;
        this.tipo = tipo;
    }

    public Entrada() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Entrada{" + "nome=" + nome + ", classificacao=" + classificacao + ", valor=" + valor + ", dataEntrada=" + dataEntrada + ", dataCadastro=" + dataCadastro + '}';
    }
}

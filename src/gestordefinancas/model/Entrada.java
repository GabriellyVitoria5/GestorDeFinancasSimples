package gestordefinancas.model;

import java.time.LocalDate;

// Classe que representa uma entrada financeira
public class Entrada {
    private String nome; // Nome da entrada
    private String classificacao; // Classificação da entrada
    private double valor; // Valor da entrada
    private LocalDate dataEntrada; // Data em que a entrada foi feita
    private LocalDate dataCadastro; // Data em que a entrada foi cadastrada no sistema
    private String tipo; // Tipo de entrada: Ganho ou Despesa

    // Construtor que inicializa todos os atributos da classe
    public Entrada(String nome, String classificacao, double valor, LocalDate dataEntrada, LocalDate dataCadastro, String tipo) {
        this.nome = nome;
        this.classificacao = classificacao;
        this.valor = valor;
        this.dataEntrada = dataEntrada;
        this.dataCadastro = dataCadastro;
        this.tipo = tipo;
    }

    // Construtor padrão sem parâmetros (pode ser utilizado para criar objetos sem inicializar os atributos)
    public Entrada() {

    }

    // Métodos getter e setter para acessar e modificar os atributos da classe

    public String getNome() {
        return nome;
    } // Retorna o nome da entrada

    public void setNome(String nome) {
        this.nome = nome;
    } // Define um novo nome para a entrada

    public String getClassificacao() {
        return classificacao;
    } // Retorna a classificação da entrada

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    } // Define uma nova classificação para a entrada

    public double getValor() {
        return valor;
    } // Retorna o valor da entrada

    public void setValor(double valor) {
        this.valor = valor;
    } // Define um novo valor para a entrada

    public LocalDate getDataEntrada() {
        return dataEntrada;
    } // Retorna a data da entrada

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    } // Define uma nova data para a entrada

    public LocalDate getDataCadastro() {
        return dataCadastro;
    } // Retorna a data de cadastro

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    } // Define uma nova data de cadastro

    public String getTipo() {
        return tipo;
    } // Retorna o tipo

    public void setTipo(String tipo) {
        this.tipo = tipo;
    } // Define o tipo da entrada: saldo ou debito
    
    

    // Método que retorna uma representação em string da entrada
    @Override
    public String toString() {
        return "Entrada{" + "nome=" + nome + ", classificacao=" + classificacao + ", valor=" + valor + ", dataEntrada=" + dataEntrada + ", dataCadastro=" + dataCadastro + '}';
    }
}

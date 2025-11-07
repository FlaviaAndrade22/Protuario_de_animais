package model;
import java.util.ArrayList;
import java.util.List; 

public class Animal {
    private int id;
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private List<Consulta> consultas = new ArrayList<>();

    public Animal(int id, String nome, String especie, String raca, int idade) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }
    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Animal: " + nome + " (" + especie + " - " + raca + ", " + idade + " anos)";
    }
}
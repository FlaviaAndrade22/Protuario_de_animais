package model;
import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private List<Consulta> consultas = new ArrayList<>();

    public Animal(String nome, String especie, String raca, int idade) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public String getNome() { return nome; }

    @Override
    public String toString() {
        return "Animal: " + nome + " (" + especie + " - " + raca + ", " + idade + " anos)";
    }
}

package model;
import java.time.LocalDate;

public class Consulta {
    private int id;
    private LocalDate data;
    private String descricao;
    private Veterinario veterinario;
    private Animal animal;
    private String vacinaAplicada;

    public Consulta(int id, LocalDate data, String descricao, Veterinario veterinario, String vacinaAplicada) {
        this.id = id;
        this.data = data;
        this.descricao = descricao;
        this.veterinario = veterinario;
        this.vacinaAplicada = vacinaAplicada;
    }

    // Getters e Setters
    public int getId() { return id; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Veterinario getVeterinario() { return veterinario; }
    public void setVeterinario(Veterinario veterinario) { this.veterinario = veterinario; }
    public Animal getAnimal() { return animal; }
    public void setAnimal(Animal animal) { this.animal = animal; }
    public String getVacinaAplicada() { return vacinaAplicada; }
    public void setVacinaAplicada(String vacinaAplicada) { this.vacinaAplicada = vacinaAplicada; }

    @Override
    public String toString() {
        return "ID: " + id + " | Consulta em " + data + " - " + descricao +
               (vacinaAplicada != null ? " | Vacina: " + vacinaAplicada : "") +
               " | Veterinário: " + veterinario.getNome() +
               (animal != null ? " | Animal: " + animal.getNome() : "");
    }
}
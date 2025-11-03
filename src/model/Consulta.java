package model;
import java.time.LocalDate;

public class Consulta {
    private LocalDate data;
    private String descricao;
    private Veterinario veterinario;
    private String vacinaAplicada;

    public Consulta(LocalDate data, String descricao, Veterinario veterinario, String vacinaAplicada) {
        this.data = data;
        this.descricao = descricao;
        this.veterinario = veterinario;
        this.vacinaAplicada = vacinaAplicada;
    }

    public LocalDate getData() { return data; }
    public String getDescricao() { return descricao; }
    public Veterinario getVeterinario() { return veterinario; }
    public String getVacinaAplicada() { return vacinaAplicada; }

    @Override
    public String toString() {
        return "Consulta em " + data + " - " + descricao +
               (vacinaAplicada != null ? " | Vacina: " + vacinaAplicada : "") +
               " | Veterinário: " + veterinario.getNome();
    }
}

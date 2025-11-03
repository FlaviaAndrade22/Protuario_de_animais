package model;

public class Veterinario {
    private String nome;
    private String crmv;
    private String especialidade;

    public Veterinario(String nome, String crmv, String especialidade) {
        this.nome = nome;
        this.crmv = crmv;
        this.especialidade = especialidade;
    }

    public String getNome() { return nome; }

    @Override
    public String toString() {
        return nome + " (CRMV: " + crmv + ", Esp.: " + especialidade + ")";
    }
}

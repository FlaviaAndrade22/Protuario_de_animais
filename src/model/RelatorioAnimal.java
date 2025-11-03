package model;

public class RelatorioAnimal extends Relatorio {
    private Animal animal;

    public RelatorioAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void emitirRelatorio() {
        System.out.println("=== RELATÓRIO DO ANIMAL ===");
        System.out.println(animal);
        System.out.println("Histórico de Consultas:");
        for (Consulta c : animal.getConsultas()) {
            System.out.println(" - " + c);
        }
        System.out.println("============================");
    }
}

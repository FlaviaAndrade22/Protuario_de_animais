package main;

import java.time.LocalDate;
import model.*;

public class ClinicaVeterinariaApp {
    public static void main(String[] args) {

        Veterinario vet1 = new Veterinario("Dra. Mariana Silva", "12345-SP", "Clínica Geral");
        Animal animal1 = new Animal("Rex", "Cachorro", "Labrador", 5);

        Consulta consulta1 = new Consulta(LocalDate.of(2025, 3, 15),
                "Check-up anual", vet1, "Antirrábica");
        Consulta consulta2 = new Consulta(LocalDate.of(2025, 8, 2),
                "Tratamento dermatológico", vet1, null);

        animal1.adicionarConsulta(consulta1);
        animal1.adicionarConsulta(consulta2);

        Relatorio relatorioAnimal = new RelatorioAnimal(animal1);
        Relatorio relatorioConsulta = new RelatorioConsulta(consulta1);

        relatorioAnimal.emitirRelatorio();
        relatorioConsulta.emitirRelatorio();
    }
}

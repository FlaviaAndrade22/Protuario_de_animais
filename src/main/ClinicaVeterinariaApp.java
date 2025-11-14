package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.*;

public class ClinicaVeterinariaApp {
    private List<Animal> animais;
    private List<Veterinario> veterinarios;
    private List<Consulta> consultas;
    private Scanner scanner;
    private int nextAnimalId;
    private int nextVetId;
    private int nextConsultaId;

    public ClinicaVeterinariaApp() {
        this.animais = new ArrayList<>();
        this.veterinarios = new ArrayList<>();
        this.consultas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.nextAnimalId = 1;
        this.nextVetId = 1;
        this.nextConsultaId = 1;
        
        // Removida a inicialização com dados de exemplo
        // Agora o sistema começa vazio
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: gerenciarAnimais(); break;
                case 2: gerenciarVeterinarios(); break;
                case 3: gerenciarConsultas(); break;
                case 4: emitirRelatorios(); break;
                case 0: System.out.println("Saindo do sistema..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        scanner.close();
    }

    private void exibirMenuPrincipal() {
        System.out.println("\n=== CLÍNICA VETERINÁRIA ===");
        System.out.println("1. Gerenciar Animais");
        System.out.println("2. Gerenciar Veterinários");
        System.out.println("3. Gerenciar Consultas");
        System.out.println("4. Emitir Relatórios");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void gerenciarAnimais() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR ANIMAIS ===");
            System.out.println("1. Listar Animais");
            System.out.println("2. Cadastrar Animal");
            System.out.println("3. Editar Animal");
            System.out.println("4. Excluir Animal");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: listarAnimais(); break;
                case 2: cadastrarAnimal(); break;
                case 3: editarAnimal(); break;
                case 4: excluirAnimal(); break;
            }
        } while (opcao != 0);
    }

    private void listarAnimais() {
        System.out.println("\n=== LISTA DE ANIMAIS ===");
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
        } else {
            for (Animal animal : animais) {
                System.out.println(animal);
            }
        }
    }

    private void cadastrarAnimal() {
        System.out.println("\n=== CADASTRAR ANIMAL ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Espécie: ");
        String especie = scanner.nextLine();
        System.out.print("Raça: ");
        String raca = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        Animal animal = new Animal(nextAnimalId++, nome, especie, raca, idade);
        animais.add(animal);
        System.out.println("Animal cadastrado com sucesso! ID: " + animal.getId());
    }

    private void editarAnimal() {
        listarAnimais();
        if (animais.isEmpty()) return;
        
        System.out.print("ID do animal a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Animal animal = buscarAnimalPorId(id);
        if (animal != null) {
            System.out.print("Novo nome (" + animal.getNome() + "): ");
            String nome = scanner.nextLine();
            if (!nome.isEmpty()) animal.setNome(nome);

            System.out.print("Nova espécie (" + animal.getEspecie() + "): ");
            String especie = scanner.nextLine();
            if (!especie.isEmpty()) animal.setEspecie(especie);

            System.out.print("Nova raça (" + animal.getRaca() + "): ");
            String raca = scanner.nextLine();
            if (!raca.isEmpty()) animal.setRaca(raca);

            System.out.print("Nova idade (" + animal.getIdade() + "): ");
            String idadeStr = scanner.nextLine();
            if (!idadeStr.isEmpty()) animal.setIdade(Integer.parseInt(idadeStr));

            System.out.println("Animal atualizado com sucesso!");
        } else {
            System.out.println("Animal não encontrado!");
        }
    }

    private void excluirAnimal() {
        listarAnimais();
        if (animais.isEmpty()) return;
        
        System.out.print("ID do animal a excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Animal animal = buscarAnimalPorId(id);
        if (animal != null) {
            animais.remove(animal);
            consultas.removeIf(consulta -> consulta.getAnimal() != null && 
                                         consulta.getAnimal().getId() == id);
            System.out.println("Animal excluído com sucesso!");
        } else {
            System.out.println("Animal não encontrado!");
        }
    }

    private void gerenciarVeterinarios() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR VETERINÁRIOS ===");
            System.out.println("1. Listar Veterinários");
            System.out.println("2. Cadastrar Veterinário");
            System.out.println("3. Editar Veterinário");
            System.out.println("4. Excluir Veterinário");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: listarVeterinarios(); break;
                case 2: cadastrarVeterinario(); break;
                case 3: editarVeterinario(); break;
                case 4: excluirVeterinario(); break;
            }
        } while (opcao != 0);
    }

    private void listarVeterinarios() {
        System.out.println("\n=== LISTA DE VETERINÁRIOS ===");
        if (veterinarios.isEmpty()) {
            System.out.println("Nenhum veterinário cadastrado.");
        } else {
            for (Veterinario vet : veterinarios) {
                System.out.println(vet);
            }
        }
    }

    private void cadastrarVeterinario() {
        System.out.println("\n=== CADASTRAR VETERINÁRIO ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CRMV: ");
        String crmv = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();

        Veterinario vet = new Veterinario(nextVetId++, nome, crmv, especialidade);
        veterinarios.add(vet);
        System.out.println("Veterinário cadastrado com sucesso! ID: " + vet.getId());
    }

    private void editarVeterinario() {
        listarVeterinarios();
        if (veterinarios.isEmpty()) return;
        
        System.out.print("ID do veterinário a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Veterinario vet = buscarVeterinarioPorId(id);
        if (vet != null) {
            System.out.print("Novo nome (" + vet.getNome() + "): ");
            String nome = scanner.nextLine();
            if (!nome.isEmpty()) vet.setNome(nome);

            System.out.print("Novo CRMV (" + vet.getCrmv() + "): ");
            String crmv = scanner.nextLine();
            if (!crmv.isEmpty()) vet.setCrmv(crmv);

            System.out.print("Nova especialidade (" + vet.getEspecialidade() + "): ");
            String especialidade = scanner.nextLine();
            if (!especialidade.isEmpty()) vet.setEspecialidade(especialidade);

            System.out.println("Veterinário atualizado com sucesso!");
        } else {
            System.out.println("Veterinário não encontrado!");
        }
    }

    private void excluirVeterinario() {
        listarVeterinarios();
        if (veterinarios.isEmpty()) return;
        
        System.out.print("ID do veterinário a excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Veterinario vet = buscarVeterinarioPorId(id);
        if (vet != null) {
            if (consultas.stream().anyMatch(c -> c.getVeterinario().getId() == id)) {
                System.out.println("Não é possível excluir: veterinário possui consultas associadas!");
            } else {
                veterinarios.remove(vet);
                System.out.println("Veterinário excluído com sucesso!");
            }
        } else {
            System.out.println("Veterinário não encontrado!");
        }
    }

    private void gerenciarConsultas() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR CONSULTAS ===");
            System.out.println("1. Listar Consultas");
            System.out.println("2. Agendar Consulta");
            System.out.println("3. Editar Consulta");
            System.out.println("4. Excluir Consulta");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: listarConsultas(); break;
                case 2: agendarConsulta(); break;
                case 3: editarConsulta(); break;
                case 4: excluirConsulta(); break;
            }
        } while (opcao != 0);
    }

    private void listarConsultas() {
        System.out.println("\n=== LISTA DE CONSULTAS ===");
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada.");
        } else {
            for (Consulta consulta : consultas) {
                System.out.println(consulta);
            }
        }
    }

    private void agendarConsulta() {
        System.out.println("\n=== AGENDAR CONSULTA ===");
        
        listarAnimais();
        if (animais.isEmpty()) {
            System.out.println("Cadastre um animal primeiro!");
            return;
        }
        System.out.print("ID do animal: ");
        int animalId = scanner.nextInt();
        scanner.nextLine();
        Animal animal = buscarAnimalPorId(animalId);
        if (animal == null) {
            System.out.println("Animal não encontrado!");
            return;
        }

        listarVeterinarios();
        if (veterinarios.isEmpty()) {
            System.out.println("Cadastre um veterinário primeiro!");
            return;
        }
        System.out.print("ID do veterinário: ");
        int vetId = scanner.nextInt();
        scanner.nextLine();
        Veterinario vet = buscarVeterinarioPorId(vetId);
        if (vet == null) {
            System.out.println("Veterinário não encontrado!");
            return;
        }

        System.out.print("Data (AAAA-MM-DD): ");
        String dataStr = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataStr);
        
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        
        System.out.print("Vacina aplicada (deixe em branco se nenhuma): ");
        String vacina = scanner.nextLine();
        if (vacina.isEmpty()) vacina = null;

        Consulta consulta = new Consulta(nextConsultaId++, data, descricao, vet, vacina);
        consulta.setAnimal(animal);
        consultas.add(consulta);
        animal.adicionarConsulta(consulta);
        
        System.out.println("Consulta agendada com sucesso! ID: " + consulta.getId());
    }

    private void editarConsulta() {
        listarConsultas();
        if (consultas.isEmpty()) return;
        
        System.out.print("ID da consulta a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Consulta consulta = buscarConsultaPorId(id);
        if (consulta != null) {
            System.out.print("Nova data (" + consulta.getData() + ") (AAAA-MM-DD): ");
            String dataStr = scanner.nextLine();
            if (!dataStr.isEmpty()) consulta.setData(LocalDate.parse(dataStr));

            System.out.print("Nova descrição (" + consulta.getDescricao() + "): ");
            String descricao = scanner.nextLine();
            if (!descricao.isEmpty()) consulta.setDescricao(descricao);

            System.out.print("Nova vacina (" + 
                (consulta.getVacinaAplicada() != null ? consulta.getVacinaAplicada() : "Nenhuma") + "): ");
            String vacina = scanner.nextLine();
            if (!vacina.isEmpty()) consulta.setVacinaAplicada(vacina);

            System.out.println("Consulta atualizada com sucesso!");
        } else {
            System.out.println("Consulta não encontrada!");
        }
    }

    private void excluirConsulta() {
        listarConsultas();
        if (consultas.isEmpty()) return;
        
        System.out.print("ID da consulta a excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Consulta consulta = buscarConsultaPorId(id);
        if (consulta != null) {
            if (consulta.getAnimal() != null) {
                consulta.getAnimal().getConsultas().remove(consulta);
            }
            consultas.remove(consulta);
            System.out.println("Consulta excluída com sucesso!");
        } else {
            System.out.println("Consulta não encontrada!");
        }
    }

    private void emitirRelatorios() {
        int opcao;
        do {
            System.out.println("\n=== RELATÓRIOS ===");
            System.out.println("1. Relatório de Animal");
            System.out.println("2. Relatório de Consulta");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: emitirRelatorioAnimal(); break;
                case 2: emitirRelatorioConsulta(); break;
            }
        } while (opcao != 0);
    }

    private void emitirRelatorioAnimal() {
        listarAnimais();
        if (animais.isEmpty()) return;
        
        System.out.print("ID do animal: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Animal animal = buscarAnimalPorId(id);
        if (animal != null) {
            Relatorio relatorio = new RelatorioAnimal(animal);
            relatorio.emitirRelatorio();
        } else {
            System.out.println("Animal não encontrado!");
        }
    }

    private void emitirRelatorioConsulta() {
        listarConsultas();
        if (consultas.isEmpty()) return;
        
        System.out.print("ID da consulta: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Consulta consulta = buscarConsultaPorId(id);
        if (consulta != null) {
            Relatorio relatorio = new RelatorioConsulta(consulta);
            relatorio.emitirRelatorio();
        } else {
            System.out.println("Consulta não encontrada!");
        }
    }

    private Animal buscarAnimalPorId(int id) {
        return animais.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private Veterinario buscarVeterinarioPorId(int id) {
        return veterinarios.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private Consulta buscarConsultaPorId(int id) {
        return consultas.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        ClinicaVeterinariaApp app = new ClinicaVeterinariaApp();
        app.iniciar();
    }
}
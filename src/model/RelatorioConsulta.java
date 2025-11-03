package model;

public class RelatorioConsulta extends Relatorio {
    private Consulta consulta;

    public RelatorioConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    @Override
    public void emitirRelatorio() {
        System.out.println("=== RELATÓRIO DE CONSULTA ===");
        System.out.println(consulta);
        System.out.println("==============================");
    }
}

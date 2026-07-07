package View;
import Controler.AgendaController;
import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner = new Scanner(System.in);
    private AgendaController agendaCtlr;

    public MenuPrincipal(AgendaController agendaCtlr){
        this.agendaCtlr = agendaCtlr;
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("===== Agenda Semanal ====");
            System.out.println("1 - Visualizar Grade Semanal (Horários).");
            System.out.println("2 - Cadastrar aulas.");
            System.out.println("0 - Sair do Sistema.");
            System.out.print("#> Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    agendaCtlr.visualizarSemana();
                    break;
                case 2:
                    ViewCadastroAula telaCadastro = new ViewCadastroAula(agendaCtlr);
                    telaCadastro.exibirFormulario();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

package View;
import Controler.AgendaController;
import Model.*;
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
            System.out.println("1 - Visualizar os dias.");
            System.out.println("0 - Sair do Sistema.");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    agendaCtlr.ConstrutorSemana();
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

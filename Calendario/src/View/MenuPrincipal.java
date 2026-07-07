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
            System.out.println("===== SISTEMA ACADÊMICO =====");
            System.out.println("1 - Cadastrar Professores");
            System.out.println("2 - Cadastrar Turmas");
            System.out.println("3 - Visualizar Grade Semanal");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    new ViewCadasProf(agendaCtlr).exibirFormulario();
                    break;
                case 2:
                    new ViewCadasTurma(agendaCtlr).exibirFormulario();
                    break;
                case 3:
                    //Só vai rodar se for True
                    if(agendaCtlr.gerarGradeAuto()) {
                        agendaCtlr.visualizarSemana();
                    }
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

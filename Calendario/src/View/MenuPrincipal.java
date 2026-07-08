package View;
import Controler.AgendaController;
import Controler.ProfessorController;
import Controler.TurmaController;

import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner = new Scanner(System.in);
    private AgendaController agendaCtlr;
    private ProfessorController profCtlr;
    private TurmaController turmaCtlr;


    public MenuPrincipal(AgendaController agendaCtlr, ProfessorController profCtlr, TurmaController turmaCtlr){
        this.agendaCtlr = agendaCtlr;
        this.profCtlr = profCtlr;
        this.turmaCtlr = turmaCtlr;
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
                    new ViewCadasProf(profCtlr).exibirFormulario();
                    break;
                case 2:
                    new ViewCadasTurma(turmaCtlr).exibirFormulario();
                    break;
                case 3:
                    //Só vai rodar se for True
                    if(agendaCtlr.gerarGradeAuto()) {
                        turmaCtlr.visualizarGrades();
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

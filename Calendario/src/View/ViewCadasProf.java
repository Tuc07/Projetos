package View;

import Controler.AgendaController;
import Model.Professor;
import java.util.Scanner;

public class ViewCadasProf {
    private Scanner scan = new Scanner(System.in);
    private AgendaController agendaCtlr;

    public ViewCadasProf(AgendaController agendaCtlr) {
        this.agendaCtlr = agendaCtlr;
    }

    public void exibirFormulario() {
        int opcao = -1;
        //Cadastro Professor
        while (opcao != 0) {
            System.out.println("===== CADASTRO DE PROFESSOR =====");
            System.out.println("1 - Para Cadastrar Professor.");
            System.out.println("0 - Para voltar ao menu principal.");
            System.out.print("#> Escolha: ");
            opcao = scan.nextInt();
            scan.nextLine();

            if (opcao == 1) {
                System.out.print("Nome do Professor: ");
                String nomeProf = scan.nextLine();
                System.out.print("Matéria do Professor: ");
                String matProf = scan.nextLine();

                // Cria o Professor
                Professor professor = new Professor(nomeProf, matProf);

                //Envia a lista para o controller
                agendaCtlr.salvarProfessor(professor);
                System.out.println("Professor cadastrado com sucesso !");
            }
            System.out.println("Voltando ao menu...");
        }
    }
}

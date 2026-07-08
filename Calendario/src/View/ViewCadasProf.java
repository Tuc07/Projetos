package View;

import Controler.AgendaController;
import Controler.ProfessorController;
import Model.Professor;
import Model.SegmentoEscolar;
import java.util.Scanner;

public class ViewCadasProf {
    private Scanner scan = new Scanner(System.in);
    private ProfessorController profCtrl;

    public ViewCadasProf(ProfessorController profCtrl) {
        this.profCtrl = profCtrl;
    }

    public void exibirFormulario() {
        int opcao = -1;
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

                System.out.println("Segmento de Atuação: ");
                System.out.println("1 - 1º ao 5º Ano (Fundamental 1)");
                System.out.println("2 - 6º ao 9º Ano (Fundamental 2)");
                System.out.print("#> Opção: ");
                int segOpcao = scan.nextInt();
                scan.nextLine();

                SegmentoEscolar seg = (segOpcao == 2) ? SegmentoEscolar.FUNDAMENTAL_2 : SegmentoEscolar.FUNDAMENTAL_1;

                // Cria o Professor
                Professor professor = new Professor(nomeProf, matProf, seg);

                //Envia a lista para o controller
                profCtrl.salvarProfessor(professor);
                System.out.println("Professor cadastrado com sucesso !");
            }
        }
        System.out.println("Voltando ao menu...");
    }
}

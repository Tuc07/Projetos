package View;

import Controler.AgendaController;
import Model.Turma;
import java.util.Scanner;

public class ViewCadasTurma {
    private Scanner scan = new Scanner(System.in);
    private AgendaController agendaCtlr;

    public ViewCadasTurma(AgendaController agendaCtlr){
        this.agendaCtlr = agendaCtlr;
    }

    public void exibirFormulario(){
        int opcao = -1;
        while (opcao !=0 ){
            System.out.println("==== CADASTRO TURMA ====");
            System.out.println("1 - Cadastrar Turma.");
            System.out.println("0 - Para voltar ao menu principal.");
            System.out.print("#> Escolha: ");

            opcao = scan.nextInt();
            scan.nextLine();

            if(opcao == 1){
                System.out.print("Ano e letra da turma (ex: 3º Ano A): ");
                String codigo = scan.nextLine();

                //Cria a turma
                Turma turma = new Turma(codigo);

                //Salva a turma
                agendaCtlr.salvarTurma(turma);
                System.out.println("Turma cadastrada com sucesso!");
            }
        }
    }
}

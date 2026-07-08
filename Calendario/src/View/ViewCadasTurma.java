package View;

import Controler.AgendaController;
import Model.Turma;
import Model.Turno;
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

                System.out.println("Selecione o turno da turma:");
                System.out.println("1 - Manhã (07:30 às 12:30)");
                System.out.println("2 - Tarde (13:00 às 18:00)");
                System.out.println("#> Turno:");
                int escolhaTurno = scan.nextInt();
                scan.nextLine();

                //Seleciona o turno
                Turno turnoSelecionado = (escolhaTurno == 2) ? Turno.TARDE : Turno.MANHA;

                //Cria a turma
                Turma turma = new Turma(codigo,turnoSelecionado);

                //Salva a turma
                agendaCtlr.salvarTurma(turma);
                System.out.println("Turma ("+turnoSelecionado+") cadastrada com sucesso!");
            }
        }
    }
}

package View;

import Controler.AgendaController;
import Controler.TurmaController;
import Model.SegmentoEscolar;
import Model.Turma;
import Model.Turno;
import java.util.Scanner;

public class ViewCadasTurma {
    private Scanner scan = new Scanner(System.in);
    private TurmaController turmaCtlr;

    public ViewCadasTurma(TurmaController turmaCtlr){this.turmaCtlr = turmaCtlr;}

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

                //Seleciona o turno
                System.out.println("Selecione o turno da turma:");
                System.out.println("1 - Manhã (07:30 às 12:30)");
                System.out.println("2 - Tarde (13:00 às 18:00)");
                System.out.print("#> Turno:");
                int escolhaTurno = scan.nextInt();
                Turno turnoSelecionado = (escolhaTurno == 2) ? Turno.TARDE : Turno.MANHA;

                System.out.println("Classificação da Turma:");
                System.out.println("1 - 1º ao 5º Ano (Fundamental 1)");
                System.out.println("2 - 6º ao 9º Ano (Fundamental 2)");
                System.out.print("#> Opção:");
                int escolhaSeg = scan.nextInt();
                scan.nextLine();

                SegmentoEscolar segmento = (escolhaSeg == 2) ? SegmentoEscolar.FUNDAMENTAL_2 : SegmentoEscolar.FUNDAMENTAL_1;

                //Cria a turma
                Turma turma = new Turma(codigo,turnoSelecionado, segmento);

                //Salva a turma
                turmaCtlr.salvarTurma(turma);
                System.out.println("Turma ("+turnoSelecionado+") cadastrada com sucesso!");
            }
        }
        System.out.println("Voltando ao menu...");
    }
}

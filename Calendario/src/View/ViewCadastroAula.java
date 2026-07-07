package View;
import Controler.AgendaController;
import Model.Professor;
import Model.Turma;

import java.sql.Date;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ViewCadastroAula {
    private Scanner scan;
    private AgendaController agendaCtlr;

    public ViewCadastroAula(AgendaController agendaCtlr){
        this.agendaCtlr = agendaCtlr;
        this.scan = new Scanner(System.in);
    }

    public void exibirFormulario(){
        System.out.println("===== CADASTRO E VÍNCULO DE AULA =====");

        //Dados Professor
        System.out.print("Nome do Professor: ");
        String nomeProf = scan.nextLine();
        System.out.print("Matéria do Professor: ");
        String matProf = scan.nextLine();
        Professor professor = new Professor(nomeProf,matProf);

        //Dados Turma
        System.out.print("Nome da Turma: ");
        String nomeTurma = scan.nextLine();
        Turma turma = new Turma(nomeTurma);

        //Definição de horario
        System.out.print("Dia da semana (ex: Segunda-feira, Terça-feira...): ");
        String diaSemana = scan.nextLine();

        LocalTime horarioInicio = null;
        while (horarioInicio == null){
            System.out.print("Horário de início do slot (formato H:mm, ex: 07:30, 08:20): ");
            String horaInput = scan.nextLine();
            try{
                horarioInicio = LocalTime.parse(horaInput);
            } catch(DateTimeParseException e){
                System.out.println("Formato de hora inválido! Use o padrão H:mm (ex: 07:30). Tente novamente");
            }
        }
        System.out.println("Enviando os dados para o sistema...");
        agendaCtlr.agendarAula(diaSemana,horarioInicio,matProf,professor,turma);
    }
}

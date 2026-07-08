package Controler;

import Model.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AgendaController {
   private List<Professor> professoresCadastrados;
   private List<Turma> turmasCadastrados;

   public AgendaController(){
       this.professoresCadastrados = new ArrayList<>();
       this.turmasCadastrados = new ArrayList<>();
   }

   public void salvarProfessor(Professor prof){this.professoresCadastrados.add(prof);}
   public void salvarTurma(Turma turma){this.turmasCadastrados.add(turma);}

   //Cadastro Automatizado
    public boolean gerarGradeAuto(){
       if(professoresCadastrados.isEmpty() || turmasCadastrados.isEmpty()){
           System.out.println("Erro: Cadastra pelo menos 1 professor e 1 turma. Tente novamente!");
           return false;
       }

       int indexProfessor = 0;

       // Distribui as aulas para cada turma
        for(Turma turma: turmasCadastrados){
            for(DiaSemana dia: turma.getGradeSemanal()){
                for(SlotAula slot: dia.getSlotsHorarios()) {
                    Professor profDaVez = professoresCadastrados.get(indexProfessor);

                    //Ocupa o slot combinando a matéria do próprio professor
                    slot.ocuparSlot(profDaVez.materia(), profDaVez);

                    //Avança para o próximo professor e Turma
                    indexProfessor = (indexProfessor + 1) % professoresCadastrados.size();
                }
            }
        }
        System.out.println("Sucesso! Grade da semana preenchida.");
        return true;
    }

   //Exibe a agenda Semanal
    public void visualizarTodasGrades(){
       if(turmasCadastrados.isEmpty()) {
           System.out.println("Nenhuma turma cadastrada no sistema.");
           return;
       }
       for(Turma turma : turmasCadastrados){
           turma.exibirGradeCompleta();
       }
    }
}

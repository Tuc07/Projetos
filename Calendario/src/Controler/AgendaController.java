package Controler;

import Model.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AgendaController {
   private List<DiaSemana> semana;
   private List<Professor> professoresCadastrados;
   private List<Turma> turmasCadastrados;

   public AgendaController(){
       this.semana = new ArrayList<>();
       this.professoresCadastrados = new ArrayList<>();
       this.turmasCadastrados = new ArrayList<>();
       inicializarSemana();
   }

   public void salvarProfessor(Professor prof){
       this.professoresCadastrados.add(prof);
   }

   public void salvarTurma(Turma turma){
       this.turmasCadastrados.add(turma);
   }

   //Estrutura de segunda a sexta com slots de 50min
   private void inicializarSemana() {
       String[] diasNomes = {"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira"};

       for(String nomeDia: diasNomes){
           DiaSemana dia = new DiaSemana(nomeDia);

           LocalTime horaAtual = LocalTime.of(7, 30);
           LocalTime horaLimite = LocalTime.of(17,0);

           // Loop que faz as aulas terem 50min
           while (horaAtual.plusMinutes(50).isBefore(horaLimite) || horaAtual.plusMinutes(50).equals(horaLimite)){
               LocalTime fimslot = horaAtual.plusMinutes(50);
               dia.adicionarSlot(new SlotAula(horaAtual, fimslot));
               horaAtual = fimslot; //Avanaça o relogio
           }
           semana.add(dia);
       }
   }

   //Cadastro Automatizado
    public void gerarGradeAuto(){
       if(professoresCadastrados.isEmpty() || turmasCadastrados.isEmpty()){
           System.out.println("Erro: Cadastra pelo menos 1 professor e 1 turma. Tente novamente!");
           return;
       }

       int indexProfessor = 0;
       int indexTurma = 0;

       // Percorre todos os dias
        for(DiaSemana dia : semana){
            //Percorre cada slot
            for(SlotAula slot: dia.getSlotsHorarios()){
                Professor profDaVez = professoresCadastrados.get(indexProfessor);
                Turma turmaDaVez = turmasCadastrados.get(indexTurma);

                //Ocupa o slot combinando a matéria do próprio professor
                slot.ocuparSlot(profDaVez.materia(), profDaVez, turmaDaVez);

                //Avança para o próximo professor e Turma
                indexProfessor = (indexProfessor + 1) % professoresCadastrados.size();
                indexTurma = (indexTurma + 1) % turmasCadastrados.size();
            }
        }
        System.out.println("Sucesso! Grade da semana preenchida.");
    }

   //Exibe a agenda Semanal
    public void visualizarSemana(){
       System.out.println("===== GRADE HORÁRIA DA SEMANA =====");
       for(DiaSemana dia : semana){
           dia.exibirDetalhes();
       }
    }
}

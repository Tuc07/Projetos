package Controler;

import Model.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AgendaController {
   private List<DiaSemana> semana;

   public AgendaController(){
       this.semana = new ArrayList<>();
       inicializarSemana();
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

   //Exibe a agenda Semanal
    public void visualizarSemana(){
       System.out.println("===== GRADE HORÁRIA DA SEMANA =====");
       for(DiaSemana dia : semana){
           dia.exibirDetalhes();
       }
    }

   //Metodo para vincular aula
    public void agendarAula(String nomeDia, LocalTime horarioInicio, String materia, Professor prof, Turma turma) {
        for (DiaSemana dia : semana) {
            if (dia.nome.equalsIgnoreCase(nomeDia)) {
                for (SlotAula slot : dia.getSlotsHorarios()) {
                    if (slot.getHorarioInicio().equals(horarioInicio)) {
                        slot.ocuparSlot(materia, prof, turma);
                        System.out.println("Aula vinculada com sucesso!");
                        return;
                    }
                }
            }
        }
        System.out.println("Erro: Horário Inicial ou dia não encontrado.");
    }
}

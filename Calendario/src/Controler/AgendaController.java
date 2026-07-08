package Controler;

import Model.*;
import java.time.LocalTime;
import java.util.List;

public class AgendaController {

    private ProfessorController profCtrl;
    private TurmaController turmaCtlr;

    public AgendaController(ProfessorController profCtrl, TurmaController turmaCtlr){
        this.profCtrl = profCtrl;
        this.turmaCtlr = turmaCtlr;
    }
   //Cadastro Automatizado
    public boolean gerarGradeAuto(){
        //Busca as listas
        List<Professor> todosProfessores = profCtrl.getProfCadastrados();
        List<Turma> todasTurmas = turmaCtlr.getTurmasCadastradas();

       if(todosProfessores.isEmpty() || todasTurmas.isEmpty()){
           System.out.println("Erro: Cadastra pelo menos 1 professor e 1 turma. Tente novamente!");
           return false;
       }
        //Limpa as grades antigas para evitar duplicidade
       redefinirGrades();

       // Distribui as aulas para cada turma
        for(Turma turma: todasTurmas){
            //Filtra professores do mesmo segmento
            List<Professor> professoresSegmento = profCtrl.filtrarSegmento((turma.getSegmento()));
            if(professoresSegmento.isEmpty()){
                System.out.println("Aviso: Sem professores para o segemento da Turma "+turma.getCodigo());
                continue;
            }

            int indexProfessor = 0;

            for(DiaSemana dia: turma.getGradeSemanal()){
                for(SlotAula slot: dia.getSlotsHorarios()) {

                    //Achar professor do segmento que esteja livre
                    Professor profEscolhido = null;
                    int tentativas = 0;

                    while (tentativas < professoresSegmento.size()){
                        //Não ultrapasse o tamanho da lista
                        indexProfessor = indexProfessor % professoresSegmento.size();
                        Professor candidato = professoresSegmento.get(indexProfessor);

                        //Verifica se o professor da aula em outra turma no mesmo horário
                        if(!professorOcupado(candidato, dia.nome, slot.getHorarioInicio())){
                            profEscolhido = candidato;
                            break;
                        }

                        //Se estiver ocupado avança para o proximo
                        indexProfessor++;
                        tentativas++;
                    }

                    //Ocupa o slot combinando a matéria do próprio professor
                    if(profEscolhido != null){
                        slot.ocuparSlot(profEscolhido.getMateria(), profEscolhido);
                        //Avança para o próximo professor e Turma, usando a lista de segmento
                        indexProfessor = (indexProfessor + 1) % professoresSegmento.size();
                    }
                }
            }
        }
        System.out.println("Sucesso! Grade da semana preenchida.");
        return true;
    }

    //Auxilia a ver se tem choque de horário
    private boolean professorOcupado(Professor prof, String nomeDia, LocalTime horarioInicio){
        List<Turma> todasTurmas = turmaCtlr.getTurmasCadastradas();
        for(Turma t: todasTurmas){
           for(DiaSemana d: t.getGradeSemanal()){
               if(d.nome.equalsIgnoreCase(nomeDia)){
                   for(SlotAula slot: d.getSlotsHorarios()){
                       if(slot.getHorarioInicio().equals(horarioInicio) && slot.isOcupado()){
                           if(slot.getProfessor().equals(prof)){
                               return true;//Professor em aula
                           }
                       }
                   }
               }
           }
       }
       return false;//Professor Livre
    }

    private void redefinirGrades(){
        List<Turma> todasTurmas = turmaCtlr.getTurmasCadastradas();
        for(Turma t: todasTurmas){
           for(DiaSemana d: t.getGradeSemanal()){
               for(SlotAula slot: d.getSlotsHorarios()){
                   slot.limparSlot();
               }
           }
       }
    }
}

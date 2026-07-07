package Model;

import java.time.LocalTime;

public class SlotAula {
    private LocalTime horarioInicio;
    private LocalTime horarioFim;
    private String materia;
    private Professor professor;
    private Turma turma;
    private boolean ocupado;

    public SlotAula(LocalTime horarioInicio, LocalTime horarioFim){
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.ocupado = false;
        this.materia = "Janela Vaga";
    }

    public void ocuparSlot(String materia, Professor professor, Turma turma) {
        this.materia = materia;
        this.professor = professor;
        this.turma = turma;
        this.ocupado = true;
    }

    public LocalTime getHorarioInicio() {return horarioInicio;}
    public LocalTime getHorarioFim(){return horarioFim;}

    @Override
    public String toString(){
        if(!ocupado){
            return String.format("[%s - %s] VAGO", horarioInicio, horarioFim);
        }
        return String.format("[%s - %s] Matéria: %s | Prof: %s | Turma: %s",
                horarioInicio, horarioFim, materia, professor.nome(), turma.codigo());
    }
}

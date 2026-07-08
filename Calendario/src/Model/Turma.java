package Model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Turma{
    private String codigo;
    private Turno turno;
    private List<DiaSemana> gradeSemanal;

    public Turma(String codigo, Turno turno){
        this.codigo = codigo;
        this.turno = turno;
        this.gradeSemanal = new ArrayList<>();
        inicializarGradeTurma();
    }

    //Monta horários por turno
    private void inicializarGradeTurma(){
        String[] diasNomes = {"Segunda-feira", "Terça-feira", "Quarta-feira","Quinta-feira","Sexta-ferira"};

        //Define o turno
        LocalTime horaAtual = (this.turno == turno.MANHA) ? LocalTime.of(7,30) : LocalTime.of(13,0);
        LocalTime horaLimite = (this.turno == turno.MANHA) ? LocalTime.of(12,30) : LocalTime.of(18,0);

        for(String nomeDia : diasNomes){
            DiaSemana dia = new DiaSemana(nomeDia);
            LocalTime relogio = horaAtual;
            // Loop que faz as aulas terem 50min
            while(relogio.plusMinutes(50).isBefore(horaLimite) || relogio.plusMinutes(50).equals(horaLimite)){
                LocalTime fimslot = relogio.plusMinutes(50);
                dia.adicionarSlot(new SlotAula(relogio, fimslot));
                relogio = fimslot;
            }
            gradeSemanal.add(dia);
        }
    }

    public String getCodigo(){return codigo;}
    public Turno getTurno(){return turno;}
    public List<DiaSemana> getGradeSemanal(){return gradeSemanal;}

    public void exibirGradeCompleta(){
        System.out.println("=================================================");
        System.out.println("GRADE HORÁRIA DA TURMA: "+ codigo +" ("+turno+") ");
        System.out.println("=================================================");
        for(DiaSemana dia: gradeSemanal){
            dia.exibirDetalhes();
        }
    }
}

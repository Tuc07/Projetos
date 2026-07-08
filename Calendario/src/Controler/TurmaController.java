package Controler;

import Model.Turma;
import java.util.ArrayList;
import java.util.List;

public class TurmaController {
    private List<Turma> turmasCadastradas;

    public TurmaController(){this.turmasCadastradas = new ArrayList<>();}
    public void salvarTurma(Turma turma){this.turmasCadastradas.add(turma);}
    public List<Turma> getTurmasCadastradas(){return turmasCadastradas;}

    public void visualizarGrades(){
        if(turmasCadastradas.isEmpty()){
            System.out.println("Nenhuma turma cadastrada no sistema.");
            return;
        }
        for(Turma turma: turmasCadastradas){
            turma.exibirGradeCompleta();
        }
    }
}

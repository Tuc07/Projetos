package Controler;

import Model.Professor;
import Model.SegmentoEscolar;
import java.util.ArrayList;
import java.util.List;

public class ProfessorController {
    private List<Professor> profCadastrados;

    public ProfessorController(){this.profCadastrados = new ArrayList<>();}
    public void salvarProfessor(Professor prof){this.profCadastrados.add(prof);}
    public List<Professor> getProfCadastrados(){ return profCadastrados; }

    //Filtra os Professores
    public List<Professor> filtrarSegmento(SegmentoEscolar segmento){
        List<Professor> filtrados = new ArrayList<>();
        for(Professor p: profCadastrados){
            if(p.getsegmento() == segmento){
                filtrados.add(p);
            }
        }
        return filtrados;
    }
}

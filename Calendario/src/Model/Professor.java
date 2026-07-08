package Model;

public class Professor {
    private String nome;
    private String materia;
    private SegmentoEscolar segmento;

    public Professor(String nome, String materia, SegmentoEscolar segmento){
        this.nome = nome;
        this.materia = materia;
        this.segmento = segmento;
    }

    public String getnome(){return nome;}
    public String getMateria(){return materia;}
    public SegmentoEscolar getsegmento(){return segmento;}
}

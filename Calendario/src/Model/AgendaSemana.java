package Model;

public abstract class AgendaSemana {
    public String nome;
    protected int horarios;

    public AgendaSemana(String nome, int horarios){
        this.nome = nome;
        this.horarios = horarios;
    }

    public abstract void nome();
    public abstract void horarios();
}

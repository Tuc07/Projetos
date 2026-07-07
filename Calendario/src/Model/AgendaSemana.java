package Model;

public abstract class AgendaSemana {
    public String nome;

    public AgendaSemana(String nome){
        this.nome = nome;
    }

    public abstract void exibirDetalhes();
}

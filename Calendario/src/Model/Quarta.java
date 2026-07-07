package Model;

public class Quarta extends AgendaSemana{
    public Quarta (String nome, int horarios) {
        super("Quarta", horarios);
    }

    @Override
    public void nome(){
        System.out.println(this.nome);
    }

    @Override
    public void horarios(){

    }
}

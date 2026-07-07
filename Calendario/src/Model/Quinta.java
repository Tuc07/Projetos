package Model;

public class Quinta extends AgendaSemana{
    public Quinta (String nome, int horarios) {
        super("Quinta", horarios);
    }

    @Override
    public void nome(){
        System.out.println(this.nome);
    }

    @Override
    public void horarios(){

    }
}

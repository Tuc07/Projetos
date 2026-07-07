package Model;

public class Sexta extends AgendaSemana{
    public Sexta (String nome, int horarios) {
        super("Sexta", horarios);
    }

    @Override
    public void nome(){
        System.out.println(this.nome);
    }

    @Override
    public void horarios(){

    }
}

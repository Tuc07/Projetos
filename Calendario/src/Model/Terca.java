package Model;

public class Terca extends AgendaSemana{
    public Terca(String nome, int horarios) {
        super("Terça", horarios);
    }

    @Override
    public void nome(){
        System.out.println(this.nome);
    }

    @Override
    public void horarios(){

    }
}

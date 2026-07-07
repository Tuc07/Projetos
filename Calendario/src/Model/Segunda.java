package Model;

public class Segunda extends AgendaSemana {
    public Segunda (String nome, int horarios) {
        super("Segunda", horarios);
    }
    @Override
    public void nome(){
        System.out.println(this.nome);
    }
    @Override
    public void horarios(){

    }


}

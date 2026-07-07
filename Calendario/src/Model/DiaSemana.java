package Model;

import java.util.ArrayList;
import java.util.List;

public class DiaSemana extends AgendaSemana{
    private List<SlotAula> slotsHorarios;

    public DiaSemana(String nome){
        super(nome);
        this.slotsHorarios = new ArrayList<>();
    }

    public void adicionarSlot(SlotAula slot){
        this.slotsHorarios.add(slot);
    }

    public List<SlotAula> getSlotsHorarios(){
        return slotsHorarios;
    }

    @Override
    public void exibirDetalhes(){
        System.out.println("--- "+this.nome+ "---");
        if(slotsHorarios.isEmpty()){
            System.out.println("Nenhuma aula gerada para este dia.");
            return;
        }

        for (SlotAula slot : slotsHorarios){
            System.out.println(slot);
        }
    }
}

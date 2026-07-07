package Controler;

import Model.*;

public class AgendaController {
    private AgendaSemana segunda;
    private AgendaSemana terca;
    private AgendaSemana quarta;
    private AgendaSemana quinta;
    private AgendaSemana sexta;

    public void ConstrutorSemana(){
        this.segunda = new Segunda("Segunda", 8);
        this.terca = new Terca("Segunda", 8);
        this.quarta = new Quarta("Segunda", 8);
        this.quinta = new Quinta("Segunda", 8);
        this.sexta = new Sexta("Segunda", 8);
         System.out.println("Dias: "+ segunda.nome+" | "+ terca.nome+" | "+ quarta.nome+" | "+ quinta.nome+" | "+ sexta.nome);
    }


}

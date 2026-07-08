import Controler.AgendaController;
import Controler.ProfessorController;
import Controler.TurmaController;
import View.MenuPrincipal;

public class Main {
    public static void main(String[] args) {

        ProfessorController profCtlr = new ProfessorController();
        TurmaController turmaCtlr = new TurmaController();
        AgendaController agendaCtrl = new AgendaController(profCtlr, turmaCtlr);
        MenuPrincipal menu = new MenuPrincipal(agendaCtrl, profCtlr, turmaCtlr);
        menu.exibirMenu();
    }
}

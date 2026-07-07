import Controler.AgendaController;
import View.MenuPrincipal;

public class Main {
    public static void main(String[] args) {

        AgendaController controller = new AgendaController();
        MenuPrincipal menu = new MenuPrincipal(controller);

        menu.exibirMenu();
    }
}

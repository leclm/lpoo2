package tpoo2;

import tpoo2.controller.ClienteController;
import tpoo2.dao.ClienteDao;
import tpoo2.view.CadastrarClienteView;

public class Main {
    public static void main(String[] args) {
        CadastrarClienteView cadastrarClienteView = new CadastrarClienteView();
        ClienteDao clienteDao = new ClienteDao();
        ClienteController controller = new ClienteController(cadastrarClienteView, clienteDao);
    }
}

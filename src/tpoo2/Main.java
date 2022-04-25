package tpoo2;

import tpoo2.controller.CadastrarClienteController;
import tpoo2.dao.ClienteDao;
import tpoo2.view.CadastrarClienteView;

public class Main {
    public static void main(String[] args) {
        CadastrarClienteView cadastrarClienteView = new CadastrarClienteView();
        ClienteDao clienteDao = new ClienteDao();
        CadastrarClienteController controller = new CadastrarClienteController(cadastrarClienteView, clienteDao);
    }
}

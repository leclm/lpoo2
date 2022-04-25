package tpoo2.controller;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tpoo2.dao.ClienteDao;
import tpoo2.dao.ContaDao;
import tpoo2.model.Cliente;
import tpoo2.model.Conta;
import tpoo2.view.VincularContaView;

public class VincularContaController {
    private VincularContaView view;
    private ContaDao contaDao;
    private ClienteDao clienteDao;
    
    
    /*
    *** CONSTRUTOR
    */
    public VincularContaController(VincularContaView view, ContaDao contaDao) {
        this.view = view;
        this.contaDao = contaDao;
        initController();
    }
    
    
    /*
    *** INIT
    */
    private void initController(){
        this.view.setController(this);
        this.view.initView();
    }
    
    /*
    *** INSERT
    */
    public void InsertConta() {
        try {
            Conta conta = view.getContaFormulario();
            Cliente cliente = conta.getDono();
            
            contaDao.insertConta(conta);
            clienteDao.insertContaCliente(cliente, conta);
            
        } catch(Exception ex) {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro ao criar conta.\n"
                    + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
}

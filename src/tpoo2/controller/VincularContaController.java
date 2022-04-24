package tpoo2.controller;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tpoo2.dao.ContaDao;
import tpoo2.model.Cliente;
import tpoo2.model.Conta;
import tpoo2.view.VincularContaView;

public class VincularContaController {
    private VincularContaView vincularContaView;
    private ContaDao contaDao;
    
    
    /*
    *** CONSTRUTOR
    */
    public VincularContaController(VincularContaView vincularContaView, ContaDao contaDao) {
        this.vincularContaView = vincularContaView;
        this.contaDao = contaDao;
        initController();
    }
    
    
    /*
    *** INIT
    */
    private void initController(){
        this.vincularContaView.setController(this);
        this.vincularContaView.initView();
    }
    
    /*
    *** INSERT
    */
    public void InsertConta() {
        /*try {
            Conta conta = vincularContaView.tabVincularContaComponentShown();
            
            
            tabelaVincularContaMouseClicked();
            cbContasItemStateChanged();
            incluirContaMouseClicked();
            
            
            clienteDao.insertCliente(cliente);
            cadastrarClienteView.inserirClienteView(cliente);
            
        } catch(Exception ex) {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro ao vincular conta.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }*/
    }
    
}

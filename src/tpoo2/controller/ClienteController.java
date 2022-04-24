package tpoo2.controller;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tpoo2.dao.ClienteDao;
import tpoo2.model.Cliente;
import tpoo2.view.CadastrarClienteView;

public class ClienteController {
    private CadastrarClienteView cadastrarClienteView;
    private ClienteDao clienteDao;
    
    
    /*
    *** CONSTRUTOR
    */
    public ClienteController(CadastrarClienteView cadastrarClienteView, ClienteDao clienteDao) {
        this.cadastrarClienteView = cadastrarClienteView;
        this.clienteDao = clienteDao;
        initController();
    }
    
    
    /*
    *** INIT
    */
    private void initController(){
        this.cadastrarClienteView.setController(this);
        this.cadastrarClienteView.initView();
    }
    
    
    /*
    *** INSERT
    */
    public void InsertCliente() {
        try {
            Cliente cliente = cadastrarClienteView.getClienteFormulario();
            clienteDao.insertCliente(cliente);
            cadastrarClienteView.inserirClienteView(cliente);
            
        } catch(Exception ex) {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro ao criar cliente.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }

    
    /*
    *** DELETE
    */
    public void DeleteCliente() {
        try {
            List<Cliente> listaParaExcluir = cadastrarClienteView.getClientesParaExcluir();
            clienteDao.deleteLista(listaParaExcluir);
            cadastrarClienteView.excluirClienteView(listaParaExcluir);
            
        } catch(Exception ex){
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro ao excluir cliente.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }

    
    /*
    *** UPDATE
    */
    public void UpdateCliente() {
        try {
            Cliente cliente = cadastrarClienteView.getClienteParaAtualizar();
            
            if(cliente == null) {
                JFrame jFrame = new JFrame();
                JOptionPane.showMessageDialog(jFrame, "Selecione um Cliente na tabela para atualizar.",
                        "Info", JOptionPane.ERROR_MESSAGE);
                
                return;
            }
            
            clienteDao.updateCliente(cliente);
            cadastrarClienteView.alterarClienteView(cliente);
            
        } catch(Exception ex) {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro ao atualizar cliente.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
}

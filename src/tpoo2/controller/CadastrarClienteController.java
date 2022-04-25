package tpoo2.controller;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tpoo2.dao.ClienteDao;
import tpoo2.model.Cliente;
import tpoo2.view.CadastrarClienteView;

public class CadastrarClienteController {
    private CadastrarClienteView view;
    private ClienteDao clienteDao;
    
    
    /*
    *** CONSTRUTOR
    */
    public CadastrarClienteController(CadastrarClienteView view, ClienteDao clienteDao) {
        this.view = view;
        this.clienteDao = clienteDao;
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
    public void InsertCliente() {
        try {
            Cliente cliente = view.getClienteFormulario();
            clienteDao.insertCliente(cliente);
            view.inserirClienteView(cliente);
            
        } catch(Exception ex) {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro ao criar cliente.\n"
                    + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }

    
    /*
    *** DELETE
    */
    public void DeleteCliente() {
        try {
            List<Cliente> listaParaExcluir = view.getClientesParaExcluir();
            clienteDao.deleteLista(listaParaExcluir);
            view.excluirClienteView(listaParaExcluir);
            
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
            Cliente cliente = view.getClienteParaAtualizar();
            
            if(cliente == null) {
                JFrame jFrame = new JFrame();
                JOptionPane.showMessageDialog(jFrame, "Selecione um Cliente na tabela para atualizar.",
                        "Info", JOptionPane.ERROR_MESSAGE);
                
                return;
            }
            
            clienteDao.updateCliente(cliente);
            view.alterarClienteView(cliente);
            
        } catch(Exception ex) {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro ao atualizar cliente.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
    
    
    /*
    *** LISTAR
    */
    public void getClientes() {
        try {
            List<Cliente> clientes;
            clientes = clienteDao.listClientes();
            this.view.listarClienteView(clientes);
            
        } catch(Exception ex) {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro ao recuperar clientes.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
}

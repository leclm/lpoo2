package tpoo2.controller;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tpoo2.dao.ContaDao;
import tpoo2.model.Conta;
import tpoo2.view.ManipularContaView;

public class ManipularContaController {
    private ManipularContaView view;
    private Conta conta;
    private ContaDao contaDao;
    
    
    /*
    *** CONSTRUTOR
    */
    public ManipularContaController(ManipularContaView view, ContaDao contaDao) {
        this.view = view;
        this.conta = conta;
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
    *** INFORMAR
    */
    public void Informar() {
        try {
            String cpf = this.view.getCpfFormulario();
            List<Conta> contas;

            contas = this.contaDao.getContasByCpf(cpf);
            this.view.AtualizarTabelaConta(contas);
            
        } catch(Exception ex) {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro ao recuperar contas.\n"
                    + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
    
    
    /*
    *** ATUALIZAR SALDO
    */
    public void AtualizarSaldo(Conta conta) {
        try {
            this.contaDao.atualizarSaldo(conta);
            
        } catch(Exception ex) {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro ao atualizar saldo.\n"
                    + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
    
    
    /*
    *** VER SALDO
    */
    public void VerSaldo() {
          try {
              Conta conta = this.view.getContaClicada();
              double saldo = this.contaDao.getSaldo(conta);
              this.view.verSaldo(saldo);
              
          } catch(Exception ex) {
              JFrame jFrame = new JFrame();
              JOptionPane.showMessageDialog(jFrame, "Erro ao ver saldo.\n"
                      + ex.getMessage(),
                      "Erro", JOptionPane.ERROR_MESSAGE);

              throw new RuntimeException();
          }
      }
}

package tpoo2.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tpoo2.dao.ContaDao;
import tpoo2.model.Conta;
import tpoo2.view.ManipularContaView;

public class ManipularContaController {
    private ManipularContaView manipularContaView;
    private Conta conta;
    
    /*
    *** CONSTRUTOR
    */
    public ManipularContaController(ManipularContaView manipularContaView, ContaDao contaDao) {
        this.manipularContaView = manipularContaView;
        this.conta = conta;
        initController();
    }
    
    
    /*
    *** INIT
    */
    private void initController(){
        this.manipularContaView.setController(this);
        this.manipularContaView.initView();
    }
    
    /*
    *** SACAR
    */
    public void Saca() {
        try {
            double valor = 0;
            conta.saca(valor);
            /*  manipularContaView.SacaMouseClicked();*/
            
        } catch(Exception ex) {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Erro ao sacar.\n"
                    + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }

    
     /*
    *** DEPOSITAR
    */
    public void Deposita() {
          try {
              /*conta.deposita();
              manipularContaView.DepositaMouseClicked(); */

          } catch(Exception ex) {
              JFrame jFrame = new JFrame();
              JOptionPane.showMessageDialog(jFrame, "Erro ao depositar.\n"
                      + ex.getMessage(),
                      "Erro", JOptionPane.ERROR_MESSAGE);

              throw new RuntimeException();
          }
      }
    
    
     /*
    *** VER SALDO
    */
    public void VeSaldo() {
          try {
              conta.getSaldo();
              
          } catch(Exception ex) {
              JFrame jFrame = new JFrame();
              JOptionPane.showMessageDialog(jFrame, "Erro ao ver saldo.\n"
                      + ex.getMessage(),
                      "Erro", JOptionPane.ERROR_MESSAGE);

              throw new RuntimeException();
          }
      }
    
     /*
    *** REMUNERAR
    */
    public void Remunera() {
          try {
              conta.remunera();
              /* manipularContaView.RemuneraMouseClicked();*/

          } catch(Exception ex) {
              JFrame jFrame = new JFrame();
              JOptionPane.showMessageDialog(jFrame, "Erro ao remunerar.\n"
                      + ex.getMessage(),
                      "Erro", JOptionPane.ERROR_MESSAGE);

              throw new RuntimeException();
          }
      }
}

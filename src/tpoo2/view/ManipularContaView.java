package tpoo2.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tpoo2.controller.ClienteController;
import tpoo2.controller.ManipularContaController;
import tpoo2.model.ContaCorrente;
import tpoo2.model.ContaInvestimento;

public class ManipularContaView extends javax.swing.JFrame {
    private final ModeloTabelaConta modelo = new ModeloTabelaConta();
    private final ModeloTabelaContaCorrente modeloContaCorrente = new ModeloTabelaContaCorrente();
    private final List<ContaCorrente> listaManipulaContaCorrente = new ArrayList();
    private final ModeloTabelaContaInvestimento modeloContaInvestimento = new ModeloTabelaContaInvestimento();
    private final List<ContaInvestimento> listaManipulaContaInvestimento = new ArrayList();



    private int linhaClicada = -1;
    
     JFrame jFrame = new JFrame();
    
    /*
    *** CONSTRUTOR
    */
    public ManipularContaView() {
        initComponents();
        tabelaManipularConta.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabManipularConta = new javax.swing.JPanel();
        informarCPF = new javax.swing.JLabel();
        tInformarCPF = new javax.swing.JTextField();
        Informar = new java.awt.Button();
        scroll2 = new javax.swing.JScrollPane();
        tabelaManipularConta = new javax.swing.JTable();
        saque = new javax.swing.JLabel();
        tSaque = new javax.swing.JTextField();
        Sacar = new java.awt.Button();
        deposito = new javax.swing.JLabel();
        tDeposito = new javax.swing.JTextField();
        Depositar = new java.awt.Button();
        VerSaldo = new java.awt.Button();
        Remunerar = new java.awt.Button();
        saldoAtual = new javax.swing.JLabel();
        verSaldo = new javax.swing.JLabel();
        bVincularConta = new javax.swing.JButton();
        bManipularConta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        informarCPF.setText("Informe o CPF do cliente para listarmos suas contas:");

        Informar.setBackground(new java.awt.Color(33, 136, 56));
        Informar.setForeground(new java.awt.Color(240, 240, 240));
        Informar.setLabel("Informar");

        tabelaManipularConta.setModel(modelo);
        scroll2.setViewportView(tabelaManipularConta);

        saque.setText("Saque:");

        Sacar.setBackground(new java.awt.Color(33, 136, 56));
        Sacar.setForeground(new java.awt.Color(240, 240, 240));
        Sacar.setLabel("Sacar");

        deposito.setText("Depósito:");

        Depositar.setBackground(new java.awt.Color(33, 136, 56));
        Depositar.setForeground(new java.awt.Color(240, 240, 240));
        Depositar.setLabel("Depositar");

        VerSaldo.setBackground(new java.awt.Color(33, 136, 56));
        VerSaldo.setForeground(new java.awt.Color(240, 240, 240));
        VerSaldo.setLabel("Ver Saldo");

        Remunerar.setBackground(new java.awt.Color(33, 136, 56));
        Remunerar.setForeground(new java.awt.Color(240, 240, 240));
        Remunerar.setLabel("Remunerar");

        saldoAtual.setText("O saldo atual é:");

        verSaldo.setText("...");

        bVincularConta.setBackground(new java.awt.Color(33, 136, 56));
        bVincularConta.setForeground(new java.awt.Color(240, 240, 240));
        bVincularConta.setText("Vincular Conta");
        bVincularConta.setAutoscrolls(true);
        bVincularConta.setBorder(null);
        bVincularConta.setMaximumSize(new java.awt.Dimension(92, 20));
        bVincularConta.setMinimumSize(new java.awt.Dimension(92, 20));

        bManipularConta.setBackground(new java.awt.Color(224, 168, 0));
        bManipularConta.setForeground(new java.awt.Color(0, 0, 0));
        bManipularConta.setText("Cadastrar Cliente");
        bManipularConta.setBorder(null);

        javax.swing.GroupLayout tabManipularContaLayout = new javax.swing.GroupLayout(tabManipularConta);
        tabManipularConta.setLayout(tabManipularContaLayout);
        tabManipularContaLayout.setHorizontalGroup(
            tabManipularContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabManipularContaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabManipularContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabManipularContaLayout.createSequentialGroup()
                        .addComponent(informarCPF)
                        .addGap(18, 18, 18)
                        .addComponent(tInformarCPF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Informar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scroll2, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                    .addGroup(tabManipularContaLayout.createSequentialGroup()
                        .addGroup(tabManipularContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabManipularContaLayout.createSequentialGroup()
                                .addComponent(saldoAtual)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(verSaldo))
                            .addGroup(tabManipularContaLayout.createSequentialGroup()
                                .addComponent(VerSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Remunerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(tabManipularContaLayout.createSequentialGroup()
                        .addGroup(tabManipularContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deposito)
                            .addComponent(saque))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabManipularContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabManipularContaLayout.createSequentialGroup()
                                .addComponent(tSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Sacar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(tabManipularContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bManipularConta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bVincularConta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(tabManipularContaLayout.createSequentialGroup()
                                .addComponent(tDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Depositar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        tabManipularContaLayout.setVerticalGroup(
            tabManipularContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabManipularContaLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(tabManipularContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tabManipularContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tInformarCPF)
                        .addComponent(informarCPF))
                    .addComponent(Informar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bVincularConta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(tabManipularContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabManipularContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(tabManipularContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tSaque)
                            .addComponent(saque))
                        .addComponent(Sacar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bManipularConta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(tabManipularContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tabManipularContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tDeposito)
                        .addComponent(deposito))
                    .addComponent(Depositar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabManipularContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VerSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Remunerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabManipularContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saldoAtual)
                    .addComponent(verSaldo))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tabManipularConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tabManipularConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
     /*
    *** INIT
    */
    public void initView() {
        java.awt.EventQueue.invokeLater(() -> this.setVisible(true));
    }
    
    
     /*
    *** CONTROLLER
    */
    public void setController(ManipularContaController controller) {
        saca.addActionListener(e -> controller.saca());
        deposita.addActionListener(e -> controller.deposita());
        veSaldo.addActionListener(e -> controller.veSaldo());
        remunera.addActionListener(e -> controller.remunera());
    }
    
      /*
    *** SACAR
    */
    private void SacaMouseClicked(java.awt.event.MouseEvent evt) {
        saldoAtual.setVisible(false);
        verSaldo.setVisible(false);
        
        try {
            double saque = Double.parseDouble(tSaque.getText());
            boolean resultadoSaque;
            
            if (tabelaManipularConta.getModel() == modeloContaCorrente) {
                ContaCorrente conta = modeloContaCorrente.getContaCorrente(linhaClicada);
                resultadoSaque = conta.saca(saque);
                
                if (resultadoSaque) {
                    JOptionPane.showMessageDialog(jFrame, "O Saque foi concluído!", 
                            "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                    modeloContaCorrente.atualizarTabela(listaManipulaContaCorrente);
                }
            }
            
            if (tabelaManipularConta.getModel() == modeloContaInvestimento) {
                ContaInvestimento conta = modeloContaInvestimento.getContaInvestimento(linhaClicada);
                resultadoSaque = conta.saca(saque);
                
                if (resultadoSaque) {
                    JOptionPane.showMessageDialog(jFrame, "O Saque foi concluído!", 
                            "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                    modeloContaInvestimento.atualizarTabela(listaManipulaContaInvestimento);
                }
            }
        } catch(NumberFormatException nfe) {
            JOptionPane.showMessageDialog(jFrame, "O Saque deve ser numérico!", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

     /*
    *** DEPOSITAR
    */
      private void DepositaMouseClicked(java.awt.event.MouseEvent evt) {
        saldoAtual.setVisible(false);
        verSaldo.setVisible(false);
        
        try {
            double deposito = Double.parseDouble(tDeposito.getText());
            boolean resultadoDeposito;
            
            if (tabelaManipularConta.getModel() == modeloContaCorrente) {
                ContaCorrente conta = modeloContaCorrente.getContaCorrente(linhaClicada);
                resultadoDeposito = conta.deposita(deposito);
                
                if (resultadoDeposito) {
                    JOptionPane.showMessageDialog(jFrame, "O Depósito foi concluído!", 
                            "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                    modeloContaCorrente.atualizarTabela(listaManipulaContaCorrente);
                }
            }
            
            if (tabelaManipularConta.getModel() == modeloContaInvestimento) {
                ContaInvestimento conta = modeloContaInvestimento.getContaInvestimento(linhaClicada);
                resultadoDeposito = conta.deposita(deposito);
                
                if (resultadoDeposito) {
                    JOptionPane.showMessageDialog(jFrame, "O Depósito foi concluído!", 
                            "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                    modeloContaInvestimento.atualizarTabela(listaManipulaContaInvestimento);
                }
            }
        } catch(NumberFormatException nfe) {
            JOptionPane.showMessageDialog(jFrame, "O Depósito deve ser numérico!", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
     /*
    *** VER SALDO
    */
    private void VeSaldoMouseClicked(java.awt.event.MouseEvent evt) {
        saldoAtual.setVisible(true);
        verSaldo.setVisible(true);
        
        if (tabelaManipularConta.getModel() == modeloContaCorrente) {
            ContaCorrente conta = modeloContaCorrente.getContaCorrente(linhaClicada);
            String saldoDaConta = Double.toString(conta.getSaldo());

            verSaldo.setText("R$" + saldoDaConta);
        }
            
        if (tabelaManipularConta.getModel() == modeloContaInvestimento) {
            ContaInvestimento conta = modeloContaInvestimento.getContaInvestimento(linhaClicada);
            String saldoDaConta = Double.toString(conta.getSaldo());

            verSaldo.setText("R$" + saldoDaConta);
        }
    }
    
     /*
    *** REMUNERAR
    */
    
     private void RemuneraMouseClicked(java.awt.event.MouseEvent evt) {
        saldoAtual.setVisible(false);
        verSaldo.setVisible(false);
        
        if (tabelaManipularConta.getModel() == modeloContaCorrente) {
            ContaCorrente conta = modeloContaCorrente.getContaCorrente(linhaClicada);
            conta.remunera();
            modeloContaCorrente.atualizarTabela(listaManipulaContaCorrente);
        }
            
        if (tabelaManipularConta.getModel() == modeloContaInvestimento) {
            ContaInvestimento conta = modeloContaInvestimento.getContaInvestimento(linhaClicada);
            conta.remunera();
            modeloContaInvestimento.atualizarTabela(listaManipulaContaInvestimento);
        }
        
        JOptionPane.showMessageDialog(jFrame, "A remuneração foi concluída!", 
                            "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
    }
        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManipularContaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManipularContaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManipularContaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManipularContaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManipularContaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button Depositar;
    private java.awt.Button Informar;
    private java.awt.Button Remunerar;
    private java.awt.Button Sacar;
    private java.awt.Button VerSaldo;
    private javax.swing.JButton bManipularConta;
    private javax.swing.JButton bVincularConta;
    private javax.swing.JLabel deposito;
    private javax.swing.JLabel informarCPF;
    private javax.swing.JLabel saldoAtual;
    private javax.swing.JLabel saque;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JTextField tDeposito;
    private javax.swing.JTextField tInformarCPF;
    private javax.swing.JTextField tSaque;
    private javax.swing.JPanel tabManipularConta;
    private javax.swing.JTable tabelaManipularConta;
    private javax.swing.JLabel verSaldo;
    // End of variables declaration//GEN-END:variables

   
}

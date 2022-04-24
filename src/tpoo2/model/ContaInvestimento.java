package tpoo2.model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ContaInvestimento extends Conta{
    /*
    *** CONSTRUTOR
    */
    public ContaInvestimento(Cliente dono, double valor, double saque, double deposito, double montante){
        super(dono, valor, 2);
        this.setDepositoMinimo(deposito);
        this.setSaqueMinimo(saque);
        this.setMontanteMinimo(montante);
    }
    
    public ContaInvestimento(int numero, Cliente dono, double valor, double saque, double deposito, double montante) {
        super(numero, dono, valor, 2);
        this.setDepositoMinimo(deposito);
        this.setSaqueMinimo(saque);
        this.setMontanteMinimo(montante);
    }
    
    
    /*
    *** SETTERS
    */
    public void setSaqueMinimo(double saque){
        if (saque > 0) {
            this.saqueMinimo = saque;
            
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Saque mínimo inválido!\n"
                    + "O saque mínimo não pode ser menor ou igual a zero.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
    
    public void setDepositoMinimo(double deposito){
        if (deposito > 0) {
            this.depositoMinimo = deposito;
            
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Depósito mínimo inválido!\n"
                    + "O depósito mínimo não pode ser menor ou igual a zero.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
    
    public void setMontanteMinimo(double montante){
        if (montante > 0) {
            this.montanteMinimo = montante;
            
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Montante mínimo inválido!\n"
                    + "O montante mínimo não pode ser menor ou igual a zero.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
    
    
    /*
    *** OVERRIDE GETTERS
    */ 
    @Override
    public double getSaqueMinimo(){ return this.saqueMinimo; }
    
    @Override
    public double getDepositoMinimo(){ return this.depositoMinimo; }
    
    @Override
    public double getMontanteMinimo(){ return this.montanteMinimo; }
    
    
    /*
    *** MÉTODOS DA CONTA
    */
    @Override
    public boolean deposita(double valor){
        if (valor >= this.depositoMinimo) {
            return super.deposita(valor);
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "O valor de depósito não pode"
                    + " ser menor que o depósito mínimo!", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
    }

    @Override
    public boolean saca(double valor) {
        if (valor >= this.saqueMinimo) {
            double saldoTeste = this.getSaldo();
            saldoTeste -= valor;

            if (saldoTeste >= montanteMinimo) {
                return super.saca(valor);
                
            } else {
                JFrame jFrame = new JFrame();
                JOptionPane.showMessageDialog(jFrame, "O valor de saque não pode" 
                        + " tornar o saldo menor que o montante mínimo!", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
                
                return false;
            }
            
        } else {
            return false;
        }
    }

    @Override
    public void remunera() {
        this.saldo += this.saldo * 0.02;
    }
}

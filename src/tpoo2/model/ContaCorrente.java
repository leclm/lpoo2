package tpoo2.model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ContaCorrente extends Conta {
    /*
    *** CONSTRUTOR
    */
    public ContaCorrente(Cliente dono, double valor, double limite) {
        super(dono, valor, 1);
        this.setLimite(limite);
    }
    
    public ContaCorrente(int numero, Cliente dono, double valor, double limite) {
        super(numero, dono, valor, 1);
        this.setLimite(limite);
    }
    
    
    /*
    *** LIMITE
    */
    public void setLimite(double limite) {
        if (limite >= 0) {
            this.limite = limite;
            
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Limite da conta inválido!\n"
                    + "O limite da conta não pode ser menor que zero.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }

    @Override
    public double getLimite() { return this.limite; }
    
    
    /*
    *** MÉTODOS DA CONTA
    */
    @Override
    public boolean saca(double valor) {
        if (valor <= this.saldo + this.limite)
            return super.saca(valor);
        else 
            return false;
    }

    @Override
    public void remunera() {
        this.saldo += this.saldo * 0.01;
    }
}

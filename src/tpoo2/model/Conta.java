package tpoo2.model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public abstract class Conta implements ContaInterface{
    private int numero;
    private Cliente dono;
    protected double saldo;
    protected int tipoConta;
    protected double limite;
    protected double depositoMinimo;
    protected double montanteMinimo;
    protected double saqueMinimo;
    
    
    /*
    *** CONSTRUTOR
    */
    public Conta( Cliente dono, double valor, int tipo) {
        this.setDono(dono);
        this.setValorInicial(valor);
        this.setTipoConta(tipo);
    }
    
    public Conta(int numero, Cliente dono, double valor, int tipo) {
        this.setNumero(numero);
        this.setDono(dono);
        this.setValorInicial(valor);
        this.setTipoConta(tipo);
    }
    
    
    /*
    *** SETTERS
    */
    public void setNumero(int numero) {
        if(numero > 0) {
            this.numero = numero;
            
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Número da conta inválido!\n"
                    + "O número deve ser maior que zero.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
    
    public void setDono(Cliente dono) {
        if (dono != null) {
            this.dono = dono;
        
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Cliente inválido!\n"
                    + "O cliente não pode ser nulo.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
    
    public void setValorInicial(double valor) {
        if (valor >= 0) {
            this.saldo = valor;
            
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Valor inicial inválido!\n"
                    + "O valor não pode ser menor que zero.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
    
    public void setTipoConta(int tipo) {
        if (tipo == 1 || tipo == 2) {
            this.tipoConta = tipo;
            
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Tipo de conta inválido!\n"
                    + "O tipo de conta deve ser 1 ou 2.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
    
    
    /*
    *** OVERRIDE GETTERS
    */
    @Override
    public int getTipoConta() { return this.tipoConta; }
    
    @Override
    public int getNumero() { return this.numero; }
    
    @Override
    public Cliente getDono() { return this.dono; }
    
    @Override
    public double getSaldo() { return this.saldo; }
    
    @Override
    public double getLimite() { return -1; }
    
    @Override
    public double getSaqueMinimo() { return -1; }
    
    @Override 
    public double getDepositoMinimo() { return -1; }
    
    @Override 
    public double getMontanteMinimo() { return -1; }
    
    
    /*
    *** MÉTODOS DA CONTA
    */
    @Override
    public boolean deposita(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
            
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "O valor de depósito não pode ser negativo!", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
    }
    
    @Override
    public boolean saca(double valor) {
        if (valor > 0) {
            this.saldo -= valor;
            return true;
            
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "O valor de saque não pode ser negativo!", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
    }
    
    @Override
    public void remunera() {}
}

package tpoo2.model;

public interface ContaInterface {
    public Cliente getDono();
    public int getNumero();
    public double getSaldo();
    public int getTipoConta();
    public double getLimite();
    public double getSaqueMinimo();
    public double getDepositoMinimo();
    public double getMontanteMinimo();
    
    public boolean deposita(double valor);
    public boolean saca(double valor);
    public void remunera();
}
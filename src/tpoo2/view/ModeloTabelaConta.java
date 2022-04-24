package tpoo2.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tpoo2.model.Conta;

public class ModeloTabelaConta extends AbstractTableModel {
    private List<Conta> contas;
    private String[] colunas = new String[]{  
        "Dono", "Saldo", "Limite", "Saque Mínimo", "Depósito Mínimo", "Montante Mínimo", "Tipo de Conta"};
    
    
    /*
    *** CONSTRUTOR
    */
    public ModeloTabelaConta(List<Conta> contas) {
        this.contas = contas;
    }
     
    public ModeloTabelaConta(){
        this.contas = new ArrayList<Conta>();
    }
  
    
    /*
    *** OVERRIDE GETTERS
    */
    @Override
    public int getRowCount() {
        return contas.size();
    }
  
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
     
    @Override
    public String getColumnName(int columnIndex){
      return colunas[columnIndex];
    }
    
    @Override  
    public boolean isCellEditable(int rowIndex, int columnIndex) {  
        return false;  
    }
  
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Conta conta = contas.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return conta.getDono().getNome();
            case 1: return conta.getSaldo();
            case 2: return conta.getLimite();
            case 3: return conta.getSaqueMinimo();
            case 4: return conta.getDepositoMinimo();
            case 5: return conta.getMontanteMinimo();
            case 6: return conta.getTipoConta();
            default : return null;
        }
    }
    
    
    /*
    *** CRUD
    */
    public void adicionaConta(Conta conta) {
        this.contas.add(conta);
        this.fireTableRowsInserted(contas.size()-1, contas.size()-1);//update JTable
    }
    
    public boolean removeConta(Conta conta) {
        int linha = contas.indexOf(conta);
        boolean result = this.contas.remove(conta);
        this.fireTableRowsDeleted(linha, linha);//update JTable
        return result;
    }

    public void atualizarTabela(List<Conta> contas){
        this.contas = new ArrayList();
        this.contas.addAll(contas);
        this.fireTableDataChanged();
    }

    public void limpaTabela() {
        int indice = contas.size()-1;
        
        if(indice < 0)
            indice = 0;
        
        this.contas = new ArrayList();
        this.fireTableRowsDeleted(0, indice);//update JTable
    }

    public Conta getConta(int linha){
        return contas.get(linha);
    }
    
    public boolean isEmpty() {  
        return contas.isEmpty();  
    }       
}

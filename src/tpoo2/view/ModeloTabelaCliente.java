package tpoo2.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tpoo2.model.Cliente;

public class ModeloTabelaCliente extends AbstractTableModel {
    private List<Cliente> clientes;
    private String[] colunas = new String[]{"Nome", "Sobrenome", "RG", "CPF", "Salário", "Endereço"};
    
    
    /*
    *** CONSTRUTOR
    */
    public ModeloTabelaCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public ModeloTabelaCliente(){
        this.clientes = new ArrayList<>();
    }
    
    
    /*
    *** OVERRIDE GETTERS
    */
    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return cliente.getNome();
            case 1: return cliente.getSobrenome();
            case 2: return cliente.getRG();
            case 3: return cliente.getCPF();
            case 4: return cliente.getSalario();
            case 5: return cliente.getEndereco() ;
            default : return null;
        }
    }

    
    /*
    *** CRUD
    */
    public void adicionaCliente(Cliente cliente) {
        this.clientes.add(cliente);
        this.fireTableRowsInserted(clientes.size()-1, clientes.size()-1);//update JTable
    }
    
    public boolean removeCliente(Cliente cliente) {
        int linha = this.clientes.indexOf(cliente);
        boolean result = this.clientes.remove(cliente);
        this.fireTableRowsDeleted(linha, linha);//update JTable
        return result;
    }
    
    void removeClientes(List<Cliente> listaParaExcluir) {
        listaParaExcluir.forEach((Cliente) -> {
            removeCliente(Cliente);
        });
    }

    public void atualizarTabela(List<Cliente> clientes){
        this.clientes = new ArrayList();
        this.clientes.addAll(clientes);
        this.fireTableDataChanged();
    }

    public void limpaTabela() {
        int indice = clientes.size()-1;
        
        if(indice < 0)
            indice = 0;
        
        this.clientes = new ArrayList();
        this.fireTableRowsDeleted(0, indice);//update JTable
    }

    public Cliente getCliente(int linha){
        return clientes.get(linha);
    }
    
    public List<Cliente> getClientes(){
        return clientes;
    }
}

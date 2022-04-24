package tpoo2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tpoo2.model.Cliente;
import tpoo2.model.Conta;

public class ClienteDao {
    /*
    *** CONSTRUTOR
    */
    public ClienteDao() {}
    
    
    /*
    *** JDBC CONNECTION
    */
    private static ConnectionFactory connectionFactory;
    private static PreparedStatement st;
    private static ResultSet rs;

    
    /*
    *** SQL QUERIES
    */
    private static final String SQL_INSERT = "INSERT INTO cliente (cpf, nome, "
            + "sobrenome, rg, salario, endereco) VALUES (?,?,?,?,?,?);";

    private static final String SQL_UPDATE = "UPDATE cliente SET cpf = ?, "
            + "nome = ?, sobrenome = ?, rg = ?, salario = ?, endereco = ? WHERE id = ?; ";

    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id = ?;";

    private static final String SQL_GET_BY_ID = "SELECT id, cpf, nome, sobrenome, "
            + "rg, salario, endereco FROM cliente WHERE id = ?;";
    
    private static final String SQL_GET_BY_CPF = "SELECT id, cpf, nome, sobrenome,"
            + " rg, salario, endereco FROM cliente WHERE cpf = ?;";
    
    private static final String SQL_LIST = "SELECT id, cpf, nome, sobrenome, rg, "
            + "salario, endereco FROM cliente;";
    
    private static final String SQL_IS_CPF_AVAILABLE = "SELECT cpf FROM cliente "
            + "WHERE cpf = ?";
    
    private static final String SQL_IS_RG_AVAILABLE = "SELECT rg FROM cliente "
            + "WHERE rg = ?";

    
    /*
    *** INSERT
    */
    public static void insertCliente(Cliente c) throws SQLException{
        Connection con = connectionFactory.getConnection();
        
        try {
            // prepared statement para inserção
            st = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            // seta os valores
            st.setString(1, c.getCPF());
            st.setString(2, c.getNome());
            st.setString(3, c.getSobrenome());
            st.setString(4, c.getRG());
            st.setDouble(5, c.getSalario());
            st.setString(6, c.getEndereco());
            // executa
            st.execute();
            //Seta o id do cliente
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            int i = rs.getInt(1);
            c.setId(i);
            
        } catch(Exception ex) {
            throw new RuntimeException(ex);
            
        } finally {
            ConnectionFactory.close(con, st, rs); 
        }
    }

    
    /*
    *** UPDATE
    */
    public static void updateCliente(Cliente c) throws SQLException{
        Connection con = connectionFactory.getConnection();
        st = con.prepareStatement(SQL_UPDATE);
        try {
            st.setString(1, c.getCPF());
            st.setString(2, c.getNome());
            st.setString(3, c.getSobrenome());
            st.setString(4, c.getRG());
            st.setDouble(5, c.getSalario());
            st.setString(6, c.getEndereco());
            st.setInt(7, c.getId());
            
            st.executeUpdate();
        } finally{
            st.close();
        }
    }

    
    /*
    *** DELETE
    */
    public static boolean deleteClienteById(int id) throws SQLException{
        Connection con = connectionFactory.getConnection();
        
        try {
            Cliente c = ClienteDao.getClienteById(id);
            List<Conta> contasCliente = ContaDao.getContasByCpf(c.getCPF());
            
            for (int i = 0; i< contasCliente.size(); i++)
                ContaDao.deleteConta(contasCliente.get(i).getNumero());
            
            st = con.prepareStatement(SQL_DELETE);
            st.setInt(1, id);

            return st.executeUpdate() != 0;
            
        } catch (Exception ex) {
            return false;
            
        } finally {
            ConnectionFactory.close(con, st, rs); 
        }
    }
    
    public void deleteLista(List<Cliente> clientes) throws SQLException {
        for(Cliente Cliente: clientes){
            deleteCliente(Cliente);
        }
    }

    public void deleteCliente(Cliente cliente) throws SQLException {
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmtExcluir;
        stmtExcluir = con.prepareStatement(SQL_DELETE);
        
        try {
            stmtExcluir.setLong(1, cliente.getId());
            stmtExcluir.executeUpdate();
            
        } finally{
            stmtExcluir.close();
        }
    }

    
    /*
    *** LISTAR CLIENTES
    */
    public static List<Cliente> listClientes() throws SQLException{
        Connection con = connectionFactory.getConnection();
        
        try {
            List<Cliente> lista = new ArrayList();
            
            rs = con.prepareStatement(SQL_LIST).executeQuery();
            while(rs.next()) {
                Cliente c = new Cliente();
                
                c.setId(rs.getInt(1));
                c.setCPF(rs.getString(2));
                c.setNome(rs.getString(3));
                c.setSobrenome(rs.getString(4));
                c.setRG(rs.getString(5));
                c.setSalario(rs.getDouble(6));
                c.setEndereco(rs.getString(7));
                
                lista.add(c);
            }
            
            return lista;
            
        } catch (Exception ex) { 
            return null; 
            
        } finally {
            ConnectionFactory.close(con, st, rs); 
        }
    }
    
    
    /*
    *** PROCURAR CLIENTE
    */
    public static Cliente getClienteById(int id) throws SQLException{
        Connection con = connectionFactory.getConnection();
        
        try {
            st = con.prepareStatement(SQL_GET_BY_ID);
            st.setInt(1, id);

            rs = st.executeQuery();
            if (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setCPF(rs.getString(2));
                c.setNome(rs.getString(3));
                c.setSobrenome(rs.getString(4));
                c.setRG(rs.getString(5));
                c.setSalario(rs.getDouble(6));
                c.setEndereco(rs.getString(7));
                
                return c;
            }
            
            return null;
            
        } catch (Exception ex) { 
            return null; 
            
        } finally {
            ConnectionFactory.close(con, st, rs); 
        }
    }
    
    public static Cliente getClienteByCpf(String cpf) throws SQLException{
        Connection con = connectionFactory.getConnection();
        
        try {
            st = con.prepareStatement(SQL_GET_BY_CPF);
            st.setString(1, cpf);

            rs = st.executeQuery();
            if (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setCPF(rs.getString(2));
                c.setNome(rs.getString(3));
                c.setSobrenome(rs.getString(4));
                c.setRG(rs.getString(5));
                c.setSalario(rs.getDouble(6));
                c.setEndereco(rs.getString(7));
                
                return c;
            }
            
            return null;
            
        } catch (Exception ex) { 
            return null; 
            
        } finally {
            ConnectionFactory.close(con, st, rs); 
        }
    }
    
    
    /*
    *** VERIFICAR DISPONIBILIDADE DO CPF
    */
    public static boolean isCpfAvailable(String cpf) throws SQLException{
        Connection con = connectionFactory.getConnection();
        
        try {
            st = con.prepareStatement(SQL_IS_CPF_AVAILABLE);
            st.setString(1, cpf);
            
            rs = st.executeQuery();
            
            return !rs.next();
            
        } catch(Exception ex) { 
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
            
        } finally {
            ConnectionFactory.close(con, st, rs); 
        }   
    }
    
    public static boolean isCpfAvailable(String cpf, int id) throws SQLException{
        Connection con = connectionFactory.getConnection();
        
        try {
            st = con.prepareStatement(SQL_IS_CPF_AVAILABLE + " AND id != ?");
            st.setString(1, cpf);
            st.setInt(2, id);
            
            rs = st.executeQuery();
            
            return !rs.next();
            
        } catch(Exception ex) { 
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
            
        } finally {
            ConnectionFactory.close(con, st, rs); 
        }   
    }
    
    
    /*
    *** VERIFICAR DISPONIBILIDADE DO RG
    */
    public static boolean isRgAvailable(String rg) throws SQLException{
        Connection con = connectionFactory.getConnection();
        
        try {
            st = con.prepareStatement(SQL_IS_RG_AVAILABLE);
            st.setString(1, rg);
            
            rs = st.executeQuery();
            
            return !rs.next();
            
        } catch(Exception ex) { 
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
            
        } finally {
            ConnectionFactory.close(con, st, rs); 
        }   
    }
    
    public static boolean isRgAvailable(String rg, int id) throws SQLException{
        Connection con = connectionFactory.getConnection();
        
        try {
            st = con.prepareStatement(SQL_IS_RG_AVAILABLE + " AND id != ?");
            st.setString(1, rg);
            st.setInt(2, id);
            
            rs = st.executeQuery();
            
            return !rs.next();
            
        } catch(Exception ex) { 
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        
        } finally {
            ConnectionFactory.close(con, st, rs);
        }
    }
}

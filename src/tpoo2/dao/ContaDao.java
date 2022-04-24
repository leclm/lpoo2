package tpoo2.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tpoo2.model.Cliente;
import tpoo2.model.Conta;
import tpoo2.model.ContaCorrente;
import tpoo2.model.ContaInvestimento;

public class ContaDao {
    /*
    *** CONSTRUTOR
    */
    private ContaDao() {}
    
    
    /*
    *** JDBC CONNECTION
    */
    private static Connection con = null;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;
    
    
    /*
    *** SQL QUERIES
    */
    private static final String SQL_INSERT = "INSERT INTO conta (cpf, saldoConta, "
            + "limiteConta, saqueMinimo, depositoMinimo, tipoConta, montanteMinimo) VALUES "
            + "(?, ?, ?, ?, ?, ?, ?);";
    
    private static final String SQL_UPDATE = "UPDATE conta SET cpf = ?, "
            + "saldoConta = ?, limiteConta = ?, saqueMinimo = ?, "
            + "depositoMinimo = ?, tipoConta = ?, montanteMinimo = ? WHERE numeroConta = ?;";
    
    private static final String SQL_DELETE = "DELETE FROM conta WHERE numeroConta = ?";
    
    private static final String SQL_GET_CONTA_BY_CPF = "SELECT numeroConta, cpf, "
            + "saldoConta, limiteConta, saqueMinimo, depositoMinimo, tipoConta, montanteMinimo "
            + "FROM conta where cpf = ?;";
    
    
    /*
    *** INSERT
    */
    public static Conta insertConta(Conta c) throws SQLException {
        try{
            con = ConnectionFactory.getConnection();
            
            st = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, c.getDono().getCPF());
            st.setDouble(2, c.getSaldo());
            
            if (c.getTipoConta() == 1) {
                st.setDouble(3, c.getLimite());
                st.setNull(4, java.sql.Types.DOUBLE);
                st.setNull(5, java.sql.Types.DOUBLE);
                st.setNull(7, java.sql.Types.DOUBLE);
                
            } else {
                st.setNull(3, java.sql.Types.DOUBLE);
                st.setDouble(4, c.getSaqueMinimo());
                st.setDouble(5, c.getDepositoMinimo());
                st.setDouble(7, c.getMontanteMinimo());
            }
            st.setInt(6, c.getTipoConta());
            
            if (st.executeUpdate() == 0) return null;
            
            rs = st.getGeneratedKeys();
            
            if(rs.next()) {
                c.setNumero(rs.getInt(1));
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
    *** UPDATE
    */
    public static boolean updateConta(Conta c) throws SQLException {
        try{
            con = ConnectionFactory.getConnection();
            
            st = con.prepareStatement(SQL_UPDATE);
            st.setString(1, c.getDono().getCPF());
            st.setDouble(2, c.getSaldo());
            
            if (c.getTipoConta() == 1) {
                st.setDouble(3, c.getLimite());
                st.setNull(4, java.sql.Types.DOUBLE);
                st.setNull(5, java.sql.Types.DOUBLE);
                st.setNull(7, java.sql.Types.DOUBLE);
                
            } else {
                st.setNull(3, java.sql.Types.DOUBLE);
                st.setDouble(4, c.getSaqueMinimo());
                st.setDouble(5, c.getDepositoMinimo());
                st.setDouble(7, c.getMontanteMinimo());
            }
            
            st.setInt(6, c.getTipoConta());
            st.setInt(7, c.getNumero());
            
            return st.executeUpdate() != 0;
            
        } catch(Exception ex) { 
            return false; 
            
        } finally{ 
            ConnectionFactory.close(con, st, rs); 
        }
    }
    
    
    /*
    *** DELETE
    */
    public static boolean deleteConta(int numeroConta) throws SQLException {
        try{
            con = ConnectionFactory.getConnection();
            
            st = con.prepareStatement(SQL_DELETE);
            st.setInt(1, numeroConta);
            
            return st.executeUpdate() != 0;
            
        } catch (Exception ex) { 
            return false; 
            
        } finally{ 
            ConnectionFactory.close(con, st, rs); 
        }
    }
    
    
    /*
    *** PROCURAR CONTA PELO CPF
    */
    public static List<Conta> getContasByCpf(String cpf) throws SQLException {
        try{
            List<Conta> contas = new ArrayList();
            con = ConnectionFactory.getConnection();
            Cliente dono = ClienteDao.getClienteByCpf(cpf);
            
            st = con.prepareStatement(SQL_GET_CONTA_BY_CPF);
            st.setString(1, cpf);
            
            rs = st.executeQuery();
            while(rs.next()) {
                Conta c;
                
                if (rs.getInt(7) == 1) { //SE O TIPO DE CONTA É CORRENTE
                    if (rs.getDouble(3) < 0) {
                        c = new ContaCorrente(
                            rs.getInt(1),
                            dono, 
                            0,
                            rs.getDouble(4)
                        );
                        
                        c.saca(Math.abs(rs.getDouble(3)));
                        
                    } else c = new ContaCorrente (
                        rs.getInt(1),
                        dono, 
                        rs.getDouble(3), 
                        rs.getDouble(4)
                    );
                    
                } else {
                    if (rs.getDouble(3) < 0) {
                        c = new ContaInvestimento(  
                            rs.getInt(1),
                            dono,
                            0,
                            rs.getDouble(5),
                            rs.getDouble(6),
                            rs.getDouble(7)
                        );
                        
                        c.saca(Math.abs(rs.getDouble(3)));
                        
                    } else c = new ContaInvestimento(
                        rs.getInt(1),
                        dono,
                        0,
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getDouble(7)
                    );
                }
                
                contas.add(c);
            }
            
            return contas;
            
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

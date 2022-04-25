package tpoo2.model;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class Cliente implements Comparable {
    private int id;
    private String nome;
    private String sobrenome;
    private String RG;
    private String CPF;
    private double salario;
    private String endereco;
    private List<Conta> contas = null;
    
    /*
    *** CONSTRUTOR
    */
    public Cliente() {}
    
    public Cliente(int id, String nome, String sobrenome, String RG, String CPF, double salario, String endereco) {
        this.setId(id);
        this.setNome(nome);
        this.setSobrenome(sobrenome);
        this.setRG(RG);
        this.setCPF(CPF);
        this.setSalario(salario);
        this.setEndereco(endereco);
    }
    
    
    /*
    *** ID
    */
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() { return this.id; }
    
    
    /*
    *** NOME
    */
    public void setNome(String nome) {
        if (nome != null && !nome.equals("") && containsOnlyLetter(nome)) {
            this.nome = nome;
            
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Nome inválido!\n"
                    + "O nome deve conter apenas letras e não pode estar vazio.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
    
    public String getNome() { return this.nome; }
    
    
    /*
    *** SOBRENOME
    */
    public void setSobrenome(String sobrenome) {
        if (sobrenome != null && !sobrenome.equals("") && containsOnlyLetter(sobrenome)) {
            this.sobrenome = sobrenome;
            
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Sobrenome inválido!\n"
                    + "O sobrenome deve conter apenas letras e não pode estar vazio.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
    
    public String getSobrenome() { return this.sobrenome; }
    
    
    /*
    *** RG
    */
    public void setRG(String RG) {
        if (RG != null && !RG.equals("") && containsOnlyNumber(RG)) {
            this.RG = RG;
            
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "RG inválido!\n"
                    + "O RG deve conter apenas números e não pode estar vazio.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
    
    public String getRG() { return this.RG; }
    
    
    /*
    *** CPF
    */
    public void setCPF(String CPF) {
        if (CPF != null && !CPF.equals("") && containsOnlyNumber(CPF)) {
            this.CPF = CPF;
            
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "CPF inválido!\n"
                    + "O CPF deve conter apenas números e não pode estar vazio.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
    
    public String getCPF() { return this.CPF; }
    
    
    /*
    *** SALÁRIO
    */
    public void setSalario(double salario) { 
        if (salario > 0) {
            this.salario = salario;
            
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Salário inválido!\n"
                    + "O salário deve ser maior que zero.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
    
    public double getSalario() { return salario; }
    
    
    /*
    *** ENDEREÇO
    */
    public void setEndereco(String endereco) {
        if (endereco != null && !endereco.equals("")) {
            this.endereco = endereco;
            
        } else {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Endereço inválido!\n"
                    + "O endereço não pode estar vazio.", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            
            throw new RuntimeException();
        }
    }
    
    public String getEndereco() { return this.endereco; }
    
    
    /*
    *** CONTA
    */
    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
    
    public void setConta(Conta conta) {
        this.contas.add(conta);
    }
    
    public List<Conta> getConta() {
        if (this.contas != null) {
            return this.contas;
        } else {
            return null;
        }
    }
    
    
    /*
    *** COMPLEMENTARES
    */
    @Override
    public int compareTo(Object o) {
        Cliente outroCliente = (Cliente) o;
        
        if (this.getSalario() > outroCliente.getSalario()) {
            return -1;
        } else if (this.getSalario() < outroCliente.getSalario()) {
            return 1;
        } else {
            return 0;
        }
    }
    
    private final boolean containsOnlyLetter(String s) {
        boolean containsLetter = false;

        if (s != null && !s.isEmpty()) {
            for (char c: s.toCharArray()) {
                if (Character.isLetter(c) || Character.isSpaceChar(c) || Character.isWhitespace(c)) {
                    containsLetter = true;
                } else {
                    containsLetter = false;
                    break;
                }
            }
        }

        return containsLetter;
    }
    
    private final boolean containsOnlyNumber(String s) {
        boolean containsNumber = false;

        if (s != null && !s.isEmpty()) {
            for (char c: s.toCharArray()) {
                if (Character.isDigit(c)) {
                    containsNumber = true;
                } else {
                    containsNumber = false;
                    break;
                }
            }
        }

        return containsNumber;
    }
}

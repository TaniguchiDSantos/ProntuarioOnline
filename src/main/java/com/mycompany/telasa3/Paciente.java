package com.mycompany.telasa3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Acesso {

    private int pacienteID;
    private String nomePaciente;
    private String cpf;
    private String telefone;
    private int idade;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;
    private boolean status_;

    public boolean cadastraPaciente() {
        //1: Definir o comando SQL
        String sql = "INSERT INTO Pacientes(nomePaciente,cpf,telefone,idade,cep,estado,cidade,bairro,rua,numero,status_) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //4: Preenche os dados faltantes
            ps.setString(1, nomePaciente);
            ps.setString(2, cpf);
            ps.setString(3, telefone);
            ps.setInt(4, idade);
            ps.setString(5, cep);
            ps.setString(6, estado);
            ps.setString(7, cidade);
            ps.setString(8, bairro);
            ps.setString(9, rua);
            ps.setInt(10, numero);
            ps.setBoolean(11, status_);
            //5: Executa o comando
            ps.execute();
            int autoIncKeyFromApi = -1;

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                autoIncKeyFromApi = rs.getInt(1);
                this.pacienteID = autoIncKeyFromApi;
                return this.cadastraAcessoPaciente(this.pacienteID);
            } else {

                // throw an exception from here
            }
            
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Paciente consultaPaciente(String cpf) {
        Paciente paciente = new Paciente();
        //1: Definir o comando SQL
        String sql = "Select * from Pacientes where CPF = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, cpf);
            //5: Executa o comando
            rs = ps.executeQuery();

            if (rs.isBeforeFirst()) {
                rs.beforeFirst();
                while (rs.next()) {
                    
                    paciente.pacienteID = rs.getInt("Paciente_ID");
                    paciente.nomePaciente = rs.getString("NomePaciente");
                    paciente.cpf = rs.getString("CPF");
                    paciente.telefone = rs.getString("Telefone");
                    paciente.idade = rs.getInt("Idade");
                    paciente.cep = rs.getString("CEP");
                    paciente.estado = rs.getString("Estado");
                    paciente.cidade = rs.getString("Cidade");
                    paciente.bairro = rs.getString("Bairro");
                    paciente.rua = rs.getString("Rua");
                    paciente.numero = rs.getInt("Numero");
                    paciente.status_ = rs.getBoolean("Status_");
                }
            } else {

                paciente = null;
            }
            
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paciente;
    }
    
    public List<Paciente> listaPacientes() {
        List pacientes = new ArrayList<>();
        //1: Definir o comando SQL
        String sql = "Select * from Pacientes where Status_ = 1";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Executa o comando
            rs = ps.executeQuery();

            if (rs.isBeforeFirst()) {
                rs.beforeFirst();
                while (rs.next()) {
                    Paciente paciente = new Paciente();
                    paciente.pacienteID = rs.getInt("Paciente_ID");
                    paciente.nomePaciente = rs.getString("NomePaciente");
                    paciente.cpf = rs.getString("CPF");
                    paciente.telefone = rs.getString("Telefone");
                    paciente.idade = rs.getInt("Idade");
                    paciente.cep = rs.getString("CEP");
                    paciente.estado = rs.getString("Estado");
                    paciente.cidade = rs.getString("Cidade");
                    paciente.bairro = rs.getString("Bairro");
                    paciente.rua = rs.getString("Rua");
                    paciente.numero = rs.getInt("Numero");
                    paciente.status_ = rs.getBoolean("Status_");

                    pacientes.add(paciente);
                }
            } else {

                pacientes = null;
            }
            
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    /**
     * @return the pacienteID
     */
    public int getPacienteID() {
        return pacienteID;
    }

    /**
     * @param pacienteID the pacienteID to set
     */
    public void setPacienteID(int pacienteID) {
        this.pacienteID = pacienteID;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nomePaciente;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nomePaciente = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the status
     */
    public boolean isStatus_() {
        return status_;
    }

    /**
     * @param status_ the status to set
     */
    public void setStatus_(boolean status_) {
        this.status_ = status_;
    }
}

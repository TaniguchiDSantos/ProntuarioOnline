package com.mycompany.telasa3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Medico extends Acesso {

    private int medicoID;
    private String nomeMedico;
    private String cpf;
    private String crm;
    private String especialidade;
    private String telefone;
    private int idade;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;
    private boolean status_;

    public boolean cadastraMedico() {
        //1: Definir o comando SQL
        String sql = "INSERT INTO Medicos(nomeMedico,cpf,crm,especialidade,telefone,idade,cep,estado,cidade,bairro,rua,numero,status_) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //4: Preenche os dados faltantes
            ps.setString(1, getNome());
            ps.setString(2, getCpf());
            ps.setString(3, getCrm());
            ps.setString(4, getEspecialidade());
            ps.setString(5, getTelefone());
            ps.setInt(6, getIdade());
            ps.setString(7, getCep());
            ps.setString(8, getEstado());
            ps.setString(9, getCidade());
            ps.setString(10, getBairro());
            ps.setString(11, getRua());
            ps.setInt(12, getNumero());
            ps.setBoolean(13, isStatus_());
            //5: Executa o comando
            ps.execute();
            int autoIncKeyFromApi = -1;

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                autoIncKeyFromApi = rs.getInt(1);
                this.medicoID = autoIncKeyFromApi;
                return this.cadastraAcessoMedico(this.medicoID);
            } else {

                // throw an exception from here
            }

            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Medico consultaMedico(String cpf) {
        Medico medico = new Medico();
        //1: Definir o comando SQL
        String sql = "Select * from Medicos where CPF = ?";
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
                while (rs.next()) {
                    medico.setMedicoID(rs.getInt("Medico_ID"));
                    medico.setNome(rs.getString("NomeMedico"));
                    medico.setCpf(rs.getString("CPF"));
                    medico.setCrm(rs.getString("CRM"));
                    medico.setEspecialidade(rs.getString("Especialidade"));
                    medico.setTelefone(rs.getString("Telefone"));
                    medico.setIdade(rs.getInt("Idade"));
                    medico.setCep(rs.getString("CEP"));
                    medico.setEstado(rs.getString("Estado"));
                    medico.setCidade(rs.getString("Cidade"));
                    medico.setBairro(rs.getString("Bairro"));
                    medico.setRua(rs.getString("Rua"));
                    medico.setNumero(rs.getInt("Numero"));
                    medico.setStatus_(rs.getBoolean("Status_"));
                }
            } else {

                medico = null;
            }

            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medico;
    }

    public List<Medico> listaMedicos() {
        List medicos = new ArrayList<>();
        //1: Definir o comando SQL
        String sql = "Select * from Medicos where Status_ = 1";
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
                    Medico medico = new Medico();
                    medico.setMedicoID(rs.getInt("Medico_ID"));
                    medico.setNome(rs.getString("NomeMedico"));
                    medico.setCpf(rs.getString("CPF"));
                    medico.setCrm(rs.getString("CRM"));
                    medico.setEspecialidade(rs.getString("Especialidade"));
                    medico.setTelefone(rs.getString("Telefone"));
                    medico.setIdade(rs.getInt("Idade"));
                    medico.setCep(rs.getString("CEP"));
                    medico.setEstado(rs.getString("Estado"));
                    medico.setCidade(rs.getString("Cidade"));
                    medico.setBairro(rs.getString("Bairro"));
                    medico.setRua(rs.getString("Rua"));
                    medico.setNumero(rs.getInt("Numero"));
                    medico.setStatus_(rs.getBoolean("Status_"));

                    medicos.add(medico);
                }
            } else {

                medicos = null;
            }

            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicos;
    }

    /**
     * @return the medicoID
     */
    public int getMedicoID() {
        return medicoID;
    }

    /**
     * @param medicoID the medicoID to set
     */
    public void setMedicoID(int medicoID) {
        this.medicoID = medicoID;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nomeMedico;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nomeMedico = nome;
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
     * @return the crm
     */
    public String getCrm() {
        return crm;
    }

    /**
     * @param crm the crm to set
     */
    public void setCrm(String crm) {
        this.crm = crm;
    }

    /**
     * @return the especialidade
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
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
     * @return the status_
     */
    public boolean isStatus_() {
        return status_;
    }

    /**
     * @param status_ the status_ to set
     */
    public void setStatus_(boolean status_) {
        this.status_ = status_;
    }
}

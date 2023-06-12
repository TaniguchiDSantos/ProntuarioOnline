package com.mycompany.telasa3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Laboratorio extends Acesso {
    private int laboratorioID;
    private String NomeLaboratorio;
    private String cnpj;
    private String telefone;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;
    private boolean status_;
    
     public boolean cadastraLaboratorio() {
         //1: Definir o comando SQL
        String sql = "INSERT INTO Laboratorios(NomeLaboratorio,cnpj,telefone,cep,estado,cidade,bairro,rua,numero,status_) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //4: Preenche os dados faltantes
            ps.setString(1, getNome());
            ps.setString(2, getCnpj());
            ps.setString(3, getTelefone());
            ps.setString(4, getCep());
            ps.setString(5, getEstado());
            ps.setString(6, getCidade());
            ps.setString(7, getBairro());
            ps.setString(8, getRua());
            ps.setInt(9, getNumero());
            ps.setBoolean(10, isStatus_());
            //5: Executa o comando
            ps.execute();
            int autoIncKeyFromApi = -1;

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                autoIncKeyFromApi = rs.getInt(1);
                this.laboratorioID = autoIncKeyFromApi;
                return this.cadastraAcessoLaboratorio(this.laboratorioID);
            } else {

                // throw an exception from here
            }

            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
     
     public Laboratorio consultaLaboratorio(String cnpj) {
        Laboratorio laboratorio = new Laboratorio();
        //1: Definir o comando SQL
        String sql = "Select * from Laboratorios where CNPJ = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, cnpj);
            //5: Executa o comando
            rs = ps.executeQuery();

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                  
                    laboratorio.setLaboratorioID(rs.getInt("Laboratorio_ID"));
                    laboratorio.setNome(rs.getString("NomeLaboratorio"));
                    laboratorio.setCnpj(rs.getString("CNPJ"));
                    laboratorio.setTelefone(rs.getString("Telefone"));
                    laboratorio.setCep(rs.getString("CEP"));
                    laboratorio.setEstado(rs.getString("Estado"));
                    laboratorio.setCidade(rs.getString("Cidade"));
                    laboratorio.setBairro(rs.getString("Bairro"));
                    laboratorio.setRua(rs.getString("Rua"));
                    laboratorio.setNumero(rs.getInt("Numero"));
                    laboratorio.setStatus_(rs.getBoolean("Status_"));
                }
            } else {

                laboratorio = null;
            }
            
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return laboratorio;
    }
     
     public List<Laboratorio> listaLaboratorios() {
        List laboratorios = new ArrayList<>();
        //1: Definir o comando SQL
        String sql = "Select * from Laboratorios where Status_ = 1";
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
                    Laboratorio laboratorio = new Laboratorio();
                    laboratorio.setLaboratorioID(rs.getInt("Laboratorio_ID"));
                    laboratorio.setNome(rs.getString("NomeLaboratorio"));
                    laboratorio.setCnpj(rs.getString("CNPJ"));
                    laboratorio.setTelefone(rs.getString("Telefone"));
                    laboratorio.setCep(rs.getString("CEP"));
                    laboratorio.setEstado(rs.getString("Estado"));
                    laboratorio.setCidade(rs.getString("Cidade"));
                    laboratorio.setBairro(rs.getString("Bairro"));
                    laboratorio.setRua(rs.getString("Rua"));
                    laboratorio.setNumero(rs.getInt("Numero"));
                    laboratorio.setStatus_(rs.getBoolean("Status_"));
                    
                    laboratorios.add(laboratorio);
                }
            } else {

                laboratorios = null;
            }
            
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return laboratorios;
    }

    /**
     * @return the laboratorioID
     */
    public int getLaboratorioID() {
        return laboratorioID;
    }

    /**
     * @param laboratorioID the laboratorioID to set
     */
    public void setLaboratorioID(int laboratorioID) {
        this.laboratorioID = laboratorioID;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return NomeLaboratorio;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.NomeLaboratorio = nome;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

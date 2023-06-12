package com.mycompany.telasa3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Acesso {

    private String email;
    private String senha;
    private String tipo_Acesso;
    private String nomePaciente;
    private int pacienteID;
    private String nomeMedico;
    private int medicoID;
    private String nomeLaboratorio;
    private int laboratorioID;

    public boolean cadastraAcessoPaciente(int pacienteID) {
        //1: Definir o comando SQL
        String sql = "INSERT INTO Acessos(email,senha,tipo_Acesso,paciente_ID) VALUES (?, ?, ?, ?)";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //4: Preenche os dados faltantes
            ps.setString(1, getEmail());
            ps.setString(2, getSenha());
            ps.setString(3, getTipoAcesso());
            ps.setInt(4, pacienteID);

            //5: Executa o comando
            int count = ps.executeUpdate();

            if (count > 0) {
                return true;
            } else {

                // throw an exception from here
            }

            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean cadastraAcessoMedico(int medicoID) {
        //1: Definir o comando SQL
        String sql = "INSERT INTO Acessos(email,senha,tipo_Acesso,medico_ID) VALUES (?, ?, ?, ?)";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //4: Preenche os dados faltantes
            ps.setString(1, getEmail());
            ps.setString(2, getSenha());
            ps.setString(3, getTipoAcesso());
            ps.setInt(4, medicoID);

            //5: Executa o comando
            int count = ps.executeUpdate();

            if (count > 0) {
                return true;
            } else {

                // throw an exception from here
            }

            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean cadastraAcessoLaboratorio(int laboratorioID) {
        //1: Definir o comando SQL
        String sql = "INSERT INTO Acessos(email,senha,tipo_Acesso,laboratorio_ID) VALUES (?, ?, ?, ?)";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //4: Preenche os dados faltantes
            ps.setString(1, getEmail());
            ps.setString(2, getSenha());
            ps.setString(3, getTipoAcesso());
            ps.setInt(4, laboratorioID);

            //5: Executa o comando
            int count = ps.executeUpdate();

            if (count > 0) {
                return true;
            } else {

                // throw an exception from here
            }

            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Acesso verificarAcesso() {
        Acesso acesso = new Acesso();
        //1: Definir o comando SQL
        String sql = "Select * from Acessos "
                + "INNER JOIN Pacientes  ON Acessos.Paciente_ID = Pacientes.Paciente_ID "
                + "where Email = ? AND Senha = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, getEmail());
            ps.setString(2, getSenha());
            //5: Executa o comando
            rs = ps.executeQuery();

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    acesso.nomePaciente = rs.getString("NomePaciente");
                    acesso.pacienteID = rs.getInt("Paciente_ID");
                    acesso.tipo_Acesso = rs.getString("Tipo_Acesso");
                    acesso.email = rs.getString("Email");

                    return acesso;
                }
            } else {
                if (verificarAcessoMedico() != null) {
                    acesso = verificarAcessoMedico();
                } else if (verificarAcessoLaboratorio() != null) {
                    acesso = verificarAcessoLaboratorio();
                }else{
                    acesso = verificarAcessoAdmin();
                }
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acesso;
    }

    public Acesso verificarAcessoMedico() {
        Acesso acesso = new Acesso();
        //1: Definir o comando SQL
        String sql = "Select * from Acessos "
                + "INNER JOIN Medicos  ON Acessos.Medico_ID = Medicos.Medico_ID "
                + "where Email = ? AND Senha = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, getEmail());
            ps.setString(2, getSenha());
            //5: Executa o comando
            rs = ps.executeQuery();

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    acesso.nomeMedico = rs.getString("NomeMedico");
                    acesso.medicoID = rs.getInt("Medico_ID");
                    acesso.tipo_Acesso = rs.getString("Tipo_Acesso");
                    acesso.email = rs.getString("Email");

                    return acesso;
                }
            } else {
                return acesso = null;
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acesso;
    }

    public Acesso verificarAcessoLaboratorio() {
        Acesso acesso = new Acesso();
        //1: Definir o comando SQL
        String sql = "Select * from Acessos "
                + "INNER JOIN Laboratorios  ON Acessos.Laboratorio_ID = Laboratorios.Laboratorio_ID "
                + "where Email = ? AND Senha = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, getEmail());
            ps.setString(2, getSenha());
            //5: Executa o comando
            rs = ps.executeQuery();

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    acesso.nomeLaboratorio = rs.getString("NomeLaboratorio");
                    acesso.laboratorioID = rs.getInt("Laboratorio_ID");
                    acesso.tipo_Acesso = rs.getString("Tipo_Acesso");
                    acesso.email = rs.getString("Email");

                    return acesso;
                }
            } else {
                return acesso = null;
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acesso;
    }

    public Acesso verificarAcessoAdmin() {
        Acesso acesso = new Acesso();
        //1: Definir o comando SQL
        String sql = "Select * from Acessos "
                + "where Email = ? AND Senha = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, getEmail());
            ps.setString(2, getSenha());
            //5: Executa o comando
            rs = ps.executeQuery();

            if (rs.isBeforeFirst()) {
                while (rs.next()) {;
                    acesso.tipo_Acesso = rs.getString("Tipo_Acesso");
                    acesso.email = rs.getString("Email");

                    return acesso;
                }
            } else {
                return acesso = null;
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acesso;
    }

    public boolean verificarEmailExistente(String email) {
        //1: Definir o comando SQL
        String sql = "Select * from Acessos where Email = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setString(1, email);
            //5: Executa o comando
            rs = ps.executeQuery();

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    System.out.println("Já existe esse e mail cadastrado");

                    return true;

                }
            } else {
                return false;
            }

            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        String encryptedpassword = null;
        try {
            /* MessageDigest instance for MD5. */
            MessageDigest m = MessageDigest.getInstance("MD5");

            /* Add plain-text password bytes to digest using MD5 update() method. */
            m.update(senha.getBytes());

            /* Convert the hash value into bytes */
            byte[] bytes = m.digest();

            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            /* Complete hashed password in hexadecimal format */
            encryptedpassword = s.toString();
            this.senha = encryptedpassword;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    /**
     * @return the tipoAcesso
     */
    public String getTipoAcesso() {
        return getTipo_Acesso();
    }

    /**
     * @param tipoAcesso the tipoAcesso to set
     */
    public void setTipoAcesso(String tipoAcesso) {
        this.setTipo_Acesso(tipoAcesso);
    }

    /**
     * @return the tipo_Acesso
     */
    public String getTipo_Acesso() {
        return tipo_Acesso;
    }

    /**
     * @param tipo_Acesso the tipo_Acesso to set
     */
    public void setTipo_Acesso(String tipo_Acesso) {
        this.tipo_Acesso = tipo_Acesso;
    }

    /**
     * @return the nomePaciente
     */
    public String getNomePaciente() {
        return nomePaciente;
    }

    /**
     * @param nomePaciente the nomePaciente to set
     */
    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
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
     * @return the nomeMedico
     */
    public String getNomeMedico() {
        return nomeMedico;
    }

    /**
     * @param nomeMedico the nomeMedico to set
     */
    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
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
     * @return the nomeLaboratorio
     */
    public String getNomeLaboratorio() {
        return nomeLaboratorio;
    }

    /**
     * @param nomeLaboratorio the nomeLaboratorio to set
     */
    public void setNomeLaboratorio(String nomeLaboratorio) {
        this.nomeLaboratorio = nomeLaboratorio;
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

}

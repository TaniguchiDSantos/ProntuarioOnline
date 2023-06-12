package com.mycompany.telasa3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Exame_Sangue {

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

    private int codigoExame;
    private int id_Paciente;
    private int id_Laboratorio;
    private int hemacias;
    private int hematocritos;
    private int hemoglobinas;
    private int volume_Globular_Medio;
    private int leucocitos;
    private int plaquetas;
    private String observacao;
    private Date data_Criacao;
    private String responsavel_Criacao;
    private String nomePaciente;
    private String nomeLaboratorio;

    public boolean cadastraExame() {
        //1: Definir o comando SQL
        String sql = "INSERT INTO Exames_Sangue(id_Paciente,id_Laboratorio,hemacias,hematocritos,volume_Globular_Medio,leucocitos,plaquetas,observacao,data_Criacao,responsavel_Criacao,hemoglobinas) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //4: Preenche os dados faltantes
            ps.setInt(1, getPacienteID());
            ps.setInt(2, getLaboratorioID());
            ps.setInt(3, getHemacias());
            ps.setInt(4, getHematocrito());
            ps.setInt(5, getVolumeGlobularMedio());
            ps.setInt(6, getLeucocitos());
            ps.setInt(7, getPlaquetas());
            ps.setString(8, getObservacao());
            ps.setDate(9, getDataCriacao());
            ps.setString(10, getResponsavelCriacao());
            ps.setInt(11, getHemoglobinas());
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

    public Exame_Sangue consultaExame(int codigoExame) {
        Exame_Sangue exame = new Exame_Sangue();
        //1: Definir o comando SQL
        String sql = "Select * from Exames_Sangue "
                + "INNER JOIN Pacientes  ON Exames_Sangue.ID_Paciente = Pacientes.Paciente_ID "
                + "INNER JOIN Laboratorios  ON Exames_Sangue.ID_Laboratorio = Laboratorios.Laboratorio_ID "
                + "where Codigo_Exame = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setInt(1, codigoExame);
            //5: Executa o comando
            rs = ps.executeQuery();

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    exame.setCodigoExame(rs.getInt("Codigo_Exame"));
                    exame.setNomePaciente(rs.getString("NomePaciente"));
                    exame.setNomeLaboratorio(rs.getString("NomeLaboratorio"));
                    exame.setLaboratorioID(rs.getInt("ID_Laboratorio"));
                    exame.setHemacias(rs.getInt("Hematocritos"));
                    exame.setHematocrito(rs.getInt("Hematocritos"));
                    exame.setVolumeGlobularMedio(rs.getInt("Volume_Globular_Medio"));
                    exame.setLeucocitos(rs.getInt("Leucocitos"));
                    exame.setPlaquetas(rs.getInt("Plaquetas"));
                    exame.setObservacao(rs.getString("Observacao"));
                    exame.setDataCriacao(rs.getDate("Data_Criacao"));
                    exame.setResponsavelCriacao(rs.getString("Responsavel_criacao"));
                    exame.setHemoglobinas(rs.getInt("Hemoglobinas"));
                }
            } else {

                exame = null;
            }

            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exame;
    }
    
    public Exame_Sangue consultaExamePaciente(int codigoExame, int id) {
        Exame_Sangue exame = new Exame_Sangue();
        //1: Definir o comando SQL
        String sql = "Select * from Exames_Sangue "
                + "INNER JOIN Pacientes  ON Exames_Sangue.ID_Paciente = Pacientes.Paciente_ID "
                + "INNER JOIN Laboratorios  ON Exames_Sangue.ID_Laboratorio = Laboratorios.Laboratorio_ID "
                + "where Codigo_Exame = ? AND ID_Paciente = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setInt(1, codigoExame);
            ps.setInt(2, id);
            //5: Executa o comando
            rs = ps.executeQuery();

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    exame.setCodigoExame(rs.getInt("Codigo_Exame"));
                    exame.setNomePaciente(rs.getString("NomePaciente"));
                    exame.setNomeLaboratorio(rs.getString("NomeLaboratorio"));
                    exame.setLaboratorioID(rs.getInt("ID_Laboratorio"));
                    exame.setHemacias(rs.getInt("Hematocritos"));
                    exame.setHematocrito(rs.getInt("Hematocritos"));
                    exame.setVolumeGlobularMedio(rs.getInt("Volume_Globular_Medio"));
                    exame.setLeucocitos(rs.getInt("Leucocitos"));
                    exame.setPlaquetas(rs.getInt("Plaquetas"));
                    exame.setObservacao(rs.getString("Observacao"));
                    exame.setDataCriacao(rs.getDate("Data_Criacao"));
                    exame.setResponsavelCriacao(rs.getString("Responsavel_criacao"));
                    exame.setHemoglobinas(rs.getInt("Hemoglobinas"));
                }
            } else {

                exame = null;
            }

            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exame;
    }
    
      public Exame_Sangue consultaExameLaboratorio(int codigoExame, int id) {
        Exame_Sangue exame = new Exame_Sangue();
        //1: Definir o comando SQL
        String sql = "Select * from Exames_Sangue "
                + "INNER JOIN Pacientes  ON Exames_Sangue.ID_Paciente = Pacientes.Paciente_ID "
                + "INNER JOIN Laboratorios  ON Exames_Sangue.ID_Laboratorio = Laboratorios.Laboratorio_ID "
                + "where Codigo_Exame = ? AND ID_Laboratorio = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Preenche os dados faltantes
            ps.setInt(1, codigoExame);
            ps.setInt(2, id);
            //5: Executa o comando
            rs = ps.executeQuery();

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    exame.setCodigoExame(rs.getInt("Codigo_Exame"));
                    exame.setNomePaciente(rs.getString("NomePaciente"));
                    exame.setNomeLaboratorio(rs.getString("NomeLaboratorio"));
                    exame.setLaboratorioID(rs.getInt("ID_Laboratorio"));
                    exame.setHemacias(rs.getInt("Hematocritos"));
                    exame.setHematocrito(rs.getInt("Hematocritos"));
                    exame.setVolumeGlobularMedio(rs.getInt("Volume_Globular_Medio"));
                    exame.setLeucocitos(rs.getInt("Leucocitos"));
                    exame.setPlaquetas(rs.getInt("Plaquetas"));
                    exame.setObservacao(rs.getString("Observacao"));
                    exame.setDataCriacao(rs.getDate("Data_Criacao"));
                    exame.setResponsavelCriacao(rs.getString("Responsavel_criacao"));
                    exame.setHemoglobinas(rs.getInt("Hemoglobinas"));
                }
            } else {

                exame = null;
            }

            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exame;
    }

    public List<Exame_Sangue> listaExames() {
        List exames = new ArrayList<>();

        //1: Definir o comando SQL
        String sql = "Select * from Exames_Sangue "
                + "INNER JOIN Pacientes  ON Exames_Sangue.ID_Paciente = Pacientes.Paciente_ID "
                + "INNER JOIN Laboratorios  ON Exames_Sangue.ID_Laboratorio = Laboratorios.Laboratorio_ID ";
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
                    Exame_Sangue exame = new Exame_Sangue();
                    exame.setCodigoExame(rs.getInt("Codigo_Exame"));
                    exame.setNomePaciente(rs.getString("NomePaciente"));
                    exame.setNomeLaboratorio(rs.getString("NomeLaboratorio"));
                    exame.setHemacias(rs.getInt("Hematocritos"));
                    exame.setHematocrito(rs.getInt("Hematocritos"));
                    exame.setVolumeGlobularMedio(rs.getInt("Volume_Globular_Medio"));
                    exame.setLeucocitos(rs.getInt("Leucocitos"));
                    exame.setPlaquetas(rs.getInt("Plaquetas"));
                    exame.setObservacao(rs.getString("Observacao"));
                    exame.setDataCriacao(rs.getDate("Data_Criacao"));
                    exame.setResponsavelCriacao(rs.getString("Responsavel_criacao"));
                    exame.setHemoglobinas(rs.getInt("Hemoglobinas"));

                    exames.add(exame);
                }
            } else {

                exames = null;
            }

            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return exames;
    }
    
    public List<Exame_Sangue> listaExamesPaciente() {
        List exames = new ArrayList<>();

        //1: Definir o comando SQL
        String sql = "Select * from Exames_Sangue "
                + "INNER JOIN Pacientes  ON Exames_Sangue.ID_Paciente = Pacientes.Paciente_ID "
                + "INNER JOIN Laboratorios  ON Exames_Sangue.ID_Laboratorio = Laboratorios.Laboratorio_ID "
                + "where ID_Paciente = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
             ps.setInt(1, id_Paciente);
            //4: Executa o comando
            rs = ps.executeQuery();

            if (rs.isBeforeFirst()) {
                rs.beforeFirst();
                while (rs.next()) {
                    Exame_Sangue exame = new Exame_Sangue();
                    exame.setCodigoExame(rs.getInt("Codigo_Exame"));
                    exame.setNomePaciente(rs.getString("NomePaciente"));
                    exame.setNomeLaboratorio(rs.getString("NomeLaboratorio"));
                    exame.setHemacias(rs.getInt("Hematocritos"));
                    exame.setHematocrito(rs.getInt("Hematocritos"));
                    exame.setVolumeGlobularMedio(rs.getInt("Volume_Globular_Medio"));
                    exame.setLeucocitos(rs.getInt("Leucocitos"));
                    exame.setPlaquetas(rs.getInt("Plaquetas"));
                    exame.setObservacao(rs.getString("Observacao"));
                    exame.setDataCriacao(rs.getDate("Data_Criacao"));
                    exame.setResponsavelCriacao(rs.getString("Responsavel_criacao"));
                    exame.setHemoglobinas(rs.getInt("Hemoglobinas"));

                    exames.add(exame);
                }
            } else {

                exames = null;
            }

            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return exames;
    }
    
    public List<Exame_Sangue> listaExamesLaboratorio() {
        List exames = new ArrayList<>();

        //1: Definir o comando SQL
        String sql = "Select * from Exames_Sangue "
                + "INNER JOIN Pacientes  ON Exames_Sangue.ID_Paciente = Pacientes.Paciente_ID "
                + "INNER JOIN Laboratorios  ON Exames_Sangue.ID_Laboratorio = Laboratorios.Laboratorio_ID "
                + "where  ID_Laboratorio = ?";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        ResultSet rs = null;
        try (Connection c = factory.obtemConexao()) {
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
             ps.setInt(1, id_Laboratorio);
            //4: Executa o comando
            rs = ps.executeQuery();

            if (rs.isBeforeFirst()) {
                rs.beforeFirst();
                while (rs.next()) {
                    Exame_Sangue exame = new Exame_Sangue();
                    exame.setCodigoExame(rs.getInt("Codigo_Exame"));
                    exame.setNomePaciente(rs.getString("NomePaciente"));
                    exame.setNomeLaboratorio(rs.getString("NomeLaboratorio"));
                    exame.setHemacias(rs.getInt("Hematocritos"));
                    exame.setHematocrito(rs.getInt("Hematocritos"));
                    exame.setVolumeGlobularMedio(rs.getInt("Volume_Globular_Medio"));
                    exame.setLeucocitos(rs.getInt("Leucocitos"));
                    exame.setPlaquetas(rs.getInt("Plaquetas"));
                    exame.setObservacao(rs.getString("Observacao"));
                    exame.setDataCriacao(rs.getDate("Data_Criacao"));
                    exame.setResponsavelCriacao(rs.getString("Responsavel_criacao"));
                    exame.setHemoglobinas(rs.getInt("Hemoglobinas"));

                    exames.add(exame);
                }
            } else {

                exames = null;
            }

            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return exames;
    }

    /**
     * @return the codigoExame
     */
    public int getCodigoExame() {
        return codigoExame;
    }

    /**
     * @param codigoExame the codigoExame to set
     */
    public void setCodigoExame(int codigoExame) {
        this.codigoExame = codigoExame;
    }

    /**
     * @return the pacienteID
     */
    public int getPacienteID() {
        return id_Paciente;
    }

    /**
     * @param pacienteID the pacienteID to set
     */
    public void setPacienteID(int pacienteID) {
        this.id_Paciente = pacienteID;
    }

    /**
     * @return the laboratorioID
     */
    public int getLaboratorioID() {
        return id_Laboratorio;
    }

    /**
     * @param laboratorioID the laboratorioID to set
     */
    public void setLaboratorioID(int laboratorioID) {
        this.id_Laboratorio = laboratorioID;
    }

    /**
     * @return the hemacias
     */
    public int getHemacias() {
        return hemacias;
    }

    /**
     * @param hemacias the hemacias to set
     */
    public void setHemacias(int hemacias) {
        this.hemacias = hemacias;
    }

    /**
     * @return the hematocrito
     */
    public int getHematocrito() {
        return hematocritos;
    }

    /**
     * @param hematocrito the hematocrito to set
     */
    public void setHematocrito(int hematocrito) {
        this.hematocritos = hematocrito;
    }

    /**
     * @return the volumeGlobularMedio
     */
    public int getVolumeGlobularMedio() {
        return volume_Globular_Medio;
    }

    /**
     * @param volumeGlobularMedio the volumeGlobularMedio to set
     */
    public void setVolumeGlobularMedio(int volumeGlobularMedio) {
        this.volume_Globular_Medio = volumeGlobularMedio;
    }

    /**
     * @return the leucocitos
     */
    public int getLeucocitos() {
        return leucocitos;
    }

    /**
     * @param leucocitos the leucocitos to set
     */
    public void setLeucocitos(int leucocitos) {
        this.leucocitos = leucocitos;
    }

    /**
     * @return the plaquetas
     */
    public int getPlaquetas() {
        return plaquetas;
    }

    /**
     * @param plaquetas the plaquetas to set
     */
    public void setPlaquetas(int plaquetas) {
        this.plaquetas = plaquetas;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the dataCriacao
     */
    public Date getDataCriacao() {
        return data_Criacao;
    }

    /**
     * @param dataCriacao the dataCriacao to set
     */
    public void setDataCriacao(Date dataCriacao) {
        this.data_Criacao = dataCriacao;
    }

    /**
     * @return the responsavelCriacao
     */
    public String getResponsavelCriacao() {
        return responsavel_Criacao;
    }

    /**
     * @param responsavelCriacao the responsavelCriacao to set
     */
    public void setResponsavelCriacao(String responsavelCriacao) {
        this.responsavel_Criacao = responsavelCriacao;
    }

    /**
     * @return the hemoglobinas
     */
    public int getHemoglobinas() {
        return hemoglobinas;
    }

    /**
     * @param hemoglobinas the hemoglobinas to set
     */
    public void setHemoglobinas(int hemoglobinas) {
        this.hemoglobinas = hemoglobinas;
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
}

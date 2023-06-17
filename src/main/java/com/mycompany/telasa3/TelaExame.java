/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.telasa3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tanig
 */
public class TelaExame extends javax.swing.JFrame {

    /**
     * Creates new form TelaExame
     */
    public TelaExame() {
        initComponents();
        List<Exame_Sangue> exames = new ArrayList<Exame_Sangue>();
        Exame_Sangue exameSangue = new Exame_Sangue();
        exames = exameSangue.listaExames();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        if (exames != null) {
            for (final Exame_Sangue exame : exames) {
                model.addRow(new Object[]{exame.getCodigoExame(), exame.getNomePaciente(), exame.getNomeLaboratorio(), exame.getHemacias(), exame.getHematocrito(), exame.getHemoglobinas(), exame.getVolumeGlobularMedio(), exame.getLeucocitos(), exame.getPlaquetas(), exame.getObservacao(), exame.getDataCriacao(), exame.getResponsavelCriacao()});
            }
        }
    }

    public TelaExame(String id, String nome, String tipoAcesso) {
        initComponents();
        jLabelIDHide.setText(id);
        jLabelNome.setText(nome);
        jLabelTipoAcesso.setText(tipoAcesso);
        jPanelInfoHide.setVisible(false);
        if (tipoAcesso.equals("Paciente")) {
            List<Exame_Sangue> exames = new ArrayList<Exame_Sangue>();
            Exame_Sangue exameSangue = new Exame_Sangue();
            exameSangue.setPacienteID(Integer.parseInt(jLabelIDHide.getText()));
            exames = exameSangue.listaExamesPaciente();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            if (exames != null) {
                for (final Exame_Sangue exame : exames) {
                    model.addRow(new Object[]{exame.getCodigoExame(), exame.getNomePaciente(), exame.getNomeLaboratorio(), exame.getHemacias(), exame.getHematocrito(), exame.getHemoglobinas(), exame.getVolumeGlobularMedio(), exame.getLeucocitos(), exame.getPlaquetas(), exame.getObservacao(), exame.getDataCriacao(), exame.getResponsavelCriacao()});
                }
            }
        } else if (tipoAcesso.equals("Laboratorio")) {
            List<Exame_Sangue> exames = new ArrayList<Exame_Sangue>();
            Exame_Sangue exameSangue = new Exame_Sangue();
            exameSangue.setLaboratorioID(Integer.parseInt(jLabelIDHide.getText()));
            exames = exameSangue.listaExamesLaboratorio();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            if (exames != null) {
                for (final Exame_Sangue exame : exames) {
                    model.addRow(new Object[]{exame.getCodigoExame(), exame.getNomePaciente(), exame.getNomeLaboratorio(), exame.getHemacias(), exame.getHematocrito(), exame.getHemoglobinas(), exame.getVolumeGlobularMedio(), exame.getLeucocitos(), exame.getPlaquetas(), exame.getObservacao(), exame.getDataCriacao(), exame.getResponsavelCriacao()});
                }
            }
        } else {
            List<Exame_Sangue> exames = new ArrayList<Exame_Sangue>();
            Exame_Sangue exameSangue = new Exame_Sangue();
            exames = exameSangue.listaExames();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            if (exames != null) {
                for (final Exame_Sangue exame : exames) {
                    model.addRow(new Object[]{exame.getCodigoExame(), exame.getNomePaciente(), exame.getNomeLaboratorio(), exame.getHemacias(), exame.getHematocrito(), exame.getHemoglobinas(), exame.getVolumeGlobularMedio(), exame.getLeucocitos(), exame.getPlaquetas(), exame.getObservacao(), exame.getDataCriacao(), exame.getResponsavelCriacao()});
                }
            }
        }
        if (tipoAcesso.equals("Laboratorio") || tipoAcesso.equals("admin")) {
            jLabelAddIcon.setVisible(true);
        } else if (!tipoAcesso.equals("Laboratorio") || !tipoAcesso.equals("admin")) {
            jLabelAddIcon.setVisible(false);
        }

        visibilidadeMenu();
    }

    public void visibilidadeMenu() {
        if (jLabelTipoAcesso.getText().equals("Paciente")) {
            tab2.setVisible(true);
            tab2.setVisible(false);
            tab3.setVisible(false);
            tab4.setVisible(false);
        } else if (jLabelTipoAcesso.getText().equals("Medico")) {
            tab2.setVisible(true);
            tab2.setVisible(true);
            tab3.setVisible(false);
            tab4.setVisible(false);
        } else if (jLabelTipoAcesso.getText().equals("Laboratorio")) {
            tab2.setVisible(true);
            tab2.setVisible(true);
            tab3.setVisible(false);
            tab4.setVisible(false);
        } else {
            tab2.setVisible(true);
            tab2.setVisible(true);
            tab3.setVisible(true);
            tab4.setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGeral = new javax.swing.JPanel();
        jPanelTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelAddIcon = new javax.swing.JLabel();
        jPanelInfoHide = new javax.swing.JPanel();
        jLabelNomeHide = new javax.swing.JLabel();
        jLabelIDHide = new javax.swing.JLabel();
        jPanelInfo = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabelTipoAcesso = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tab1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tab2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tab3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tab4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tab5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanelSearchField = new javax.swing.JPanel();
        jTextSearch = new javax.swing.JTextField();
        jLabelSearchIcon = new javax.swing.JLabel();
        jTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelGeral.setBackground(new java.awt.Color(185, 244, 115));

        jTable1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código Exame", "Paciente", "Laboratorio", "Hemacias", "Hematocrito", "Hemoglobina", "Volume Globular Medio", "Leucocitos", "Plaquetas", "Observação", "Data Criação", "Responsável"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanelTableLayout = new javax.swing.GroupLayout(jPanelTable);
        jPanelTable.setLayout(jPanelTableLayout);
        jPanelTableLayout.setHorizontalGroup(
            jPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        jPanelTableLayout.setVerticalGroup(
            jPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
        );

        jLabelAddIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\tanig\\Downloads\\telasA3\\src\\main\\java\\com\\mycompany\\telasa3\\add32.png")); // NOI18N
        jLabelAddIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddIconMouseClicked(evt);
            }
        });

        jPanelInfoHide.setBackground(new java.awt.Color(185, 244, 115));

        javax.swing.GroupLayout jPanelInfoHideLayout = new javax.swing.GroupLayout(jPanelInfoHide);
        jPanelInfoHide.setLayout(jPanelInfoHideLayout);
        jPanelInfoHideLayout.setHorizontalGroup(
            jPanelInfoHideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoHideLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInfoHideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNomeHide)
                    .addComponent(jLabelIDHide))
                .addContainerGap(506, Short.MAX_VALUE))
        );
        jPanelInfoHideLayout.setVerticalGroup(
            jPanelInfoHideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoHideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNomeHide)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelIDHide)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanelInfo.setBackground(new java.awt.Color(185, 244, 115));

        jLabelNome.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(255, 255, 255));

        jLabelTipoAcesso.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabelTipoAcesso.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelInfoLayout = new javax.swing.GroupLayout(jPanelInfo);
        jPanelInfo.setLayout(jPanelInfoLayout);
        jPanelInfoLayout.setHorizontalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelInfoLayout.createSequentialGroup()
                .addComponent(jLabelTipoAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelInfoLayout.setVerticalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTipoAcesso, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(86, 230, 44));
        jPanel1.setForeground(new java.awt.Color(86, 230, 44));

        tab1.setBackground(new java.awt.Color(0, 153, 153));
        tab1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Exame");

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
        );

        tab2.setBackground(new java.awt.Color(0, 153, 153));
        tab2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        tab2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab2MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Paciente");

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab3.setBackground(new java.awt.Color(0, 153, 153));
        tab3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        tab3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab3MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Médico");

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab4.setBackground(new java.awt.Color(0, 153, 153));
        tab4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        tab4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab4MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Laboratório");

        javax.swing.GroupLayout tab4Layout = new javax.swing.GroupLayout(tab4);
        tab4.setLayout(tab4Layout);
        tab4Layout.setHorizontalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab4Layout.setVerticalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("VITAMED");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        tab5.setBackground(new java.awt.Color(0, 153, 153));
        tab5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        tab5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab5MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Sair");

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\tanig\\Downloads\\icons8-sair-50.png")); // NOI18N

        javax.swing.GroupLayout tab5Layout = new javax.swing.GroupLayout(tab5);
        tab5.setLayout(tab5Layout);
        tab5Layout.setHorizontalGroup(
            tab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(59, 59, 59)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab5Layout.setVerticalGroup(
            tab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel5)))
                .addContainerGap(123, Short.MAX_VALUE))
            .addComponent(tab5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(tab1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelSearchField.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSearchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        jTextSearch.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTextSearch.setToolTipText("Pesquise Pelo Código do Exame");
        jTextSearch.setBorder(null);

        jLabelSearchIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\tanig\\Downloads\\telasA3\\src\\main\\java\\com\\mycompany\\telasa3\\icons8-search-50.png")); // NOI18N
        jLabelSearchIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSearchIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelSearchFieldLayout = new javax.swing.GroupLayout(jPanelSearchField);
        jPanelSearchField.setLayout(jPanelSearchFieldLayout);
        jPanelSearchFieldLayout.setHorizontalGroup(
            jPanelSearchFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSearchFieldLayout.createSequentialGroup()
                .addComponent(jLabelSearchIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
        );
        jPanelSearchFieldLayout.setVerticalGroup(
            jPanelSearchFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSearchIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jTextSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jTitle.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jTitle.setText("EXAMES");

        javax.swing.GroupLayout jPanelGeralLayout = new javax.swing.GroupLayout(jPanelGeral);
        jPanelGeral.setLayout(jPanelGeralLayout);
        jPanelGeralLayout.setHorizontalGroup(
            jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGeralLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelGeralLayout.createSequentialGroup()
                                .addComponent(jTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelAddIcon))
                            .addComponent(jPanelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelGeralLayout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jPanelSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanelInfoHide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(301, 301, 301))
        );
        jPanelGeralLayout.setVerticalGroup(
            jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAddIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTitle, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGeralLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelGeralLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jPanelInfoHide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelSearchIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSearchIconMouseClicked
        Exame_Sangue exame = new Exame_Sangue();
        if (jLabelTipoAcesso.getText().equals("Paciente")) {
            Exame_Sangue exameSangue = exame.consultaExamePaciente(Integer.parseInt(jTextSearch.getText()), Integer.parseInt(jLabelIDHide.getText()));
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            if (exameSangue != null) {
                model.setRowCount(0);
                model.addRow(new Object[]{exameSangue.getCodigoExame(), exameSangue.getNomePaciente(), exameSangue.getNomeLaboratorio(), exameSangue.getHemacias(), exameSangue.getHematocrito(), exameSangue.getHemoglobinas(), exameSangue.getVolumeGlobularMedio(), exameSangue.getLeucocitos(), exameSangue.getPlaquetas(), exameSangue.getObservacao(), exameSangue.getDataCriacao(), exameSangue.getResponsavelCriacao()});
            }
        } else if (jLabelTipoAcesso.getText().equals("Laboratorio")) {
            Exame_Sangue exameSangue = exame.consultaExameLaboratorio(Integer.parseInt(jTextSearch.getText()), Integer.parseInt(jLabelIDHide.getText()));
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            if (exameSangue != null) {
                model.setRowCount(0);
                model.addRow(new Object[]{exameSangue.getCodigoExame(), exameSangue.getNomePaciente(), exameSangue.getNomeLaboratorio(), exameSangue.getHemacias(), exameSangue.getHematocrito(), exameSangue.getHemoglobinas(), exameSangue.getVolumeGlobularMedio(), exameSangue.getLeucocitos(), exameSangue.getPlaquetas(), exameSangue.getObservacao(), exameSangue.getDataCriacao(), exameSangue.getResponsavelCriacao()});
            }
        } else {
            Exame_Sangue exameSangue = exame.consultaExame(Integer.parseInt(jTextSearch.getText()));
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            if (exameSangue != null) {
                model.setRowCount(0);
                model.addRow(new Object[]{exameSangue.getCodigoExame(), exameSangue.getNomePaciente(), exameSangue.getNomeLaboratorio(), exameSangue.getHemacias(), exameSangue.getHematocrito(), exameSangue.getHemoglobinas(), exameSangue.getVolumeGlobularMedio(), exameSangue.getLeucocitos(), exameSangue.getPlaquetas(), exameSangue.getObservacao(), exameSangue.getDataCriacao(), exameSangue.getResponsavelCriacao()});
            }
        }

    }//GEN-LAST:event_jLabelSearchIconMouseClicked

    private void jLabelAddIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddIconMouseClicked
        // TODO add your handling code here:
        new TelaExame_Cadastro(jLabelIDHide.getText(), jLabelNome.getText(), jLabelTipoAcesso.getText()).setVisible(true); // Open the Second.java window
        dispose();
    }//GEN-LAST:event_jLabelAddIconMouseClicked

    private void tab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab1MouseClicked

        new TelaExame(jLabelIDHide.getText(),jLabelNome.getText(), jLabelTipoAcesso.getText()).setVisible(true); // Open the Second.java window
    }//GEN-LAST:event_tab1MouseClicked

    private void tab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab2MouseClicked
        new TelaPaciente(jLabelIDHide.getText(),jLabelNome.getText(), jLabelTipoAcesso.getText()).setVisible(true); // Open the Second.java window
        dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_tab2MouseClicked

    private void tab3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab3MouseClicked
        new TelaMedico(jLabelIDHide.getText(),jLabelNome.getText(), jLabelTipoAcesso.getText()).setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_tab3MouseClicked

    private void tab4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab4MouseClicked
        new TelaLaboratorio(jLabelIDHide.getText(),jLabelNome.getText(), jLabelTipoAcesso.getText()).setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_tab4MouseClicked

    private void tab5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab5MouseClicked
        new TelaLogin().setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_tab5MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaExame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaExame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAddIcon;
    private javax.swing.JLabel jLabelIDHide;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeHide;
    private javax.swing.JLabel jLabelSearchIcon;
    private javax.swing.JLabel jLabelTipoAcesso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelGeral;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JPanel jPanelInfoHide;
    private javax.swing.JPanel jPanelSearchField;
    private javax.swing.JPanel jPanelTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextSearch;
    private javax.swing.JLabel jTitle;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    private javax.swing.JPanel tab5;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shipping;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pastaFuncionario.Funcionario;
import pastaFuncionario.FuncionarioDados;
import pastaLeituraProtocolo.LeituraProtocolo;
import pastaLeituraProtocolo.LeituraProtocoloDados;
import pastaProtocolo.Protocolo;
import pastaProtocolo.ProtocoloDados;
import pastaProtocolo.ProtocoloNegocio;

/**
 *
 * @author Jerson e Pedro
 */
public class TelaShipping extends javax.swing.JFrame {

    ArrayList<Funcionario> listaFunc = null;
    ArrayList<Protocolo> listaProtocolo = null;
    ArrayList<LeituraProtocolo> listaLeituraProtocolo = null;
    Funcionario funcionarioLogado;

    public TelaShipping(Funcionario f) {
      
        initComponents();
        setSize(735, 570);
        this.funcionarioLogado = f;

        jLabelMatriFuncLogado.setText("Sua matricula: " + this.funcionarioLogado.getMatricula());
        this.setLocationRelativeTo(null);
        jTableRecebidos.requestFocus();

    }

    public void atualizarFuncionario() {

        try {
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            FuncionarioDados dadosF = new FuncionarioDados();

            listaFunc = dadosF.listarFuncionario();
            for (Funcionario f1 : listaFunc) {
                modelo.addElement(f1.getNomeFuncionario());
            }
            cBDestinatario.setModel(modelo);
            cBDestinatario.setSelectedIndex(-1);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //criação da Tabela para listar os protocolos enviados
    private void listarEnviados() {
        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        modelo.setColumnIdentifiers(new String[]{"Data", "Hora", "Destinatário", "Setor", "Título"});
        try {

            ProtocoloDados dadosP = new ProtocoloDados();
            listaProtocolo = dadosP.listarProtocoloEnviados(funcionarioLogado);

            for (Protocolo p1 : listaProtocolo) {
                modelo.addRow(new String[]{""
                    + p1.getData(),
                    p1.getHora(),
                    p1.getDestinatario().getNomeFuncionario(),
                    p1.getDestinatario().getSetor().getNomeSetor(),
                    p1.getTitulo()
                });
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        jTableEnviados.setModel(modelo);
        jTableEnviados.getColumnModel().getColumn(0).setPreferredWidth(65);
        jTableEnviados.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTableEnviados.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableEnviados.getColumnModel().getColumn(3).setPreferredWidth(85);
        jTableEnviados.getColumnModel().getColumn(4).setPreferredWidth(150);
    }

    //criação da Tabela para listar os protocolos recebidos
    private void listarRecebidos() {
        try {
            DefaultTableModel modelo1 = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

            };
            modelo1.setColumnIdentifiers(new String[]{"Data", "Hora", "Emissário", "Setor", "Título"});

            ProtocoloDados dadosP = new ProtocoloDados();
            listaProtocolo = dadosP.listarProtocoloRecebido(funcionarioLogado);

            for (Protocolo p1 : listaProtocolo) {
                modelo1.addRow(new String[]{""
                    + p1.getData(),
                    p1.getHora(),
                    p1.getEmissario().getNomeFuncionario(),
                    p1.getEmissario().getSetor().getNomeSetor(),
                    p1.getTitulo()
                });
            }
            jTableRecebidos.setModel(modelo1);
            jTableRecebidos.getColumnModel().getColumn(0).setPreferredWidth(65);
            jTableRecebidos.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTableRecebidos.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableRecebidos.getColumnModel().getColumn(3).setPreferredWidth(85);
            jTableRecebidos.getColumnModel().getColumn(4).setPreferredWidth(150);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        abaMenu = new javax.swing.JTabbedPane();
        abaMenuRecebidos = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRecebidos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldMostrarLink = new javax.swing.JTextField();
        jButtonIrUrl = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        abaMenuEnviados = new javax.swing.JDesktopPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableEnviados = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabelQntAcessos = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        abaMenuNovo = new javax.swing.JDesktopPane();
        cBDestinatario = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldLink = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jButtonEnviar = new javax.swing.JButton();
        jLabelMatriFuncLogado = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuArquivoNovoProtocolo = new javax.swing.JMenuItem();
        menuArquivoSair = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenu();
        menuEditarFuncionario = new javax.swing.JMenuItem();
        menuEditarSetor = new javax.swing.JMenuItem();
        menuNovo = new javax.swing.JMenu();
        menuNovoFuncionario = new javax.swing.JMenuItem();
        menuNovoSetor = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuRemoverSetor = new javax.swing.JMenuItem();
        jMenuItemRemoverFuncionario = new javax.swing.JMenuItem();

        jButton1.setText("jButton1");

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addGap(74, 74, 74))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        abaMenuRecebidos.setBackground(new java.awt.Color(204, 204, 204));
        abaMenuRecebidos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableRecebidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableRecebidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTableRecebidosFocusGained(evt);
            }
        });
        jTableRecebidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRecebidosMouseClicked(evt);
            }
        });
        jTableRecebidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableRecebidosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRecebidos);

        abaMenuRecebidos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 370));

        jLabel4.setFont(new java.awt.Font("Bebas Neue Bold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Link para acessar o documento :");
        abaMenuRecebidos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        jTextFieldMostrarLink.setEnabled(false);
        jTextFieldMostrarLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMostrarLinkActionPerformed(evt);
            }
        });
        abaMenuRecebidos.add(jTextFieldMostrarLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 477, 31));

        jButtonIrUrl.setText("Ir");
        jButtonIrUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIrUrlActionPerformed(evt);
            }
        });
        abaMenuRecebidos.add(jButtonIrUrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 66, 31));

        jButton2.setText("Atualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        abaMenuRecebidos.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, -1, 31));
        abaMenuRecebidos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 375, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shipping/Sem Título-1.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        abaMenuRecebidos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -80, -1, -1));

        abaMenu.addTab("Recebidos", abaMenuRecebidos);

        abaMenuEnviados.setBackground(new java.awt.Color(204, 204, 204));
        abaMenuEnviados.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                abaMenuEnviadosFocusGained(evt);
            }
        });
        abaMenuEnviados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableEnviados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableEnviados.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTableEnviadosFocusGained(evt);
            }
        });
        jTableEnviados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEnviadosMouseClicked(evt);
            }
        });
        jTableEnviados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableEnviadosKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTableEnviados);

        abaMenuEnviados.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 370));

        jLabel5.setFont(new java.awt.Font("Slim Joe", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("de  acessos ");
        abaMenuEnviados.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, -1, -1));

        jLabelQntAcessos.setFont(new java.awt.Font("Intro ", 2, 70)); // NOI18N
        jLabelQntAcessos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelQntAcessos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        abaMenuEnviados.add(jLabelQntAcessos, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 88, 55));

        jLabel6.setFont(new java.awt.Font("Slim Joe", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ao protocolo");
        abaMenuEnviados.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, -1, -1));

        jLabel7.setFont(new java.awt.Font("Big John", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(" selecionado :");
        abaMenuEnviados.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, -1, -1));

        jLabel8.setFont(new java.awt.Font("Big John", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Quantidade ");
        abaMenuEnviados.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, -1, -1));
        abaMenuEnviados.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 374, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shipping/Sem Título-1.png"))); // NOI18N
        abaMenuEnviados.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -80, -1, -1));

        abaMenu.addTab("Enviados", abaMenuEnviados);

        abaMenuNovo.setBackground(new java.awt.Color(91, 91, 95));
        abaMenuNovo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                abaMenuNovoFocusGained(evt);
            }
        });
        abaMenuNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abaMenuNovoMouseClicked(evt);
            }
        });
        abaMenuNovo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cBDestinatario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcionário" }));
        abaMenuNovo.add(cBDestinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 90, 297, 33));

        jLabel1.setFont(new java.awt.Font("Slim Joe", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DestinatArio :");
        abaMenuNovo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, 20));

        jLabel2.setFont(new java.awt.Font("Slim Joe", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Link :");
        abaMenuNovo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        jTextFieldLink.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jTextFieldLink.setText("Cole o link do documento aqui.");
        jTextFieldLink.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldLinkFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldLinkFocusLost(evt);
            }
        });
        abaMenuNovo.add(jTextFieldLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 287, 297, 31));

        jLabel3.setFont(new java.awt.Font("Slim Joe", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Titulo :");
        abaMenuNovo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, 20));

        jTextFieldTitulo.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jTextFieldTitulo.setText("Digite o título do documento.");
        jTextFieldTitulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldTituloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldTituloFocusLost(evt);
            }
        });
        abaMenuNovo.add(jTextFieldTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 190, 297, 31));

        jButtonEnviar.setText("Enviar");
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });
        abaMenuNovo.add(jButtonEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 365, 95, 32));

        jLabelMatriFuncLogado.setFont(new java.awt.Font("Big John", 1, 18)); // NOI18N
        jLabelMatriFuncLogado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMatriFuncLogado.setText("jLabel5");
        abaMenuNovo.add(jLabelMatriFuncLogado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("´");
        abaMenuNovo.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 60, 10));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("´");
        abaMenuNovo.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 50, 10));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shipping/Sem Título-1.png"))); // NOI18N
        abaMenuNovo.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -80, -1, -1));

        abaMenu.addTab("Novo Envio", abaMenuNovo);

        getContentPane().add(abaMenu);
        abaMenu.setBounds(0, 0, 779, 508);

        menuArquivo.setText("Arquivo");

        menuArquivoNovoProtocolo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuArquivoNovoProtocolo.setText("Novo Protocolo");
        menuArquivoNovoProtocolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArquivoNovoProtocoloActionPerformed(evt);
            }
        });
        menuArquivo.add(menuArquivoNovoProtocolo);

        menuArquivoSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        menuArquivoSair.setText("Sair");
        menuArquivoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArquivoSairActionPerformed(evt);
            }
        });
        menuArquivo.add(menuArquivoSair);

        jMenuBar1.add(menuArquivo);

        menuEditar.setText("Editar");

        menuEditarFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        menuEditarFuncionario.setText("Funcionário");
        menuEditarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarFuncionarioActionPerformed(evt);
            }
        });
        menuEditar.add(menuEditarFuncionario);

        menuEditarSetor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuEditarSetor.setText("Setor");
        menuEditarSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarSetorActionPerformed(evt);
            }
        });
        menuEditar.add(menuEditarSetor);

        jMenuBar1.add(menuEditar);

        menuNovo.setText("Novo");

        menuNovoFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        menuNovoFuncionario.setText("Funcionário");
        menuNovoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoFuncionarioActionPerformed(evt);
            }
        });
        menuNovo.add(menuNovoFuncionario);

        menuNovoSetor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        menuNovoSetor.setText("Setor");
        menuNovoSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoSetorActionPerformed(evt);
            }
        });
        menuNovo.add(menuNovoSetor);

        jMenuBar1.add(menuNovo);

        jMenu1.setText("Remover");

        jMenuRemoverSetor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuRemoverSetor.setText("Remover Setor");
        jMenuRemoverSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRemoverSetorActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuRemoverSetor);

        jMenuItemRemoverFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItemRemoverFuncionario.setText("Remover Funcionário");
        jMenuItemRemoverFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRemoverFuncionarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemRemoverFuncionario);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuNovoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoFuncionarioActionPerformed
        TelaNovoFuncionario nF = new TelaNovoFuncionario();
        nF.setVisible(true);
    }//GEN-LAST:event_menuNovoFuncionarioActionPerformed

    private void menuNovoSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoSetorActionPerformed
        TelaNovoSetor novoSetor = new TelaNovoSetor();
        novoSetor.setVisible(true);
    }//GEN-LAST:event_menuNovoSetorActionPerformed

    private void menuEditarSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarSetorActionPerformed
        TelaEditarSetor editarSetor = new TelaEditarSetor();
        editarSetor.setVisible(true);
    }//GEN-LAST:event_menuEditarSetorActionPerformed

    private void menuEditarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarFuncionarioActionPerformed
        TelaEditarFuncionario eF = new TelaEditarFuncionario();
        eF.setVisible(true);
    }//GEN-LAST:event_menuEditarFuncionarioActionPerformed

    private void menuArquivoNovoProtocoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArquivoNovoProtocoloActionPerformed
        this.abaMenu.setSelectedIndex(2);
    }//GEN-LAST:event_menuArquivoNovoProtocoloActionPerformed

    private void jMenuRemoverSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRemoverSetorActionPerformed
        TelaExcluirSetor eS = new TelaExcluirSetor();
        eS.setVisible(true);
    }//GEN-LAST:event_jMenuRemoverSetorActionPerformed

    private void jMenuItemRemoverFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRemoverFuncionarioActionPerformed
        TelaExcluirFuncionario eF = new TelaExcluirFuncionario();
        eF.setVisible(true);
    }//GEN-LAST:event_jMenuItemRemoverFuncionarioActionPerformed

    private void menuArquivoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArquivoSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_menuArquivoSairActionPerformed

    private void abaMenuNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abaMenuNovoMouseClicked
        cBDestinatario.requestFocus();
    }//GEN-LAST:event_abaMenuNovoMouseClicked

    private void abaMenuNovoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_abaMenuNovoFocusGained
        atualizarFuncionario();
    }//GEN-LAST:event_abaMenuNovoFocusGained

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        try {
            if (jTextFieldTitulo.getText().equals("Digite o título do documento.")
                || jTextFieldLink.getText().equals("Cole o link do documento aqui.")) {
                jTextFieldTitulo.setText(null);
                jTextFieldLink.setText(null);
            }
            if (cBDestinatario.getSelectedIndex() < 0) {
                JOptionPane.showMessageDialog(rootPane, "Favor selecionar um funcionário ");
                return;
            } else {
                Protocolo p = new Protocolo();
                Funcionario f = this.listaFunc.get(cBDestinatario.getSelectedIndex());
                p.getEmissario().setMatricula(this.funcionarioLogado.getMatricula());
                p.getDestinatario().setMatricula(f.getMatricula());
                p.setTitulo(jTextFieldTitulo.getText());
                p.setLink(jTextFieldLink.getText());
                ProtocoloNegocio pN = new ProtocoloNegocio();
                pN.gerarProtocolo(p);
                jTextFieldTitulo.setText("");
                jTextFieldLink.setText("");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jMenu1, e.getMessage());
        }
        listarRecebidos();
        listarEnviados();
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    private void jTextFieldTituloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTituloFocusLost
        if (jTextFieldTitulo.getText().equals("")) {
            jTextFieldTitulo.setFont(new Font("Tahoma", Font.ITALIC, 10));
            jTextFieldTitulo.setText("Digite o título do documento.");
        }
    }//GEN-LAST:event_jTextFieldTituloFocusLost

    private void jTextFieldTituloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTituloFocusGained
        if (jTextFieldTitulo.getText().equals("Digite o título do documento.")) {
            jTextFieldTitulo.setText("");
        }

        if (jTextFieldTitulo.getText().equals("")) {
            jTextFieldTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
        }
    }//GEN-LAST:event_jTextFieldTituloFocusGained

    private void jTextFieldLinkFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldLinkFocusLost
        if (jTextFieldLink.getText().equals("")) {
            jTextFieldLink.setFont(new Font("Tahoma", Font.ITALIC, 10));
            jTextFieldLink.setText("Cole o link do documento aqui.");
        }
    }//GEN-LAST:event_jTextFieldLinkFocusLost

    private void jTextFieldLinkFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldLinkFocusGained
        if (jTextFieldLink.getText().equals("Cole o link do documento aqui.")) {
            jTextFieldLink.setText("");
        }

        if (jTextFieldLink.getText().equals("")) {
            jTextFieldLink.setFont(new Font("Tahoma", Font.PLAIN, 12));
        }
    }//GEN-LAST:event_jTextFieldLinkFocusGained

    private void abaMenuEnviadosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_abaMenuEnviadosFocusGained
        listarEnviados();
    }//GEN-LAST:event_abaMenuEnviadosFocusGained

    private void jTableEnviadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableEnviadosKeyPressed
        int index = jTableEnviados.getSelectedRow();

        try {
            if (index < 0) {
                index = 0;
            }
            Protocolo p = this.listaProtocolo.get(index);
            jLabelQntAcessos.setText("");
            jLabel5.setText("");
            LeituraProtocoloDados dadosL = new LeituraProtocoloDados();
            listaLeituraProtocolo = dadosL.listaLeituraProtocolo(p);
            for (LeituraProtocolo lP : listaLeituraProtocolo) {
                jLabel5.setText("Quantidade de acessos a este envio :");
                jLabelQntAcessos.setText(Integer.toString(lP.getQtdLeitura()));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTableEnviadosKeyPressed

    private void jTableEnviadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEnviadosMouseClicked
        int index = jTableEnviados.getSelectedRow();

        try {
            if (index < 0) {
                index = 0;
            }
            Protocolo p = this.listaProtocolo.get(index);
            jLabelQntAcessos.setText("");
            LeituraProtocoloDados dadosL = new LeituraProtocoloDados();
            listaLeituraProtocolo = dadosL.listaLeituraProtocolo(p);
            for (LeituraProtocolo lP : listaLeituraProtocolo) {
                jLabelQntAcessos.setText(Integer.toString(lP.getQtdLeitura()));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTableEnviadosMouseClicked

    private void jTableEnviadosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableEnviadosFocusGained
        listarEnviados();
    }//GEN-LAST:event_jTableEnviadosFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            listarRecebidos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jMenu1, e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonIrUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIrUrlActionPerformed
        try {
            String URL = jTextFieldMostrarLink.getText();
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(URL));
            LeituraProtocolo leituraP = new LeituraProtocolo();//instancia Leitura de Protocolo
            LeituraProtocoloDados dadosL = new LeituraProtocoloDados();//instancia Dados de Leitura de Protocolo
            int index = jTableRecebidos.getSelectedRow();
            Protocolo p = this.listaProtocolo.get(index);

            //cria Leitura Protocolo
            leituraP.setReferenciaProtocolo(""
                + p.getEmissario().getMatricula()
                + p.getDestinatario().getMatricula());
            leituraP.getProtocolo().setIdEnvio(p.getIdEnvio());
            dadosL.gerarLeituraProtocolo(leituraP);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonIrUrlActionPerformed

    private void jTableRecebidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableRecebidosKeyPressed
        int index = jTableRecebidos.getSelectedRow();

        try {

            Protocolo p = this.listaProtocolo.get(index);
            jTextFieldMostrarLink.setText(p.getLink());

        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTableRecebidosKeyPressed

    private void jTableRecebidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRecebidosMouseClicked
        int index = jTableRecebidos.getSelectedRow();

        try {

            Protocolo p = this.listaProtocolo.get(index);
            jTextFieldMostrarLink.setText(p.getLink());

        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTableRecebidosMouseClicked

    private void jTableRecebidosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableRecebidosFocusGained
        try {
            listarRecebidos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jMenu1, e.getMessage());
        }
    }//GEN-LAST:event_jTableRecebidosFocusGained

    private void jTextFieldMostrarLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMostrarLinkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMostrarLinkActionPerformed

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
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaShipping(new Funcionario()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane abaMenu;
    private javax.swing.JDesktopPane abaMenuEnviados;
    private javax.swing.JDesktopPane abaMenuNovo;
    private javax.swing.JDesktopPane abaMenuRecebidos;
    private javax.swing.JComboBox<String> cBDestinatario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JButton jButtonIrUrl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMatriFuncLogado;
    private javax.swing.JLabel jLabelQntAcessos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemRemoverFuncionario;
    private javax.swing.JMenuItem jMenuRemoverSetor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableEnviados;
    private javax.swing.JTable jTableRecebidos;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldLink;
    private javax.swing.JTextField jTextFieldMostrarLink;
    private javax.swing.JTextField jTextFieldTitulo;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuItem menuArquivoNovoProtocolo;
    private javax.swing.JMenuItem menuArquivoSair;
    private javax.swing.JMenu menuEditar;
    private javax.swing.JMenuItem menuEditarFuncionario;
    private javax.swing.JMenuItem menuEditarSetor;
    private javax.swing.JMenu menuNovo;
    private javax.swing.JMenuItem menuNovoFuncionario;
    private javax.swing.JMenuItem menuNovoSetor;
    // End of variables declaration//GEN-END:variables
}

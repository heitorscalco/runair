/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetotao;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author HeitorScalco
 */
public class TelaAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public TelaAdministrador() {
        initComponents();
        setLocationRelativeTo(null);
//        
//        u.getUsuario(u.usuario);
//        if (u.getTipo_usuario() == 1) {
//            JB_Vender1.setVisible(false);
//        }

        JB_Novo_Evento.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_N, 0), "novo_evento");
        JB_Novo_Evento.getActionMap().put("novo_evento", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                aberto = e.situacaoEvento();
                if (aberto) {

                    JOptionPane.showMessageDialog(null, "Já existe um evento aberto!", "Erro", JOptionPane.ERROR_MESSAGE);

                } else {

                    new TelaAbrirEvento().setVisible(true);

                }

            }
        });

        JB_Fechar_Evento.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F, 0), "fechar_evento");
        JB_Fechar_Evento.getActionMap().put("fechar_evento", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                int opt = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja fechar o evento?", "Atenção", JOptionPane.YES_NO_OPTION);
                aberto = e.situacaoEvento();
                if (aberto && opt == 0) {

                    fechar_evento();
                    JM_Novo.setEnabled(true);
                    JM_Editar.setEnabled(true);
                    JM_Remover.setEnabled(true);

                } else if (!aberto && opt == 0) {

                    JOptionPane.showMessageDialog(null, "Não existe nenhum evento aberto!", "Erro", JOptionPane.ERROR_MESSAGE);

                } else {

                }
            }
        });

        JB_Gerar_Relatorio.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_G, 0), "relatorio");
        JB_Gerar_Relatorio.getActionMap().put("relatorio", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                aberto = e.situacaoEvento();
                if (aberto) {

                    JOptionPane.showMessageDialog(null, "Feche o evento antes de gerar um relatório!", "Erro", JOptionPane.ERROR_MESSAGE);

                } else {

                    new TelaRelatorio().setVisible(true); //chama a tela de relatorio

                }

            }
        });

        JB_Produtos.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "produtos");
        JB_Produtos.getActionMap().put("produtos", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new TelaEditarProduto().setVisible(true);

            }
        });

        JB_Logout.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "logout");
        JB_Logout.getActionMap().put("logout", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new Tela_login().setVisible(true);
                dispose();

            }
        });

        JB_Vender.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_V, 0), "vender");
        JB_Vender.getActionMap().put("vender", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                aberto = e.situacaoEvento();
                if (aberto) {

                    new TelaVenderProduto().setVisible(true); //chamar a tela de venda de produto            

                } else {

                    JOptionPane.showMessageDialog(null, "Não existe nenhum evento aberto!", "Erro", JOptionPane.ERROR_MESSAGE);

                }

            }
        });

        JB_Estoque.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), "estoque");
        //Se for a letra "A", coloca uma ação de clique no botão e executa o que está no método actionPerformed
        JB_Estoque.getActionMap().put("estoque", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent a) {

                new TelaEstoque().setVisible(true);

            }
        });

        aberto = e.situacaoEvento();
        if (aberto) {

            JM_Novo.setEnabled(false);
            JM_Editar.setEnabled(false);
            JM_Remover.setEnabled(false);
        }

        u = new Usuario();
        u.getUsuarioLogado();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JL_Gerenciador_Fichas = new javax.swing.JLabel();
        JB_Fechar_Evento = new javax.swing.JButton();
        JB_Gerar_Relatorio = new javax.swing.JButton();
        JB_Novo_Evento = new javax.swing.JButton();
        JB_Estoque = new javax.swing.JButton();
        JB_Produtos = new javax.swing.JButton();
        JB_Logout = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        JB_Vender = new javax.swing.JButton();
        JB_Vender1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        JM_Novo = new javax.swing.JMenu();
        JMI_NovoProduto = new javax.swing.JMenuItem();
        JMI_NovoUsuario = new javax.swing.JMenuItem();
        JM_Editar = new javax.swing.JMenu();
        JMI_EditarProduto = new javax.swing.JMenuItem();
        JMI_EditarUsuario = new javax.swing.JMenuItem();
        JM_Remover = new javax.swing.JMenu();
        JMI_RemoverProduto = new javax.swing.JMenuItem();
        JMI_RemoverUsuario = new javax.swing.JMenuItem();
        JM_Sobre = new javax.swing.JMenu();
        JMI_Contato = new javax.swing.JMenuItem();
        JMI_Desenvolvimento = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        JL_Gerenciador_Fichas.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        JL_Gerenciador_Fichas.setText("BAR GARANTIDO");

        JB_Fechar_Evento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JB_Fechar_Evento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetotao/logout.png"))); // NOI18N
        JB_Fechar_Evento.setText("FECHAR EVENTO");
        JB_Fechar_Evento.setToolTipText("Pressione F para FECHAR EVENTO");
        JB_Fechar_Evento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Fechar_EventoActionPerformed(evt);
            }
        });

        JB_Gerar_Relatorio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JB_Gerar_Relatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetotao/edit.png"))); // NOI18N
        JB_Gerar_Relatorio.setText("GERAR RELATÓRIO");
        JB_Gerar_Relatorio.setToolTipText("Pressione G para GERAR RELATÓRIO");
        JB_Gerar_Relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Gerar_RelatorioActionPerformed(evt);
            }
        });

        JB_Novo_Evento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JB_Novo_Evento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetotao/add.png"))); // NOI18N
        JB_Novo_Evento.setText("NOVO EVENTO");
        JB_Novo_Evento.setToolTipText("Pressione N para NOVO EVENTO");
        JB_Novo_Evento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Novo_EventoActionPerformed(evt);
            }
        });

        JB_Estoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetotao/estoque.png"))); // NOI18N
        JB_Estoque.setText("ESTOQUE");
        JB_Estoque.setToolTipText("Pressione E para ESTOQUE");
        JB_Estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_EstoqueActionPerformed(evt);
            }
        });

        JB_Produtos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetotao/produto.png"))); // NOI18N
        JB_Produtos.setText("PRODUTOS");
        JB_Produtos.setToolTipText("Pressione P para PRODUTOS");
        JB_Produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ProdutosActionPerformed(evt);
            }
        });

        JB_Logout.setBackground(new java.awt.Color(255, 0, 0));
        JB_Logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JB_Logout.setForeground(new java.awt.Color(255, 255, 255));
        JB_Logout.setText("Logout");
        JB_Logout.setToolTipText("Pressione ESC para LOGOUT");
        JB_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_LogoutActionPerformed(evt);
            }
        });

        JB_Vender.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JB_Vender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetotao/vender.png"))); // NOI18N
        JB_Vender.setText("Vender");
        JB_Vender.setToolTipText("Pressione V para VENDER");
        JB_Vender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_VenderActionPerformed(evt);
            }
        });

        JB_Vender1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JB_Vender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetotao/check.png"))); // NOI18N
        JB_Vender1.setText("Contabilizar");
        JB_Vender1.setToolTipText("Pressione V para VENDER");
        JB_Vender1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Vender1ActionPerformed(evt);
            }
        });

        JM_Novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetotao/add_menu.png"))); // NOI18N
        JM_Novo.setText("Novo");
        JM_Novo.setToolTipText("Pressione F1 para NOVO PRODUTO e F2 para NOVO USUARIO");

        JMI_NovoProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        JMI_NovoProduto.setText("Produto");
        JMI_NovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_NovoProdutoActionPerformed(evt);
            }
        });
        JM_Novo.add(JMI_NovoProduto);

        JMI_NovoUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        JMI_NovoUsuario.setText("Usuário");
        JMI_NovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_NovoUsuarioActionPerformed(evt);
            }
        });
        JM_Novo.add(JMI_NovoUsuario);

        jMenuBar1.add(JM_Novo);

        JM_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetotao/edit_menu.png"))); // NOI18N
        JM_Editar.setText("Editar");
        JM_Editar.setToolTipText("Pressione F3 para EDITAR PRODUTO e F4 para EDITAR USUÁRIO");

        JMI_EditarProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        JMI_EditarProduto.setText("Produto");
        JMI_EditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_EditarProdutoActionPerformed(evt);
            }
        });
        JM_Editar.add(JMI_EditarProduto);

        JMI_EditarUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        JMI_EditarUsuario.setText("Usuário");
        JMI_EditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_EditarUsuarioActionPerformed(evt);
            }
        });
        JM_Editar.add(JMI_EditarUsuario);

        jMenuBar1.add(JM_Editar);

        JM_Remover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetotao/delete_menu.png"))); // NOI18N
        JM_Remover.setText("Remover");
        JM_Remover.setToolTipText("Pressione F5 para REMOVER PRODUTO e F6 para REMOVER USUÁRIO");

        JMI_RemoverProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        JMI_RemoverProduto.setText("Produto");
        JMI_RemoverProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_RemoverProdutoActionPerformed(evt);
            }
        });
        JM_Remover.add(JMI_RemoverProduto);

        JMI_RemoverUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        JMI_RemoverUsuario.setText("Usuário");
        JMI_RemoverUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_RemoverUsuarioActionPerformed(evt);
            }
        });
        JM_Remover.add(JMI_RemoverUsuario);

        jMenuBar1.add(JM_Remover);

        JM_Sobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetotao/info.png"))); // NOI18N
        JM_Sobre.setText("Sobre");
        JM_Sobre.setToolTipText("Pressione F7 para CONTATO e F8 para DESENVOLVIMENTO");

        JMI_Contato.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        JMI_Contato.setText("Contato com a Empresa");
        JMI_Contato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_ContatoActionPerformed(evt);
            }
        });
        JM_Sobre.add(JMI_Contato);

        JMI_Desenvolvimento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        JMI_Desenvolvimento.setText("Desenvolvimento");
        JM_Sobre.add(JMI_Desenvolvimento);

        jMenuBar1.add(JM_Sobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JB_Vender)
                .addGap(73, 73, 73)
                .addComponent(JB_Vender1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JB_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(JB_Produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JB_Estoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(JB_Novo_Evento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JB_Fechar_Evento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JB_Gerar_Relatorio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JL_Gerenciador_Fichas)
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_Gerenciador_Fichas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JB_Novo_Evento, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JB_Fechar_Evento, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JB_Gerar_Relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_Produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JB_Logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JB_Vender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JB_Vender1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_Gerar_RelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Gerar_RelatorioActionPerformed

        new TelaRelatorio().setVisible(true); //chama a tela de relatorio

    }//GEN-LAST:event_JB_Gerar_RelatorioActionPerformed

    private void JB_ProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ProdutosActionPerformed

        aberto = e.situacaoEvento();
        if (aberto) {

            JOptionPane.showMessageDialog(null, "Não é possível alterar produtos enquanto um evento está aberto!", "Erro", JOptionPane.ERROR_MESSAGE);

        } else {

            new TelaMainProdutos().setVisible(true);

        }
    }//GEN-LAST:event_JB_ProdutosActionPerformed

    private void JB_Novo_EventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Novo_EventoActionPerformed

        aberto = e.situacaoEvento();
        if (aberto) {

            JOptionPane.showMessageDialog(null, "Já existe um evento aberto!", "Erro", JOptionPane.ERROR_MESSAGE);

        } else {

            new TelaAbrirEvento().setVisible(true);

        }

    }//GEN-LAST:event_JB_Novo_EventoActionPerformed

    private void JB_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_LogoutActionPerformed

        new Tela_login().setVisible(true); //mostra a tela de login
        u.setLogado(false);
//        u.getUsuarioLogado();
//        u.usuario = "";
        this.dispose();//fecha a tela de administrador

    }//GEN-LAST:event_JB_LogoutActionPerformed

    private void JB_Fechar_EventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Fechar_EventoActionPerformed

        int opt = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja fechar o evento?", "Atenção", JOptionPane.YES_NO_OPTION);
        aberto = e.situacaoEvento();
        if (aberto && opt == 0) {

            fechar_evento();
            JM_Novo.setEnabled(true);
            JM_Editar.setEnabled(true);
            JM_Remover.setEnabled(true);

        } else if (!aberto && opt == 0) {

            JOptionPane.showMessageDialog(null, "Não existe nenhum evento aberto!", "Erro", JOptionPane.ERROR_MESSAGE);

        } else {

        }


    }//GEN-LAST:event_JB_Fechar_EventoActionPerformed

    private void JB_VenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_VenderActionPerformed
        // TODO add your handling code here:
        aberto = e.situacaoEvento();
        if (aberto) {

            new TelaVenderProduto().setVisible(true); //chamar a tela de venda de produto            

        } else {

            JOptionPane.showMessageDialog(null, "Não existe nenhum evento aberto!", "Erro", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_JB_VenderActionPerformed

    private void JMI_NovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_NovoUsuarioActionPerformed

        new TelaAdicionarUsuario().setVisible(true);

    }//GEN-LAST:event_JMI_NovoUsuarioActionPerformed

    private void JMI_NovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_NovoProdutoActionPerformed

        new TelaAdicionarProduto().setVisible(true);

    }//GEN-LAST:event_JMI_NovoProdutoActionPerformed

    private void JB_EstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_EstoqueActionPerformed

        new TelaEstoque().setVisible(true);

    }//GEN-LAST:event_JB_EstoqueActionPerformed

    private void JMI_EditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_EditarProdutoActionPerformed

        new TelaEditarProduto().setVisible(true);

    }//GEN-LAST:event_JMI_EditarProdutoActionPerformed

    private void JMI_RemoverProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_RemoverProdutoActionPerformed

        new TelaRemoverProduto().setVisible(true);

    }//GEN-LAST:event_JMI_RemoverProdutoActionPerformed

    private void JMI_RemoverUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_RemoverUsuarioActionPerformed

        new TelaRemoverUsuario().setVisible(true);

    }//GEN-LAST:event_JMI_RemoverUsuarioActionPerformed

    private void JMI_ContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_ContatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JMI_ContatoActionPerformed

    private void JMI_EditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_EditarUsuarioActionPerformed

        new TelaEditarUsuario().setVisible(true);

    }//GEN-LAST:event_JMI_EditarUsuarioActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        new Tela_login().setVisible(true); //mostra a tela de login
        u.setLogado(false);
//        u.getUsuarioLogado();
//        u.usuario = "";
    }//GEN-LAST:event_formWindowClosing

    private void JB_Vender1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Vender1ActionPerformed
        new Tela_valida_ticket().setVisible(true);
    }//GEN-LAST:event_JB_Vender1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Estoque;
    private javax.swing.JButton JB_Fechar_Evento;
    private javax.swing.JButton JB_Gerar_Relatorio;
    private javax.swing.JButton JB_Logout;
    private javax.swing.JButton JB_Novo_Evento;
    private javax.swing.JButton JB_Produtos;
    private javax.swing.JButton JB_Vender;
    private javax.swing.JButton JB_Vender1;
    private javax.swing.JLabel JL_Gerenciador_Fichas;
    private javax.swing.JMenuItem JMI_Contato;
    private javax.swing.JMenuItem JMI_Desenvolvimento;
    private javax.swing.JMenuItem JMI_EditarProduto;
    private javax.swing.JMenuItem JMI_EditarUsuario;
    private javax.swing.JMenuItem JMI_NovoProduto;
    private javax.swing.JMenuItem JMI_NovoUsuario;
    private javax.swing.JMenuItem JMI_RemoverProduto;
    private javax.swing.JMenuItem JMI_RemoverUsuario;
    private javax.swing.JMenu JM_Editar;
    private javax.swing.JMenu JM_Novo;
    private javax.swing.JMenu JM_Remover;
    private javax.swing.JMenu JM_Sobre;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    Evento e = new Evento();
    Boolean aberto = null;

    private void fechar_evento() {

        CoreSql c = new CoreSql();
        String sql = "UPDATE b_produtos SET liberar_venda = 0 WHERE liberar_venda = 1";
        c.executarQuery(sql, false, null);
        e.fecharEvento();
        JOptionPane.showMessageDialog(null, "Evento Fechado!");

    }
    Usuario u;
}

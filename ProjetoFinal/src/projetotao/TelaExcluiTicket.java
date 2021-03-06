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
public class TelaExcluiTicket extends javax.swing.JFrame {

    /**
     * Creates new form TelaExcluiTicket
     */
    public TelaExcluiTicket() {
        initComponents();
        setLocationRelativeTo(null);
        
        JB_Excluir.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "excluir");
        //Se for a letra "A", coloca uma ação de clique no botão e executa o que está no método actionPerformed
        JB_Excluir.getActionMap().put("excluir", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent a) {
                
                excluir();
                
            }
        });
        
        JB_Cancelar.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancelar");
        //Se for a letra "A", coloca uma ação de clique no botão e executa o que está no método actionPerformed
        JB_Cancelar.getActionMap().put("cancelar", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent a) {
                
                dispose();
                
            }
        });
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTF_Cod_Barras = new javax.swing.JTextField();
        JB_Excluir = new javax.swing.JButton();
        JL_Excluir_Ficha = new javax.swing.JLabel();
        JL_Cod_Barras = new javax.swing.JLabel();
        JB_Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        JB_Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetotao/check.png"))); // NOI18N
        JB_Excluir.setText("Excluir");
        JB_Excluir.setToolTipText("Pressione DEL para EXCLUR");
        JB_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ExcluirActionPerformed(evt);
            }
        });

        JL_Excluir_Ficha.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        JL_Excluir_Ficha.setText("Excluir Ticket");

        JL_Cod_Barras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JL_Cod_Barras.setText("Passe o leitor no códigos de barras ou digite o código manualmente");

        JB_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetotao/delete.png"))); // NOI18N
        JB_Cancelar.setText("Cancelar");
        JB_Cancelar.setToolTipText("Pressione C para CANCELAR");
        JB_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTF_Cod_Barras)
                            .addComponent(JL_Cod_Barras, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(JB_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(JB_Cancelar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(JL_Excluir_Ficha)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(JL_Excluir_Ficha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JL_Cod_Barras)
                .addGap(18, 18, 18)
                .addComponent(JTF_Cod_Barras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ExcluirActionPerformed
       
        excluir();
        
    }//GEN-LAST:event_JB_ExcluirActionPerformed

    private void JB_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_CancelarActionPerformed

        dispose();

    }//GEN-LAST:event_JB_CancelarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaExcluiTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaExcluiTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaExcluiTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaExcluiTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaExcluiTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Cancelar;
    private javax.swing.JButton JB_Excluir;
    private javax.swing.JLabel JL_Cod_Barras;
    private javax.swing.JLabel JL_Excluir_Ficha;
    private javax.swing.JTextField JTF_Cod_Barras;
    // End of variables declaration//GEN-END:variables

public void excluir(){
    
     Ticket t = new Ticket();
     
        try {           
            
            t.setTicket(Integer.parseInt(JTF_Cod_Barras.getText()));
            t.getTicket();
            t.excluir();
            JOptionPane.showMessageDialog(null,"O Ticket foi excluído com sucesso! ","Atenção", JOptionPane.INFORMATION_MESSAGE);
            JTF_Cod_Barras.setText("");
            JTF_Cod_Barras.requestFocus();
            
        } catch (ProjetoException ert){
            
            JOptionPane.showMessageDialog(null,ert.getMessage(),"Atenção", JOptionPane.ERROR_MESSAGE);
            JTF_Cod_Barras.setText("");
            JTF_Cod_Barras.requestFocus();
        
        }
    
}

}

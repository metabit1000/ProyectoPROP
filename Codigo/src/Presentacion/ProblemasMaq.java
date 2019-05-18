/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.CtrlProblemas;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author jota
 */
public class ProblemasMaq extends javax.swing.JFrame {
    
    private Boolean difBlanco;  //true -> FACIL, false -> DIFICIL
    private Boolean difNegro;  //true -> FACIL, false -> DIFICIL
    private CtrlPresentacionUsuarios u = new CtrlPresentacionUsuarios();
    public ProblemasMaq(CtrlPresentacionUsuarios u) {
        this.u = u;
        DefaultListModel<String> listModel = new DefaultListModel<>();
        CtrlProblemas cp = new CtrlProblemas();
        for (int i = 0; i < cp.getAllProblemasJuego().size(); ++i) {
            listModel.addElement("Problema "+cp.getAllProblemasJuego().get(i).getId()+". Movimientos: "+cp.getAllProblemasJuego().get(i).getNumMovimientos());
        }
        
        this.setVisible(true); 
        this.setTitle("Problemas");  
        initComponents();
        JLista.setModel(listModel);
        JLista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        setResizable(false);
        
        DificultadNegro.add(FacilNegro);
        DificultadNegro.add(DificilNegro);
        DificultadBlanco.add(FacilBlanco);
        DificultadBlanco.add(DificilBlanco);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DificultadNegro = new javax.swing.ButtonGroup();
        DificultadBlanco = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JLista = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Competicion = new javax.swing.JButton();
        FacilNegro = new javax.swing.JRadioButton();
        FacilBlanco = new javax.swing.JRadioButton();
        DificilBlanco = new javax.swing.JRadioButton();
        DificilNegro = new javax.swing.JRadioButton();
        Ranking = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PROBLEMAS MAQUINAS");

        JLista.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(JLista);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/WHITE.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/BLACK.png"))); // NOI18N

        Competicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/CROSSEDSWORDS.png"))); // NOI18N
        Competicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompeticionActionPerformed(evt);
            }
        });

        FacilNegro.setText("Facil");
        FacilNegro.setActionCommand("FacilNegro");
        FacilNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacilNegroActionPerformed(evt);
            }
        });

        FacilBlanco.setText("Facil");
        FacilBlanco.setActionCommand("FacilBlanco");
        FacilBlanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacilBlancoActionPerformed(evt);
            }
        });

        DificilBlanco.setText("Dificil");
        DificilBlanco.setActionCommand("DificilBlanco");
        DificilBlanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DificilBlancoActionPerformed(evt);
            }
        });

        DificilNegro.setText("Dificil");
        DificilNegro.setActionCommand("DificilNegro");
        DificilNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DificilNegroActionPerformed(evt);
            }
        });

        Ranking.setText("Ranking");
        Ranking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RankingActionPerformed(evt);
            }
        });

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DificilBlanco)
                            .addComponent(FacilBlanco))
                        .addGap(65, 65, 65)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
                .addComponent(Competicion)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DificilNegro)
                            .addComponent(FacilNegro))
                        .addGap(95, 95, 95))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(Ranking)
                .addGap(73, 73, 73))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(Cancel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(FacilBlanco)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DificilBlanco))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(FacilNegro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DificilNegro))))
                            .addComponent(Competicion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cancel)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(Ranking)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void FacilNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacilNegroActionPerformed
        difNegro = true;
    }//GEN-LAST:event_FacilNegroActionPerformed

    private void FacilBlancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacilBlancoActionPerformed
        difBlanco = true;
    }//GEN-LAST:event_FacilBlancoActionPerformed

    private void DificilBlancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DificilBlancoActionPerformed
        difBlanco = false;
    }//GEN-LAST:event_DificilBlancoActionPerformed

    private void DificilNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DificilNegroActionPerformed
        difNegro = false;
    }//GEN-LAST:event_DificilNegroActionPerformed

    private void RankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RankingActionPerformed
        if (selectProblems().length == 1) { 
            Ranking r = new Ranking(u, selectProblem()+1, "PM");
            setVisible(false);
            r.setVisible(true);
        }
    }//GEN-LAST:event_RankingActionPerformed

    private void CompeticionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompeticionActionPerformed
        if (difBlanco != null && difNegro != null && selectProblems().length > 0) {
            //nueva vista como parametros selectProblems(), difBlanco y difNegro
        }
    }//GEN-LAST:event_CompeticionActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        Menu m = new Menu(u);
        setVisible(false);
        m.setVisible(true);
    }//GEN-LAST:event_CancelActionPerformed
    public int selectProblem() {
        return JLista.getSelectedIndex();
    }
    public int[] selectProblems() {
        return JLista.getSelectedIndices();
    }
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
            java.util.logging.Logger.getLogger(ProblemasMaq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProblemasMaq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProblemasMaq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProblemasMaq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ProblemasMaq().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Competicion;
    private javax.swing.JRadioButton DificilBlanco;
    private javax.swing.JRadioButton DificilNegro;
    private javax.swing.ButtonGroup DificultadBlanco;
    private javax.swing.ButtonGroup DificultadNegro;
    private javax.swing.JRadioButton FacilBlanco;
    private javax.swing.JRadioButton FacilNegro;
    private javax.swing.JList JLista;
    private javax.swing.JButton Ranking;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

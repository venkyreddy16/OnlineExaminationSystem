
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vandana Rangaswamy
 */

public class admindashboard extends javax.swing.JFrame {
   public static int open = 0; 

    /**
     * Creates new form admindashboard
     */
    public admindashboard() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Vandana Rangaswamy\\Desktop\\qems\\index background.png")); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Vandana Rangaswamy\\Desktop\\qems\\add new question.png")); // NOI18N
        jMenu1.setText("ADD  A NEW QUESTION");
        jMenu1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Vandana Rangaswamy\\Desktop\\qems\\Update Question.png")); // NOI18N
        jMenu2.setText("UPDATE QUESTION");
        jMenu2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Vandana Rangaswamy\\Desktop\\qems\\delete Question.png")); // NOI18N
        jMenu4.setText("DELETE QUESTIONS");
        jMenu4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Vandana Rangaswamy\\Desktop\\qems\\books.png")); // NOI18N
        jMenu5.setText("UPDATE STUDY MATERIALS");
        jMenu5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        jMenu7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Vandana Rangaswamy\\Desktop\\qems\\all student result.png")); // NOI18N
        jMenu7.setText("RESULTS");
        jMenu7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu7);

        jMenu6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Vandana Rangaswamy\\Desktop\\qems\\Logout.png")); // NOI18N
        jMenu6.setText("LOGOUT");
        jMenu6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        // TODO add your handling code here:
        index l = new index();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
//         
//        if(open == 0)
//        {
//            new addquiz().setVisible(true);
//            
//            open=1;
//        }
//        else{
//            JFrame jf = new JFrame();
//            jf.setAlwaysOnTop(true);
//            JOptionPane.showMessageDialog(jf,"One form is already opened");
//           
//        }
 new addquiz().setVisible(true);
 this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        
//         if(open == 0)
//        {
//            new updatequestion().setVisible(true);
//             this.dispose();
//            open=1;
//        }
//        else{
//            JFrame jf = new JFrame();
//            jf.setAlwaysOnTop(true);
//            JOptionPane.showMessageDialog(jf,"One form is already opened");
//             
//        }
                 new updatequestion().setVisible(true); 
                 this.dispose();
                 
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
//        if(open == 0)
//        {
//            new deletequestion().setVisible(true);
//            open=1;
//        }
//        else{
//            JFrame jf = new JFrame();
//            jf.setAlwaysOnTop(true);
//            JOptionPane.showMessageDialog(jf,"One form is already opened");
//           
//        }
new deletequestion().setVisible(true);
this.dispose();
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
//        if(open == 0)
//        {
//            new updatestudy().setVisible(true);
//            open=1;
//        }
//        else{
//            JFrame jf = new JFrame();
//            jf.setAlwaysOnTop(true);
//            JOptionPane.showMessageDialog(jf,"One form is already opened");
//           
//        }

//        
new updatestudy().setVisible(true);
this.dispose();
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        // TODO add your handling code here:
        if(open == 0)
        {
            new results().setVisible(true);
            this.dispose();
            open=1;
        }
        else{
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"One form is already opened");
           
        }
        
    }//GEN-LAST:event_jMenu7MouseClicked

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
            java.util.logging.Logger.getLogger(admindashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admindashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admindashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admindashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admindashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}

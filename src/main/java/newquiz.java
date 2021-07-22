
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class newquiz extends javax.swing.JFrame {

    /**
     * Creates new form newquiz
     */
    //private String answer;
 
    public newquiz() {
        //String mark = txtmarks.getText();
        initComponents();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dt = new Date();
        txtdate.setText(dFormat.format(dt));
        Connect();

        
                
        LoadQuestions();
                 try {
           PreparedStatement ps;
              String query = "SELECT count(qno) FROM `question`";
            ps = MyConnection.getConnection().prepareStatement(query);
//            ps.setString(1,stemail);
//            ps.setString(2,stpwd);
           ResultSet rs = ps.executeQuery();
           
        } catch (Exception ex) {
            //Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, ex);
        }
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    //String CorrectAnswer=null;
     public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/onlineexam","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addquiz.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(SQLException ex){
            Logger.getLogger(addquiz.class.getName()).log(Level.SEVERE, null, ex);
        }
}
     
     public void LoadQuestions()
     {
         String query = "select *from question";
         Statement stat= null;
         
        try {
            stat = con.createStatement();
            rs = stat.executeQuery(query);
            while(rs.next()){
                txtqno.setText(rs.getString(1));
                txtq.setText(rs.getString(2));
                op1.setText(rs.getString(3));
                op2.setText(rs.getString(4));
                op3.setText(rs.getString(5));
                op4.setText(rs.getString(6));
                cor = rs.getString(7);
               
                break;
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(newquiz.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     int answercheck = 0;
     int marks = 0;
     String cor = null;
     String answer1 = null;
     
     
     public boolean answerCheck(){
         String answerAnswer = "";
         if(op1.isSelected()){
             answerAnswer= op1.getText();
            
             
         }
         else  if(op2.isSelected()){
             answerAnswer= op2.getText();
             
         }
         else  if(op3.isSelected()){
             answerAnswer= op3.getText();
             
         }
         else if (op4.isSelected()){
             answerAnswer= op4.getText();
           
         }
         if(answerAnswer.equals(cor) && (answer1 == null || !answer1.equals(cor)))
         {
             marks = marks + 1;
             
             txtmarks.setText(String.valueOf(marks));
         }
         else
             marks = marks;
//         else if(!answerAnswer.equals(cor) && answer1 != null)
//         {
//             if(marks>0){
//                 marks = marks - 1;
//             }
//             txtmarks.setText(String.valueOf(marks));
       //  }
         if(!answerAnswer.equals("")){
             try{
                 String query = "update question set givenans=? where q=?";
                 pst= con.prepareStatement(query);
                 pst.setString(1,answerAnswer);
                 pst.setString(2,txtq.getText());
                 pst.execute();
             }catch(SQLException ex){
                 ex.printStackTrace();
                 
             }
             return true;
         }
         return false;
     }
     private void NullAllGivenAnswers(){
         try{
             String query = "update question set givenans=?";
              //String answerAnswer = "";
             pst= con.prepareStatement(query);
             pst.setString(1,null);
             pst.execute();
             
         }
         catch (SQLException ex){
                 ex.printStackTrace();
 
         }
     }
     
     private boolean AlreadyAnswered(){
       op1.setSelected(false);
       op2.setSelected(false);
       op3.setSelected(false);
       op4.setSelected(false);
       
         try{
             String query = "select givenans from question where q= '"+txtq.getText()+"'";
             // String answerAnswer = "";
            Statement stat = con.prepareStatement(query);
            ResultSet res = stat.executeQuery(query);
            while(res.next()){
                answer1 = res.getString("givenans");
                if(answer1==null){
                    return false;
                }
                break;
            }
             if(op1.getText().equals(answer1)){
                 op1.setSelected(true);
 buttonGroup1.clearSelection();
             }
             else if(op2.getText().equals(answer1)){
                 op2.setSelected(true); 
                 buttonGroup1.clearSelection();
                
             }
             else if(op3.getText().equals(answer1)){
                 op3.setSelected(true);  
                 buttonGroup1.clearSelection();
                 
             }
             else if(op4.getText().equals(answer1)){
                 op4.setSelected(true);
                buttonGroup1.clearSelection();
             }
             
         }catch(SQLException e){
             
             e.printStackTrace();
         }
         return true;
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        qno = new javax.swing.JLabel();
        q = new javax.swing.JLabel();
        txtqno = new javax.swing.JLabel();
        txtq = new javax.swing.JLabel();
        op1 = new javax.swing.JRadioButton();
        op2 = new javax.swing.JRadioButton();
        op3 = new javax.swing.JRadioButton();
        op4 = new javax.swing.JRadioButton();
        next = new javax.swing.JButton();
        txtmarks = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtdate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtusn = new javax.swing.JTextField();
        txtcoursecode = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        qno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        qno.setText("QUESTION NUMBER:");

        q.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        q.setText("QUESTION:");

        txtqno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtqno.setText("QNO");

        txtq.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtq.setText("Q");

        buttonGroup1.add(op1);
        op1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        op1.setText("jRadioButton1");

        buttonGroup1.add(op2);
        op2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        op2.setText("jRadioButton2");

        buttonGroup1.add(op3);
        op3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        op3.setText("jRadioButton3");

        buttonGroup1.add(op4);
        op4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        op4.setText("jRadioButton4");

        next.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        next.setIcon(new javax.swing.ImageIcon("C:\\Users\\Vandana Rangaswamy\\Desktop\\qems\\Next.png")); // NOI18N
        next.setText("SUBMIT");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        txtmarks.setText("0");
        txtmarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmarksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(196, 196, 196)
                .addComponent(txtmarks, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(qno)
                    .addComponent(q, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(op4)
                            .addComponent(op3)
                            .addComponent(op2)
                            .addComponent(op1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(216, 216, 216))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtqno, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtq, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(qno)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtqno, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q)
                    .addComponent(txtq, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(op1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(op2)
                .addGap(18, 18, 18)
                .addComponent(op3)
                .addGap(18, 18, 18)
                .addComponent(op4)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(next)
                    .addComponent(txtmarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Vandana Rangaswamy\\Desktop\\qems\\quiz.png")); // NOI18N

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 50)); // NOI18N
        jLabel1.setText("quiz");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("DATE:");

        txtdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 361, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(0, 25, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("ENTER USN:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("ENTER COURSE CODE:");

        txtusn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtcoursecode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcoursecode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcoursecodeActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtusn)
                            .addComponent(txtcoursecode, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtusn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtcoursecode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        if(answerCheck()){
            
        
            try{
                if(rs.next())
                {
                    txtqno.setText(rs.getString("qno"));
                    txtq.setText(rs.getString("q"));
                    op1.setText(rs.getString(3));
                    op2.setText(rs.getString(4));
                    op3.setText(rs.getString(5));
                    op4.setText(rs.getString(6));
                    cor = rs.getString(7);
                    if(!AlreadyAnswered()){
                        buttonGroup1.clearSelection();
                    }  
                }
                else{
                    JOptionPane.showMessageDialog(this,"Enter usn and course code");
                   // new blank1().setVisible(true);
                    //this.dispose();
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_nextActionPerformed

    private void txtmarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmarksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmarksActionPerformed

    private void txtcoursecodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcoursecodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcoursecodeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         String usn1 = txtusn.getText();
       String code1 = txtcoursecode.getText();
        String mark = txtmarks.getText();
        
        //String marks= null;
            PreparedStatement ps;
            PreparedStatement ps1;
            if(usn1.equals("")){
                JOptionPane.showMessageDialog(null,"Enter usn");
            }
                      else if(code1.equals("")){
                JOptionPane.showMessageDialog(null,"Enter coursecode");
            }

            String query= "insert into results(usn,marks,coursecode) values(?,?,?)";
           
        try {

 ps= MyConnection.getConnection().prepareStatement(query);
            ps.setString(1,usn1);
            ps.setString(3,code1);
         //String txtmarks;
        // txtmarks=null;
            ps.setString(2,mark);
             
             if(ps.executeUpdate()>0){
                 JOptionPane.showMessageDialog(null,"Thank you for taking up the quiz");
                 new blank1().setVisible(true);
                  //this.dispose();
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(StudentRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(newquiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newquiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newquiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newquiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newquiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton next;
    private javax.swing.JRadioButton op1;
    private javax.swing.JRadioButton op2;
    private javax.swing.JRadioButton op3;
    private javax.swing.JRadioButton op4;
    private javax.swing.JLabel q;
    private javax.swing.JLabel qno;
    private javax.swing.JTextField txtcoursecode;
    private javax.swing.JLabel txtdate;
    private javax.swing.JTextField txtmarks;
    private javax.swing.JLabel txtq;
    private javax.swing.JLabel txtqno;
    private javax.swing.JTextField txtusn;
    // End of variables declaration//GEN-END:variables
}

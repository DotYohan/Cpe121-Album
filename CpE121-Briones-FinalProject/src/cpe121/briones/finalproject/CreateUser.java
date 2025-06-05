/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cpe121.briones.finalproject;

import cpe121.briones.finalproject.BankForm;
import cpe121.briones.finalproject.DB_connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateUser extends javax.swing.JFrame {

    Security encrypt = new Security();
    LocalDateTime now = LocalDateTime.now();
    String formatted = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    int counts = 0;

    public CreateUser() {
        initComponents();
    }

    private void Savedata(String AccountUsername, String AccountPassword, String AccountNumb, String AccountName, String AccountDeposits) {
        DB_connection.init();
        try {
            Connection c = DB_connection.getConnection();

            // 🔍 Step 1: Check if username already exists
            PreparedStatement checkUser = c.prepareStatement("SELECT * FROM accounts WHERE Username = ?");
            checkUser.setString(1, AccountUsername);
            ResultSet rs = checkUser.executeQuery();

            if (rs.next()) {
                counts = 1;
                JOptionPane.showMessageDialog(null, "Username already exists! Please choose another one.");
                return;
            }

            PreparedStatement checkAccount = c.prepareStatement("SELECT * FROM accounts WHERE accountnumber = ?");
            checkAccount.setString(1, AccountNumb);
            ResultSet rs2 = checkAccount.executeQuery();

            if (rs2.next()) {
                counts = 1;
                System.out.println("counts: "+counts);
                JOptionPane.showMessageDialog(null, "Account number already exists! Use a different one.");
                return;
            }

            // ✅ Step 3: Insert into accounts table
            PreparedStatement insertAccount = c.prepareStatement(
                    "INSERT INTO accounts (Username, Password, accountnumber, Name, Balance) VALUES (?, ?, ?, ?, ?)"
            );
            insertAccount.setString(1, AccountUsername);
            insertAccount.setString(2, AccountPassword);
            insertAccount.setString(3, AccountNumb);
            insertAccount.setString(4, AccountName);
            insertAccount.setString(5, AccountDeposits);
            insertAccount.executeUpdate();

            JOptionPane.showMessageDialog(null, "Account Successfully Created");

            // ✅ Step 4: Create per-user transaction table (if not exists)
            String userTable = "user_" + AccountNumb;
            PreparedStatement createTable = c.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS `" + userTable + "` ("
                    + "id INT NOT NULL AUTO_INCREMENT, "
                    + "Dates VARCHAR(125), "
                    + "accountnumber VARCHAR(125), "
                    + "accountname VARCHAR(125), "
                    + "accountbalance VARCHAR(125), "
                    + "accountcredit VARCHAR(125), "
                    + "accountloan VARCHAR(125), "
                    + "remarks VARCHAR(125), "
                    + "PRIMARY KEY (id))"
            );
            createTable.executeUpdate();

            PreparedStatement insertTransaction = c.prepareStatement(
                    "INSERT INTO `" + userTable + "` (Dates, accountnumber, accountname, accountbalance, accountcredit, accountloan) VALUES (?, ?, ?, ?, ?, ?)"
            );
            insertTransaction.setString(1, formatted);
            insertTransaction.setString(2, AccountNumb);
            insertTransaction.setString(3, AccountName);
            insertTransaction.setString(4, AccountDeposits);
            insertTransaction.setString(5, "0");
            insertTransaction.setString(6, "0");
            insertTransaction.executeUpdate();

            JOptionPane.showMessageDialog(null, "Initial transaction saved.");
            counts = 0;
        } catch (SQLException ex) {
            ex.printStackTrace(); // for debugging
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
        }
    }

    private void AccountData(String AccountNumb, String AccountName, String AccountDeposits, String accountcredit, String accountloan) {
        DB_connection.init();
        try {

            Connection c = DB_connection.getConnection();
            PreparedStatement ps = c.prepareStatement("Insert into accountinfo (Dateses,accountnumber,accountname,  accountbalance , accountcredit, accountloan) values('" + formatted + "','" + AccountNumb + "','" + AccountName + "','" + AccountDeposits + "','" + accountcredit + "','" + accountloan + "')");
            System.out.println(ps);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data Successfully Saved");
        } catch (SQLException ex) {
            ex.printStackTrace(); // for debugging
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
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

        AccountNo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Accname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        AccountPass = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        AccDeposit = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        AccUser = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(340, 490));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(AccountNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 230, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Create Account");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 260, -1));

        jLabel2.setText("Mobile Number (Account Number)");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel3.setText("Account Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));
        getContentPane().add(Accname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 230, -1));

        jLabel4.setText("Account Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        AccountPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountPassActionPerformed(evt);
            }
        });
        getContentPane().add(AccountPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 230, -1));

        jLabel5.setText("Deposit");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));
        getContentPane().add(AccDeposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 230, -1));

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        jLabel6.setText("Username");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));
        getContentPane().add(AccUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 230, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AccountPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AccountPassActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String AccountNumb = AccountNo.getText();
        String AccountName = Accname.getText();
        String AccountPassword = AccountPass.getText();
        String AccountDeposits = AccDeposit.getText();
        String AccountUsername = AccUser.getText();
        String hashed = encrypt.hash(AccountPassword);
        if (AccountNumb.equals("") || AccountName.equals("") || AccountPassword.equals("") || AccountDeposits.equals("") || AccountUsername.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill the form completely!");
        } else {
            Savedata(AccountUsername, hashed, AccountNumb, AccountName, AccountDeposits);
            if (counts == 0) {
                AccountData(AccountNumb, AccountName, AccountDeposits, "0", "0");
                LogIn open = new LogIn();
                open.setVisible(true);
                this.dispose();
            } else {

            }
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
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccDeposit;
    private javax.swing.JTextField AccUser;
    private javax.swing.JTextField Accname;
    private javax.swing.JTextField AccountNo;
    private javax.swing.JTextField AccountPass;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}

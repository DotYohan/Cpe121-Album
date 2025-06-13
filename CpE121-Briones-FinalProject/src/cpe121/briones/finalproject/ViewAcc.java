/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cpe121.briones.finalproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yuanb
 */
public class ViewAcc extends javax.swing.JFrame {

    DefaultTableModel model;
    Security enc = new Security();

    public ViewAcc() {
        initComponents();
        model = (DefaultTableModel) AccountsTable.getModel();
        model.setRowCount(0);
        LoadTable();
    }

    void LoadTable() {

        model.setRowCount(0);
        DB_connection.init();
        Connection c = DB_connection.getConnection();

        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM accounts");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                model.addRow(new Object[]{rs.getString("accountnumber"), rs.getString("Username"), rs.getString("Name"), rs.getString("Balance")});

            }

        } catch (SQLException ex) {
            Logger.getLogger(ViewAcc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void UpdateAccount(String username, String Name, String Balance, String accountnumber) {
        DB_connection.init();
        Connection c = DB_connection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE accounts set Username = ?, Name = ?,  Balance = ? WHERE accountnumber = ?;");
            ps.setString(1, username);
            ps.setString(2, Name);
            ps.setString(3, Balance);
            ps.setString(4, accountnumber);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                ps = c.prepareStatement("UPDATE accountinfo set Username = ?, Name = ?,  Balance = ? WHERE accountnumber = ?;");
                ps.setString(1, username);
                ps.setString(2, Name);
                ps.setString(3, Balance);
                ps.setString(4, accountnumber);
                JOptionPane.showMessageDialog(null, "Record updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "No record found.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ViewAcc.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }

    }

    void Search(String find, String where) {
        DB_connection.init();
        Connection c = DB_connection.getConnection();
        model.setRowCount(0);
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM accounts Where " + where + " LIKE '%" + find + "%'");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("accountnumber"), rs.getString("Username"), rs.getString("Name"), rs.getString("Balance")});

            }

        } catch (SQLException ex) {
            Logger.getLogger(ViewAcc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void DeleteAccount(String accountnumber) {
        DB_connection.init();
        Connection c = DB_connection.getConnection();
        String user = "user_" + accountnumber;
        try {
            PreparedStatement ps = c.prepareStatement("DELETE FROM accounts WHERE accountnumber = ?");
            ps.setString(1, accountnumber);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                ps = c.prepareStatement("DROP TABLE " + user);
                rowsDeleted = ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record deleted successfully!");

            } else {
                JOptionPane.showMessageDialog(null, "No record found.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ViewAcc.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
    }

    void UpdatePassword(String Password, String AccountNumber) {
        DB_connection.init();
        Connection c = DB_connection.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE accounts set Password = ? WHERE accountnumber = ?;");
            ps.setString(1, Password);
            ps.setString(2, AccountNumber);
            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Record updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "No record found.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Changepass.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: " + ex);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AccountsTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        Account = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Balance = new javax.swing.JTextField();
        Select = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Password = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        VerifyPass = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 577));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Accounts");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        AccountsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Account Number", "Username", "Name", "Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AccountsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AccountsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(AccountsTable);
        if (AccountsTable.getColumnModel().getColumnCount() > 0) {
            AccountsTable.getColumnModel().getColumn(0).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 670, -1));

        jLabel2.setText("Account Number");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, -1, -1));
        getContentPane().add(Account, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 230, -1));

        jLabel3.setText("Username");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 150, -1, -1));
        getContentPane().add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 230, -1));

        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, -1, -1));
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, 230, -1));

        jLabel5.setText("Balance");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, -1, -1));
        getContentPane().add(Balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 290, 230, -1));

        Select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search", "Update", "Delete" }));
        getContentPane().add(Select, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 340, -1, -1));

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 340, -1, -1));

        jButton2.setText("Home");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        jLabel6.setText("New Password");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 390, -1, -1));
        getContentPane().add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 410, 230, -1));

        jLabel7.setText("Confirm New Password");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 440, -1, -1));
        getContentPane().add(VerifyPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 460, 230, -1));

        jButton3.setText("Change User Password");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 490, -1, -1));

        jButton4.setText("Reload");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AccountsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountsTableMouseClicked
        try {
            if (evt.getClickCount() == 2) {
                int selected = AccountsTable.getSelectedRow();
                if (selected != -1) {
                    String GetUser = AccountsTable.getValueAt(selected, 1).toString();
                    String GetName = String.valueOf(AccountsTable.getValueAt(selected, 2));
                    String GetBalance = String.valueOf(AccountsTable.getValueAt(selected, 3));
                    String GetAccount = String.valueOf(AccountsTable.getValueAt(selected, 0));

                    Username.setText(GetUser);
                    Name.setText(GetName);
                    Balance.setText(GetBalance);
                    Account.setText(GetAccount);

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading selected book: " + e.getMessage());
        }
    }//GEN-LAST:event_AccountsTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String selecteditem = Select.getSelectedItem().toString();
        String user = Username.getText();
        String name = Name.getText();
        String balance = Balance.getText();
        String account = Account.getText();
        String where;
        if (selecteditem.equals("Search")) {
            if (name.isEmpty() && balance.isEmpty() && account.isEmpty()) {
                where = "Username";
                Search(user, where);

            } else if (user.isEmpty() && balance.isEmpty() && account.isEmpty()) {
                where = "Name";
                Search(name, where);
            } else if (user.isEmpty() && name.isEmpty() && account.isEmpty()) {
                where = "Balance";
                Search(balance, where);
            } else if (user.isEmpty() && name.isEmpty() && balance.isEmpty()) {
                where = "accountnumber";
                Search(account, where);
            } else {
                JOptionPane.showMessageDialog(null, "No record Found");
            }
        } else if (user.isEmpty() || name.isEmpty() || balance.isEmpty()
                || (selecteditem.equals("Update") && account.isEmpty())) {
            JOptionPane.showMessageDialog(null, "Please fill out all required fields.");
            return;
        } else {
            BankForm open = new BankForm();
            try {

                switch (selecteditem) {

                    case "Update":
                        UpdateAccount(user, name, balance, account);
                        break;
                    case "Delete":
                        int confirm = JOptionPane.showConfirmDialog(null,
                                "Are you sure you want to delete this account?",
                                "Confirm Delete", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            DeleteAccount(account);
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid operation selected.");
                }

                LoadTable(); // Refresh the table after any operation

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter valid account number.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        BankForm open = new BankForm();
        open.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String account = Account.getText().trim();
        String NewPassword = Password.getText();
        String VerifyPassword = VerifyPass.getText();
        String Hashed = enc.hash(NewPassword);
        if (NewPassword.isEmpty() || VerifyPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No password found!");
        } else {
            if (NewPassword.equals(VerifyPassword)) {
                UpdatePassword(Hashed, account);
            } else {
                JOptionPane.showMessageDialog(null, "New Password did not match!");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        LoadTable();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAcc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Account;
    private javax.swing.JTable AccountsTable;
    private javax.swing.JTextField Balance;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Password;
    private javax.swing.JComboBox<String> Select;
    private javax.swing.JTextField Username;
    private javax.swing.JTextField VerifyPass;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cpe121.activity4;

/**
 *
 * @author yuanb
 */
public class CpE121Activity4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("A101", 1000.0);
        BankAccount account2 = new BankAccount("B202", 500.0);
        
        System.out.println("Before Transfer:");
        account1.displayAccountInfo();
        account2.displayAccountInfo();

        Bank bank = new Bank();

        bank.transferMoney(account1, account2, 300.0);

        System.out.println("\nAfter Transfer:");
        account1.displayAccountInfo();
        account2.displayAccountInfo();
    }
    
}

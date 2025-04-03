/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpe121.activity4;

/**
 *
 * @author yuanb
 */
public class Bank {

    public void transferMoney(BankAccount from, BankAccount to, double amount) {
        if (from.withdraw(amount)) {  // Withdraw only if sufficient balance
            to.deposit(amount);
            System.out.println("Transfer Successful: $" + amount + " from " + from.accountId() + " to " + to.accountId());
        } else {
            System.out.println("Transfer Failed: Insufficient funds.");
        }

    }
}

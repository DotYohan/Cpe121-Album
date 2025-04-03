/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpe121.activity4;

/**
 *
 * @author yuanb
 */
public class BankAccount {

    private String accountNumber;
    private double Balance;

     public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.Balance = balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber
                + "\nBalance: " + Balance);
    }

    public void deposit(double cash) {
       if (cash > 0) {
            Balance += cash;
            System.out.println("Deposited: $" + cash + " into " + accountNumber);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

   public boolean withdraw(double amount) {
        if (amount > 0 && Balance >= amount) {
            Balance -= amount;
            System.out.println("Withdrawn: $" + amount + " from " + accountNumber);
            return true;
        } else {
            System.out.println("Insufficient funds or invalid amount.");
            return false;
        }
    }
    public String accountId (){
        return accountNumber;
    }
    public double bal (){
        return Balance;
    }

}

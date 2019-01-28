package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     * only reduces the amount in the account won't be overdrafted and the amount isn't negative
     */
    public void withdraw (double amount)  {
        balance -= amount;

    }
    /**
     * @return if the '@' symbol isn't present it isn't a valid email address, else returns false
     * if the character before the '@' symbol isn't alphanumeric it isn't valid, else returns false
     * the first item in the email address must be alphanumeric, else returns false
     * the end of the address must be a domain, else returns false
     */

    public static boolean isEmailValid(String email){

        if (email.indexOf('@') == -1){
            return false;
        }
        if (email.isEmpty()==true){
            return false;
        }
        else if (email.startsWith("-")||email.startsWith("#")||email.startsWith("$")){
            return false;
        }
         else if (email.contains("#")){
            return false;
        }
         else if (email.endsWith(".com")==false && email.endsWith(".net")==false && email.endsWith(".org")==false){
             return false;
        }
//        else if (front == '-' || front == '#' || front == '_'){
//            return false;
//        }
        else {
            int frontChar = email.indexOf('@')-1;
            char front = email.charAt(frontChar);
            if(front == '-' || front == '#' || front == '_'){
                return false;
            }
            else{
                return true;
            }
        }
    }
}

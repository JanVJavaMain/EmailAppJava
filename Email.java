//package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName, lastName;
    private String password;
    private String department; 
    private String alternateEmail;
    private String companySuff = "company.com";
    private String email;
    private int defPswdLength = 12;
    private int mailboxCapacity = 500;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = setDepartment();

        this.password = randomPassword(12);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuff.toLowerCase();
    }

    private String setDepartment() {
        System.out.print("Department codes: \n1 for sales\n2 for development\n3 for accounting\n0 for other\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if (departmentChoice == 1) { return "sales"; }
        else if (departmentChoice == 2) { return "dev"; }
        else if (departmentChoice == 3) { return "acct"; }
        else { return ""; }
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        char[] pswd = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            pswd[i] = passwordSet.charAt(rand); 
        }
        return new String(password);
    }

    public void setMailboxCap(int capacity) {
        this.mailboxCapacity = capacity; 
    }

    public void setAlternateMail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity;}
    public String getAlternateEmail() { return alternateEmail;}
    public String getPassword() { return password;}

    public String showInfo() {
        return "Display name: " + firstName + " " + lastName + "\nCompany email: " + email +  "\nMailbox capacity: " + mailboxCapacity + "mb"; 
    }
}
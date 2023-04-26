package edu.guilford;

import java.util.Random;
import java.util.Scanner;

public class User {

    // Attributes for the user - for logins or creation of account
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    // private String password;
    private String phoneNum;
    
    // Attributes for the passwordGenerator
    private String favColor;
    private String firstPetName;
    private String luckyNum;
    private String nickName;
    private String firstCarMake;


    // Constructor for the user
    public User(String firstName, String lastName, String email, 
        String username, String phoneNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        // this.password = password;
        this.phoneNum = phoneNum;
    }

    //Getters and Setters for each attribute
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // public String getPassword() {
    //     return password;
    // }

    // public void setPassword(String password) {
    //     this.password = password;
    // }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    //Build a method that generates a random password for the user named generatePassword
    public String generatePassword() {
        //Create a scanner object to scan the user input
        Scanner scan = new Scanner(System.in);
        //Have the user enter the security questions
        System.out.println("What is your favorite color?");
        //Scan the user's input and store it in the appropriate variable
        favColor = scan.nextLine();
        System.out.println("What is the name of your first pet?");
        firstPetName = scan.nextLine();
        System.out.println("What is your lucky number?");
        luckyNum = scan.nextLine();
        System.out.println("What is your nickname?");
        nickName = scan.nextLine();
        System.out.println("What is the make of your first car?");
        firstCarMake = scan.nextLine();

        //Create a string object that holds all the answers of the security questions
        String securityAnswers = favColor + firstPetName + luckyNum + nickName + firstCarMake;
        //Create a random object
        Random random = new Random();
        //Have the random object select random characters from the securityAnswers string and store them in a new string
        String password = random.ints(8, 0, securityAnswers.length())
            .mapToObj(i -> securityAnswers.charAt(i))
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
            .toString();
        //Create a string of characters that will be used inside the password string
        String passwordChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        //Have the random object select random characters from the passwordChars string and store them in a new string
        String password2 = random.ints(8, 0, passwordChars.length())
            .mapToObj(i -> passwordChars.charAt(i))
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
            .toString();
        //Create a for loop that shuffles the characters in both the password and password2 strings and creates a new string with the shuffled characters
        for (int i = 0; i < 8; i++) {
            //Generate a random number between 0 and the length of the password string
            int index = random.nextInt(password.length());
            //Add the character at the index of the random number to the password string
            password += password.charAt(index);
            //Remove the character at the index of the random number from the password string
            password = password.substring(0, index) + password.substring(index + 1);
            //Generate a random number between 0 and the length of the password2 string
            int index2 = random.nextInt(password2.length());
            //Add the character at the index of the random number to the password2 string
            password2 += password2.charAt(index2);
            //Remove the character at the index of the random number from the password2 string
            password2 = password2.substring(0, index2) + password2.substring(index2 + 1);
        }
        String finalPassword = password + password2;

        //Print the new password
        // System.out.println("Your new password is: " + finalPassword);

        // Return the password strings
        return finalPassword;
    }

    //Build a method that will check if the username is already in use
    public boolean checkUsername() {
        //Create a boolean variable that will be returned
        boolean usernameCheck = false;
        //Check if the username is already in use
        if (username.equals("username")) {
            //If it is, set usernameCheck to true
            usernameCheck = true;
        }
        // Return usernameCheck
        return usernameCheck;
    }

    //Build a tostring method that will print out the user's input
    @Override
    public String toString() {
        return "User [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + 
        ", phoneNum=" + phoneNum + ", username=" + username + "]";
    }

}

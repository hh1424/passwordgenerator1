package edu.guilford;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Driver 
{

    public static void main( String[] args )
    {
        //Instantiate a scanner to read the users input
        Scanner scan = new Scanner(System.in);

        //Ask the user their information for the attributes
        System.out.println("What is your first name? ");
        String firstName = scan.nextLine();
        System.out.println("What is your last name? ");
        String lastName = scan.nextLine();
        System.out.println("What is your email? ");
        String email = scan.nextLine();
        System.out.println("What is your username? ");
        String username = scan.nextLine();
        System.out.println("What is your phone number? ");
        String phoneNum = scan.nextLine();
        
        //Instantiate a user object with the user's information
        User user1 = new User(firstName, lastName, email, username, phoneNum);

        //Generate the random password
        String password = user1.generatePassword();
        System.out.println("Your password is: " + password);

        //Print the user's information
        System.out.println(user1.toString());
        
        //Encrypt the password
        String encrypted = AES.encrypt(password, "asecretkey") ;
        System.out.println("Encrypted: " + encrypted);
        //Decrypt the password
        String decrypted = AES.decrypt(encrypted, "asecretkey");
        System.out.println("Decrypted: " + decrypted);

        //Ask the user their information for the attributes
        System.out.println("What is your first name? ");
        String firstName2 = scan.nextLine();
        System.out.println("What is your last name? ");
        String lastName2 = scan.nextLine();
        System.out.println("What is your email? ");
        String email2 = scan.nextLine();
        System.out.println("What is your username? ");
        String username2 = scan.nextLine();
        System.out.println("What is your phone number? ");
        String phoneNum2 = scan.nextLine();

        //Instantiate a second user object with the user's information
        User user2 = new User(firstName2, lastName2, email2, username2, phoneNum2);

        //Generate the random password
        String password2 = user2.generatePassword();
        System.out.println("Your password is: " + password2);

        //Print the user's information
        System.out.println(user2.toString());

        //Encrypt the password
        String encrypted2 = AES.encrypt(password2, "asecretkey") ;
        System.out.println("Encrypted: " + encrypted2);
        //Decrypt the password
        String decrypted2 = AES.decrypt(encrypted2, "asecretkey");
        System.out.println("Decrypted: " + decrypted2);

    }
}

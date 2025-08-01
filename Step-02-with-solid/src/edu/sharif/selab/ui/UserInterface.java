package edu.sharif.selab.ui;

import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.Message;
import edu.sharif.selab.models.SmsMessage;
import edu.sharif.selab.models.TelegramMessage;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    
    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Displays the main menu and gets user choice
     * @return the user's choice (0-3)
     */
    public int showMenu() {
        System.out.println("Hello and Welcome to SE Lab Messenger.");
        System.out.println("In order to send Sms message enter 1");
        System.out.println("In order to send Email message enter 2");
        System.out.println("In order to send Telegram message enter 3");
        System.out.println("In order to Exit, Enter 0");
        
        return scanner.nextInt();
    }
    
    /**
     * Creates an SMS message based on user input
     * @return the created SMS message
     */
    public SmsMessage createSmsMessage() {
        SmsMessage smsMessage = new SmsMessage();
        
        System.out.print("Enter source phone : ");
        String source = scanner.next();
        smsMessage.setSourcePhoneNumber(source);
        
        System.out.print("Enter target phone : ");
        String target = scanner.next();
        smsMessage.setTargetPhoneNumber(target);
        
        System.out.println("Write Your Message : ");
        String content = scanner.next(".*$");
        smsMessage.setContent(content);
        
        return smsMessage;
    }
    
    /**
     * Creates an Email message based on user input
     * @return the created Email message
     */
    public EmailMessage createEmailMessage() {
        EmailMessage emailMessage = new EmailMessage();
        
        System.out.print("Enter source email : ");
        String source = scanner.next();
        emailMessage.setSourceEmailAddress(source);
        
        System.out.print("Enter target email : ");
        String target = scanner.next();
        emailMessage.setTargetEmailAddress(target);
        
        System.out.println("Write Your Message : ");
        String content = scanner.next();
        emailMessage.setContent(content);
        
        return emailMessage;
    }
    
    /**
     * Creates a Telegram message based on user input
     * @return the created Telegram message
     */
    public TelegramMessage createTelegramMessage() {
        TelegramMessage telegramMessage = new TelegramMessage();
        
        System.out.print("Enter source Telegram ID : ");
        String source = scanner.next();
        telegramMessage.setSourceId(source);
        
        System.out.print("Enter target Telegram ID : ");
        String target = scanner.next();
        telegramMessage.setTargetId(target);
        
        System.out.println("Write Your Message : ");
        String content = scanner.next();
        telegramMessage.setContent(content);
        
        return telegramMessage;
    }
    
    /**
     * Creates a message based on the user's choice
     * @param choice the user's choice (1-3)
     * @return the created message
     */
    public Message createMessage(int choice) {
        switch (choice) {
            case 1:
                return createSmsMessage();
            case 2:
                return createEmailMessage();
            case 3:
                return createTelegramMessage();
            default:
                throw new IllegalArgumentException("Invalid choice: " + choice);
        }
    }
    
    /**
     * Closes the scanner
     */
    public void close() {
        scanner.close();
    }
}
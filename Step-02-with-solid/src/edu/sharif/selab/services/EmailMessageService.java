package edu.sharif.selab.services;

import edu.sharif.selab.models.Message;
import edu.sharif.selab.models.EmailMessage;

import java.util.regex.Pattern;

public class EmailMessageService implements EmailMessageSender {
    
    @Override
    public void send(Message message) {
        if (message instanceof EmailMessage) {
            sendEmail((EmailMessage) message);
        } else {
            throw new IllegalArgumentException("This service can only handle Email messages");
        }
    }
    
    @Override
    public boolean canHandle(Message message) {
        return message instanceof EmailMessage;
    }

    @Override
    public void sendEmail(EmailMessage emailMessage) {
        if(validateEmailAddress(emailMessage.getSourceEmailAddress()) && validateEmailAddress(emailMessage.getTargetEmailAddress())){
            System.out.println("Sending an Email from " + emailMessage.getSourceEmailAddress() + " to " + emailMessage.getTargetEmailAddress() + " with content : " + emailMessage.getContent());
        }else{
            throw new IllegalArgumentException("Email Address is Not Correct!");
        }
    }

    private boolean validateEmailAddress(String email) {
        // Regular expression pattern for validating email addresses
        String emailRegex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

        // Compile the pattern into a regex Pattern object
        Pattern pattern = Pattern.compile(emailRegex);

        // Check if the email string matches the regex pattern
        return pattern.matcher(email).matches();
    }
}

package edu.sharif.selab.processor;

import edu.sharif.selab.models.Message;
import edu.sharif.selab.services.MessageSender;
import edu.sharif.selab.services.MessageSenderFactory;

public class MessageProcessor {
    
    /**
     * Processes and sends a message using the appropriate sender
     * @param message the message to process and send
     */
    public void processMessage(Message message) {
        try {
            MessageSender sender = MessageSenderFactory.getSender(message);
            sender.send(message);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error occurred: " + e.getMessage());
        }
    }
}
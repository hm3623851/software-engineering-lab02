package edu.sharif.selab.services;

import edu.sharif.selab.models.Message;

public interface MessageSender {
    /**
     * Sends a message
     * @param message the message to send
     */
    void send(Message message);
    
    /**
     * Checks if this sender can handle the given message type
     * @param message the message to check
     * @return true if this sender can handle the message type
     */
    boolean canHandle(Message message);
}
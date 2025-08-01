package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;

public interface EmailMessageSender extends MessageSender {
    /**
     * Sends an email message
     * @param emailMessage the email message to send
     */
    void sendEmail(EmailMessage emailMessage);
}
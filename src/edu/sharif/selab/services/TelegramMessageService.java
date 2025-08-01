package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.SmsMessage;
import edu.sharif.selab.models.TelegramMessage;

public class TelegramMessageService implements MessageService {
    @Override
    public void sendSmsMessage(SmsMessage smsMessage) {
        //Empty Body
    }

    @Override
    public void sendEmailMessage(EmailMessage emailMessage) {
        //Empty Body
    }

    @Override
    public void sendTelegramMessage(TelegramMessage telegramMessage) {
        if (validateTelegramId(telegramMessage.getSourceId()) && validateTelegramId(telegramMessage.getTargetId())) {
            System.out.println("Sending a Telegram message from " + telegramMessage.getSourceId() + 
                             " to " + telegramMessage.getTargetId() + 
                             " with content : " + telegramMessage.getContent());
        } else {
            throw new IllegalArgumentException("Telegram ID is Not Correct!");
        }
    }

    /**
     * Validates Telegram ID format
     * Telegram IDs can be:
     * - Username: starts with @ followed by 5-32 alphanumeric characters, underscores allowed
     * - User ID: numeric string (positive integer)
     * @param telegramId the ID to validate
     * @return true if valid, false otherwise
     */
    private boolean validateTelegramId(String telegramId) {
        if (telegramId == null || telegramId.trim().isEmpty()) {
            return false;
        }

        telegramId = telegramId.trim();

        // Check if it's a username (starts with @)
        if (telegramId.startsWith("@")) {
            // Username should be @username with 5-32 characters after @
            if (telegramId.length() < 6 || telegramId.length() > 33) {
                return false;
            }
            String username = telegramId.substring(1); // Remove @
            // Username can contain only alphanumeric characters and underscores
            return username.matches("^[a-zA-Z0-9_]+$");
        } else {
            // Check if it's a numeric user ID (positive integer)
            try {
                long userId = Long.parseLong(telegramId);
                return userId > 0;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
}
package edu.sharif.selab.services;

import edu.sharif.selab.models.Message;
import java.util.Arrays;
import java.util.List;

public class MessageSenderFactory {
    private static final List<MessageSender> senders = Arrays.asList(
        new SmsMessageService(),
        new EmailMessageService(),
        new TelegramMessageService()
    );

    /**
     * Gets the appropriate message sender for the given message
     * @param message the message to find a sender for
     * @return the appropriate message sender
     * @throws IllegalArgumentException if no sender is found for the message type
     */
    public static MessageSender getSender(Message message) {
        return senders.stream()
            .filter(sender -> sender.canHandle(message))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("No sender found for message type: " + message.getClass().getSimpleName()));
    }
}
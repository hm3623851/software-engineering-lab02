package edu.sharif.selab.services;

import edu.sharif.selab.models.TelegramMessage;

public interface TelegramMessageSender extends MessageSender {
    /**
     * Sends a Telegram message
     * @param telegramMessage the Telegram message to send
     */
    void sendTelegram(TelegramMessage telegramMessage);
}
package edu.sharif.selab.services;

import edu.sharif.selab.models.SmsMessage;

public interface SmsMessageSender extends MessageSender {
    /**
     * Sends an SMS message
     * @param smsMessage the SMS message to send
     */
    void sendSms(SmsMessage smsMessage);
}
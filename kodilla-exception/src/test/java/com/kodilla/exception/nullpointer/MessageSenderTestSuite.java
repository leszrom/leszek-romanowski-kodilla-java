package com.kodilla.exception.nullpointer;

import org.junit.Assert;
import org.junit.Test;

public class MessageSenderTestSuite {
    @Test
    public void should_throw_exception_with_message_while_user_is_null() {
        //Given
        User user = null;
        MessageSender messageSender = new MessageSender();
        //When
        try {
            messageSender.sendMessageTo(user, "Hello!!!");
        } catch (MessageNotSendException e) {
            System.out.println("Message is not send, " + e.getMessage() + ", but my program is still running very well");
            //Then
            Assert.assertEquals("Object User was null", e.getMessage());
        }
        System.out.println("Processing other logic!");


    }

}

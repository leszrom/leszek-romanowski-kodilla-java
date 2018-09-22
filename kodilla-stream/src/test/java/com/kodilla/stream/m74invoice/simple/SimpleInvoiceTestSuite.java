package com.kodilla.stream.m74invoice.simple;

import org.junit.Assert;
import org.junit.Test;

public class SimpleInvoiceTestSuite {
    @Test
    public void should_return_total_price_of_all_items() {

        //Given
        SimpleInvoice invoice = new SimpleInvoice();
        //When
        invoice.addItem(new SimpleItem(new SimpleProduct("Product1",17.28), 2.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product2",11.99), 3.5));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product3",6.49), 5.0));
        //Then
        Assert.assertEquals(108.976, invoice.getValueToPay(), 0.001);
    }
}

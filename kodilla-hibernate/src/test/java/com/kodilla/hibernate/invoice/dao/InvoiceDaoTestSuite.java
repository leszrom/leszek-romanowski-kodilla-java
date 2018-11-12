package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void should_add_given_invoice_to_data_base() {
        //Given
        Invoice invoice = new Invoice("F01/03/2018");

        Product cup = new Product("Cup");
        Product plate = new Product("Plate");
        Product pot = new Product("Pot");

        Item cupItem = new Item(new BigDecimal(20), 5);
        Item plateItem = new Item(new BigDecimal(35), 2);
        Item potItem = new Item(new BigDecimal(50), 1);

        cupItem.setProduct(cup);
        plateItem.setProduct(plate);
        potItem.setProduct(pot);

        invoice.getItems().add(cupItem);
        invoice.getItems().add(plateItem);
        invoice.getItems().add(potItem);

        cupItem.setInvoice(invoice);
        plateItem.setInvoice(invoice);
        potItem.setInvoice(invoice);

        cup.getItems().add(cupItem);
        pot.getItems().add(potItem);
        plate.getItems().add(plateItem);

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        //Then
        Assert.assertNotEquals(0, invoiceId);

        //CleanUp
        invoiceDao.delete(invoiceId);
    }
}
package com.kodilla.stream.m73person;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PeopleTestSuite {
    @Test
    public void should_return_uppercase_list() {
        //Given
        People peopleMock = mock(People.class);
        List<String> theListMock = new ArrayList<>();
        theListMock.add("John Smith");
        theListMock.add("Dory New");

        when(peopleMock.getList()).thenReturn(theListMock);

        //When
        List<String> theList = peopleMock.getList().stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        //Then
        Assert.assertEquals("JOHN SMITH", theList.get(0));
        Assert.assertEquals("DORY NEW", theList.get(1));
        Assert.assertEquals(2, theList.size());

    }

    @Test
    public void should_return_names() {
        //Given
        People peopleMock = mock(People.class);
        List<String> theListMock = new ArrayList<>();
        theListMock.add("John Smith");
        theListMock.add("Maryanna New");
        theListMock.add("Mary Cat");
        theListMock.add("Matilda Davies");

        when(peopleMock.getList()).thenReturn(theListMock);

        //When
        List<String> theList = peopleMock.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .collect(Collectors.toList());
        //Then
        Assert.assertEquals(2, theList.size());
        Assert.assertEquals("MARYANNA N.", theList.get(0));
        Assert.assertEquals("MATILDA D.", theList.get(1));
    }

}

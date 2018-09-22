package com.kodilla.stream.z71beautifier;

public class PoemBeautifier {
    public String beautify(String textToBeautify, PoemDecorator poemDecorator) {
        String result = poemDecorator.decorate(textToBeautify);
        System.out.println("Decorated text: " + result);
        return result;
    }
}

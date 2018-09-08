package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {
    public ArrayList<Integer> exterminateOdd(ArrayList<Integer> integerList) {
        for (int i = 0; i < integerList.size(); i++)
            if (integerList.get(i) % 2 != 0) {
                integerList.remove(i);
                i--;
            }
        return integerList;
    }
}

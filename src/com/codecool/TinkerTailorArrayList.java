package com.codecool;

import java.util.*;

public class TinkerTailorArrayList implements TinkerTailor {

    private List<Integer> inputList = new ArrayList<>();
    private List<Integer> resultList = new ArrayList<>();
    private Integer[] resultArray = new Integer[0];

    @Override
    public void clear() {
        inputList.clear();
        resultList.clear();
        resultArray = null;
    }

    /**
     * __Mézi Tomi's__ solution. Copied it here to see performance differences between Linked List and Array List */
    public void countingGamer(Integer[] inputArray, int K) {

        if (K == 1) {
            resultArray = inputArray;
            return;
        }

        inputList.addAll(Arrays.asList(inputArray));

        int iterator = -1;
        while (inputList.size() > 0) {
            //Adding K to iterator
            iterator += K;
            iterator %= inputList.size(); // This way iterator never overflows original array's size

            //Removing from an array returns the removed item as well, so lets add that to the solution array, then lower the iterator
            resultList.add(inputList.remove(iterator--));
        }

        resultArray = resultList.toArray(new Integer[0]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int number : resultArray) {
            sb.append(String.valueOf(number)).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

    void testArrayList() {
        int k = 5;
        for (int i = 1; i < 11; i++) {
            inputList.add(i);
            System.out.println(i);
            System.out.println(k % i);
            System.out.println();

        }
    }

}

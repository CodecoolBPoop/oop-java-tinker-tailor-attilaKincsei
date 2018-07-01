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

    public void countingGamer(Integer[] inputArray, int K) {

        if (K == 1) {
            resultArray = inputArray;
            return;
        }

        inputList.addAll(Arrays.asList(inputArray));

//        ListIterator<Integer> iter = inputList.listIterator();

        int allAroundIndex = 1;
        do {
//            Integer currentChild = null;
            for (int i = 0; i < inputList.size(); i++) {
                if ((allAroundIndex) % K == 0) {
                    resultList.add(inputList.get(i));
                    inputList.remove(i);
                    allAroundIndex--;
                }
                allAroundIndex++;
            }

            if (inputList.size() < 2) {
                break;
            }


        } while (inputList.size() > 1);


        if (!inputList.isEmpty()) {
            resultList.add(inputList.get(0));
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
}

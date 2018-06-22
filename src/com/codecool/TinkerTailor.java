package com.codecool;

import java.util.*;

class TinkerTailor {
    LinkedList<Integer> inputList;
    List<Integer> resultList;
    Integer[] resultArray;

    void convertArrayToList(Integer[] input) {
        inputList = new LinkedList<>();
        for (int item : input) {
            inputList.add(item);
        }
    }

    Integer[] countingGamer(Integer[] inputArray, int k) {
        resultList = new LinkedList<>();
        convertArrayToList(inputArray);

        ListIterator<Integer> iter = inputList.listIterator();
        do {
            int currentIndex = 1;
            int indexOfLastRemoved = 1000000000;
            Integer currentNumber = 1000000000;
            while (iter.hasNext()) {
                currentNumber = iter.next();
                if (currentIndex % k == 0) {
                    resultList.add(currentNumber);
                    indexOfLastRemoved = iter.previousIndex();
                    iter.remove();
                }
                currentIndex++;
            }

            // Go back to beginning of list
            while (iter.hasPrevious()) {
                iter.previous();
            }
            currentIndex = 1;

            // Step forward as many times as the remainder of k
            int iterForward = k % indexOfLastRemoved - 1;
            for (int i = 0; i < iterForward; i++) {
                currentNumber = iter.next();
                currentIndex++;
            }

            if (iter.nextIndex() == 0) {
                currentNumber = iter.next();
                currentIndex++;
            }
            resultList.add(currentNumber);
            iter.remove();
        } while (inputList.size() > 1);

        if (!inputList.isEmpty()) {
            resultList.add(inputList.get(0));
        }
        resultArray = resultList.toArray(new Integer[0]);
        return resultArray;
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

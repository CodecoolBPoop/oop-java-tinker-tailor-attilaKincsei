package com.codecool;

import java.util.*;

class TinkerTailor {
    private LinkedList<Integer> inputList = new LinkedList<>();
    private List<Integer> resultList = new LinkedList<>();
    private Integer[] resultArray = new Integer[0];

    void clear() {
        inputList.clear();
        resultList.clear();
        resultArray = null;
    }

    void countingGamer(Integer[] inputArray, int k) {

        if (k == 1) {
            resultArray = inputArray;
            return;
        }

        inputList.addAll(Arrays.asList(inputArray));

        ListIterator<Integer> iter = inputList.listIterator();

        do {
            int fractionIndexOfK = 1;
            Integer currentNumber = 1000000000;  // TODO: HOW TO HANDLE "variable indexOfLastRemoved might not have been initialized" ERROR WITHOUT GIVING A MAGIC VAULE TO THE DECLARED VARIABLE?
            while (iter.hasNext()) {
                currentNumber = iter.next();
                if (fractionIndexOfK == k) {
                    resultList.add(currentNumber);
                    iter.remove();
                    fractionIndexOfK = 1;
                } else {
                    if (iter.hasNext()) {
                        fractionIndexOfK++;
                    }
                }
            }

            if (inputList.size() < 2) {
                break;
            }

            // Go back to beginning of list
            while (iter.hasPrevious()) {
                iter.previous();
            }

            // Step forward as many times as the modulo of the remainder of k
            int listSize = inputList.size();
            int iterForward = k - fractionIndexOfK;
            int actualIterForward = iterForward % listSize;
            if (actualIterForward > 0) {
                for (int i = 0; i < actualIterForward; i++) {
                    currentNumber = iter.next();
                }
                resultList.add(currentNumber);
                iter.remove();

            } else if (actualIterForward == 0) {
                for (int i = 0; i < iterForward; i++) {
                    currentNumber = iter.next();
                }
                resultList.add(currentNumber);
                iter.remove();

            } else {
                currentNumber = iter.next();
                resultList.add(currentNumber);
                iter.remove();

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

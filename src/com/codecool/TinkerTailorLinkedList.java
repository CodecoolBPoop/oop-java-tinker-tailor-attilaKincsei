package com.codecool;

import java.util.*;

class TinkerTailorLinkedList implements TinkerTailor {
    private List<Integer> inputList = new LinkedList<>();
    private List<Integer> resultList = new LinkedList<>();

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


        int allAroundIndex = 1;
        do {
            Integer currentChild = null;  // TODO: HOW TO HANDLE "variable indexOfLastRemoved might not have been initialized" ERROR WITHOUT GIVING A MAGIC VAULE TO THE DECLARED VARIABLE?
            ListIterator<Integer> iter = inputList.listIterator();
            while (iter.hasNext()) {

                currentChild = iter.next();
                if (allAroundIndex % K == 0) {
                    resultList.add(currentChild);
                    iter.remove();
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

    void iteratorTest() {
        Integer[] inputArray = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        inputList.addAll(Arrays.asList(inputArray));

        ListIterator<Integer> iter = inputList.listIterator();
        while (iter.hasNext()) {
            int currentElement = iter.next();
            if (currentElement % 2 == 0) {
                iter.remove();
            }
            if (!iter.hasNext()) {
                Iterator firstElement = inputList.listIterator(4);
                System.out.println(firstElement.next());
            }
        }
        System.out.println(inputList);
    }


}

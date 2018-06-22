package com.codecool;

import java.util.*;

class TinkerTailor {
    List<Integer> inputList;
    List<Integer> resultList;
    int[] resultArray;

    void convertArrayToList(int[] input) {
        inputList = new LinkedList<>();
        for (int item : input) {
            inputList.add(item);
        }
    }

    int[] convertListToArray(List<Integer> list) {
        int arrayIndex = 0;
        int[] tempArray = new int[list.size()];
        for (Integer number : list) {
            tempArray[arrayIndex] = number;
            arrayIndex++;
        }
        return tempArray;
    }

    int[] countingGamer(int[] inputArray, int k) {
        int n = inputArray.length;
        resultList = new LinkedList<>();

        convertArrayToList(inputArray);

        int iterations = 0;
        do {
            ListIterator<Integer> iter = inputList.listIterator();
            for (int i = 0; i < k; i++) {
                if (!iter.hasNext()) {
                    for (int j = 0; j < iter.previousIndex() - i; j++) {
                        iter.previous();
                    }
                    System.out.println(iter.nextIndex());
                    iter.remove();
                }
                Integer toBeRemoved = iter.next();
                if (iter.previousIndex() == k - 1) {
                    resultList.add(inputList.get(iter.previousIndex()));
                    iter.remove();
//                    iter.previous();
//                    iter.next();
                    System.out.println(String.format("Element to be removed: %d", toBeRemoved));
                }
            }
            System.out.println("inputList = [" + inputList + "], k = [" + k + "]");
            System.out.println("resultList = [" + resultList + "], k = [" + k + "]");
            iterations++;
        } while (iterations < 10);

        resultArray = convertListToArray(resultList);
        return resultArray;
    }

    public static void main(String[] args) {
        int[] sourceArray = new int[] {1, 2, 3, 4, 5};
        int k = 3;

        TinkerTailor testInstance = new TinkerTailor();
        testInstance.countingGamer(sourceArray, k);
    }
}

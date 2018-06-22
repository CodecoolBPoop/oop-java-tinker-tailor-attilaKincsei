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
        resultList = new LinkedList<>();

        convertArrayToList(inputArray);

        int iterations = 0;
        ListIterator<Integer> iter = inputList.listIterator();
        do {
            int removeIndex = 1;
            int listLength = inputList.size();
            while (iter.hasNext()) {
                Integer currentNumber = iter.next();
                if (removeIndex % k == 0) {
                    resultList.add(currentNumber);
                    iter.remove();
                }
                removeIndex++;
            }


            for (int i = 0; i < k; i++) {
                Integer toBeRemoved = iter.next();
                int deletedIndex = iter.previousIndex();
                if (deletedIndex == k - 1) {
                    iter.remove();
                    resultList.add(toBeRemoved);

                    int excessLength = deletedIndex + k - inputList.size();
                    if (excessLength > 0) {
                        do {
                            iter.previous();
                        } while (iter.hasPrevious());
                        Integer toBeRemoved2 = 1000000000;
                        for (int j = 0; j < excessLength; j++) {
                            toBeRemoved2 = iter.next();
                        }
                        resultList.add(toBeRemoved2);
                        System.out.println("2. " + resultList);
                        iter.remove();
                    }
                }

            }
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

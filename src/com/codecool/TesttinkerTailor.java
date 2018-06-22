package com.codecool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TesttinkerTailor {

    private static int[] runFunctionalityTest(TinkerTailor tinkerer, int[] sourceArray, int k) {
        int[] actualResult = tinkerer.countingGamer(sourceArray, k);
        return actualResult;
    }

    private static void runAllFunctionalityTests(TinkerTailor tinkerer) {
        int[] sourceArray = new int[] {1, 2, 3, 4, 5};
        int[] resultExpected = new int[] {3, 1, 5, 2, 4};
        List<Integer> expectedResult = new ArrayList<>();
        int k = 3;

        int[] actualResult;

        actualResult = runFunctionalityTest(tinkerer, sourceArray, k);
        if (!expectedResult.equals(actualResult)) {
            System.out.println("Test 1 failed!");
        } else {
            System.out.println("Test 1 passed!");
        }
        System.out.println("Expected:");
        System.out.println(Arrays.toString(resultExpected));
        System.out.println("Actual:");
        System.out.println(Arrays.toString(actualResult));

    }

    public static void main(String[] args) {
        System.out.println("****** Functionality Tests *******");
        runAllFunctionalityTests(new TinkerTailor());
    }

}

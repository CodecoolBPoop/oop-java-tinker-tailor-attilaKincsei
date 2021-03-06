package com.codecool;

import java.util.ArrayList;

public class TestTinkerTailor {

    static Integer[] sourceArray;
    static int[] resultExpected;
    static int k;
    static String expectedString;
    static String actualString;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int number : resultExpected) {
            sb.append(String.valueOf(number)).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

    private static void printAssessment(int length) {
        String testAssessment = (expectedString.equals(actualString) ? "passed" : "failed");
        System.out.printf("Value of K: %d", length);
        System.out.println();
        System.out.printf("Test %s %s!", length, testAssessment);
        System.out.println();
        System.out.println("Expected: " + expectedString);
        System.out.println("Actual: " + actualString);
        System.out.println("---------------------------------");
    }

    private static String runFunctionalityTest(TinkerTailor tinkerer, Integer[] sourceArray, int k) {
        tinkerer.clear();
        tinkerer.countingGamer(sourceArray, k);
        TestTinkerTailor testTinkerTailor = new TestTinkerTailor();
        expectedString = testTinkerTailor.toString();

        return tinkerer.toString();
    }

    // PERFORMANCE TESTS
    private static void runAllFunctionalityTests(TinkerTailor tinkerer) {
        System.out.println("-----------------------------------");
        System.out.println("Test array for all tests: 1 2 3 4 5");
        System.out.println("-----------------------------------");

        // Test 1
        sourceArray = new Integer[] {1, 2, 3, 4, 5};
        resultExpected = new int[] {1, 2, 3, 4, 5};
        k = 1;
        actualString = runFunctionalityTest(tinkerer, sourceArray, k);
        printAssessment(k);

        // Test 2
        sourceArray = new Integer[] {1, 2, 3, 4, 5};
        resultExpected = new int[] {2, 4, 1, 5, 3};
        k = 2;
        actualString = runFunctionalityTest(tinkerer, sourceArray, k);
        printAssessment(k);

        // Test 3
        sourceArray = new Integer[] {1, 2, 3, 4, 5};
        resultExpected = new int[] {3, 1, 5, 2, 4};
        k = 3;
        actualString = runFunctionalityTest(tinkerer, sourceArray, k);
        printAssessment(k);

        // Test 4
        sourceArray = new Integer[] {1, 2, 3, 4, 5};
        resultExpected = new int[] {4, 3, 5, 2, 1};
        k = 4;
        actualString = runFunctionalityTest(tinkerer, sourceArray, k);
        printAssessment(k);

        // Test 5
        sourceArray = new Integer[] {1, 2, 3, 4, 5};
        resultExpected = new int[] {5, 1, 3, 4, 2};
        k = 5;
        actualString = runFunctionalityTest(tinkerer, sourceArray, k);
        printAssessment(k);

        // Test 6
        sourceArray = new Integer[] {1, 2, 3, 4, 5};
        resultExpected = new int[] {1, 3, 2, 5, 4};
        k = 6;
        actualString = runFunctionalityTest(tinkerer, sourceArray, k);
        printAssessment(k);

        // Test 7
        sourceArray = new Integer[] {1, 2, 3, 4, 5};
        resultExpected = new int[] {2, 5, 1, 3, 4};
        k = 7;
        actualString = runFunctionalityTest(tinkerer, sourceArray, k);
        printAssessment(k);

        // Test 8
        sourceArray = new Integer[] {1, 2, 3, 4, 5};
        resultExpected = new int[] {3, 2, 5, 4, 1};
        k = 8;
        actualString = runFunctionalityTest(tinkerer, sourceArray, k);
        printAssessment(k);

        // Test 9
        sourceArray = new Integer[] {1, 2, 3, 4, 5};
        resultExpected = new int[] {4, 5, 3, 1, 2};
        k = 9;
        actualString = runFunctionalityTest(tinkerer, sourceArray, k);
        printAssessment(k);

        // Test 10
        sourceArray = new Integer[] {1, 2, 3, 4, 5};
        resultExpected = new int[] {5, 2, 3, 1, 4};
        k = 10;
        actualString = runFunctionalityTest(tinkerer, sourceArray, k);
        printAssessment(k);


    }

    private static Integer[] createSourceArray(int length) {
        Integer[] performanceSourceArray = new Integer[length];
        for (Integer i = 0; i < length; i++) {
            performanceSourceArray[i] = i;

        }
        return performanceSourceArray;
    }

    private static void runPerformanceTest(TinkerTailor tinkerer, int sourceArrayLength, int k) {
        tinkerer.clear();
        sourceArray = createSourceArray(sourceArrayLength);
        long start = System.currentTimeMillis();
        tinkerer.countingGamer(sourceArray, k);
        long end = System.currentTimeMillis();
        String dataStructureType;
        dataStructureType = (tinkerer instanceof TinkerTailorArrayList) ? "Array List" : "Linked list";
        System.out.printf("Test took %d ms with %s", (end - start), dataStructureType);
        System.out.println();
    }

    private static void printForPerformanceTest(int N, int K) {
        System.out.printf("N = %d; K = %d", N, K);
        System.out.println();
        System.out.println("---------------------------------");
    }

    private static void runAllPerformanceTests(TinkerTailor testClass1, TinkerTailor testClass2) {
        runPerformanceTest(testClass1, 100_000, 1);
        runPerformanceTest(testClass2, 100_000, 1);
        printForPerformanceTest(100_000, 1);

        runPerformanceTest(testClass1, 100_000, 5);
        runPerformanceTest(testClass2, 100_000, 5);
        printForPerformanceTest(100_000, 5);

        runPerformanceTest(testClass1, 100_000, 50);
        runPerformanceTest(testClass2, 100_000, 50);
        printForPerformanceTest(100_000, 50);

        // ~0.4% threshold where array list becomes faster than linked list:
        runPerformanceTest(testClass1, 100_000, 400);
        runPerformanceTest(testClass2, 100_000, 400);
        printForPerformanceTest(100_000, 400);

        runPerformanceTest(testClass1, 100_000, 500);
        runPerformanceTest(testClass2, 100_000, 500);
        printForPerformanceTest(100_000, 500);

        runPerformanceTest(testClass1, 100_000, 5000);
        runPerformanceTest(testClass2, 100_000, 5000);
        printForPerformanceTest(100_000, 5000);

//        runPerformanceTest(testClass1, 100_000, 500_000);
//        runPerformanceTest(testClass2, 100_000, 500_000);
//        printForPerformanceTest(100_000, 500_000);
//        ---------------------------------
//        Test took 357 ms with Array List
//        Test took 381192 ms with Linked list
//        N = 100000; K = 500000
//        ---------------------------------

    }


    public static void main(String[] args) {
        System.out.println("****** Functionality Tests - Linked List *******");
        runAllFunctionalityTests(new TinkerTailorLinkedList());
        System.out.println("****** Functionality Tests - Array List (Mézi) *******");
        runAllFunctionalityTests(new TinkerTailorArrayList());
        System.out.println();

        System.out.println("****** Performance Tests*******");
        runAllPerformanceTests(new TinkerTailorArrayList(), new TinkerTailorLinkedList());

    }

}

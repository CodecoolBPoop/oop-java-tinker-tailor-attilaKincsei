package com.codecool;

public class TestTinkerTailor {

    static String funcHeader = "****** Functionality Tests *******";
    static Integer[] sourceArray;
    static int[] resultExpected;
    static int k;
    static String expectedString;
    static String actualString;
    static String testIndex;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int number : resultExpected) {
            sb.append(String.valueOf(number)).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

    private static void printAssessment() {
        String testAssessment = (expectedString.equals(actualString) ? "passed" : "failed");
        System.out.printf("Test %s %s!", testIndex, testAssessment);
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

    // TODO: 1. CLEAN CODE REFACTOR
    // TODO: 2. WRITE MORE TESTS:
    // - K > N,
    // - K == 1
    // - K == N
    // PERFORMANCE TESTS
    private static void runAllFunctionalityTests(TinkerTailor tinkerer) {
        // Test 1
        sourceArray = new Integer[] {1, 2, 3, 4, 5};
        resultExpected = new int[] {1, 2, 3, 4, 5};
        k = 1;
        actualString = runFunctionalityTest(tinkerer, sourceArray, k);
        testIndex = "1";
        printAssessment();

        // Test 2
        sourceArray = new Integer[] {1, 2, 3, 4, 5};
        resultExpected = new int[] {2, 4, 1, 5, 3};
        k = 2;
        actualString = runFunctionalityTest(tinkerer, sourceArray, k);
        testIndex = "2";
        printAssessment();

        // Test 3
        sourceArray = new Integer[] {1, 2, 3, 4, 5};
        resultExpected = new int[] {3, 1, 5, 2, 4};
        k = 3;
        actualString = runFunctionalityTest(tinkerer, sourceArray, k);
        testIndex = "3";
        printAssessment();

        // Test 4
        sourceArray = new Integer[] {1, 2, 3, 4, 5};
        resultExpected = new int[] {4, 3, 5, 2, 1};
        k = 4;
        actualString = runFunctionalityTest(tinkerer, sourceArray, k);
        testIndex = "4";
        printAssessment();

        // Test 5
        sourceArray = new Integer[] {1, 2, 3, 4, 5};
        resultExpected = new int[] {5, 1, 3, 4, 2};
        k = 5;
        actualString = runFunctionalityTest(tinkerer, sourceArray, k);
        testIndex = "5";
        printAssessment();

//        // Test 6
//        sourceArray = new Integer[] {1, 2, 3, 4, 5};
//        resultExpected = new int[] {1, 3, 2, 5, 4};
//        k = 6;
//        actualString = runFunctionalityTest(tinkerer, sourceArray, k);
//        testIndex = "6";
//        printAssessment();

    }

    public static void main(String[] args) {
        System.out.println(funcHeader);
        runAllFunctionalityTests(new TinkerTailor());
//        TinkerTailor test = new TinkerTailor();
//        test.iteratorTest();
    }

}

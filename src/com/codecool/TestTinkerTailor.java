package com.codecool;

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


    private static String runFunctionalityTest(TinkerTailor tinkerer, Integer[] sourceArray, int k) {
        tinkerer.countingGamer(sourceArray, k);
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
        resultExpected = new int[] {3, 1, 5, 2, 4};
        k = 3;
        TestTinkerTailor forPrinting = new TestTinkerTailor();
        expectedString = forPrinting.toString();

        actualString = runFunctionalityTest(tinkerer, sourceArray, k);

        System.out.println("Expected: " + expectedString);
        System.out.println("Actual: " + actualString);
        if (!expectedString.equals(actualString)) {
            System.out.println("Test 1 failed!");
        } else {
            System.out.println("Test 1 passed!");
        }

        // Test 2
        sourceArray = new Integer[] {1, 2, 3, 4, 5};
        resultExpected = new int[] {2, 4, 1, 5, 3};
        k = 2;
        TestTinkerTailor testTTInstance = new TestTinkerTailor();
        expectedString = testTTInstance.toString();

        actualString = runFunctionalityTest(tinkerer, sourceArray, k);

        System.out.println("Expected: " + expectedString);
        System.out.println("Actual: " + actualString);
        if (!expectedString.equals(actualString)) {
            System.out.println("Test 2 failed!");
        } else {
            System.out.println("Test 2 passed!");
        }

    }

    public static void main(String[] args) {
        System.out.println("****** Functionality Tests *******");
        runAllFunctionalityTests(new TinkerTailor());
    }

}

package de.telran;

public class ConcatenationTester {

    private IConcatenator concatenator;


    public ConcatenationTester(IConcatenator concatenator) {
        this.concatenator = concatenator;
    }

    public void test (int n, String text){
        String[] strings = composeArray(n, text);
        long startTime = System.currentTimeMillis();
        concatenator.concatenate(strings);
        System.out.println(System.currentTimeMillis() - startTime);
    }

    private String[] composeArray(int n, String text){
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = text;
        }
        return res;
    }
}

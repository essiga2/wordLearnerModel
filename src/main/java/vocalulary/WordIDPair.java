package vocalulary;

/**
 * Created by EmerenciaAmarylla on 9/29/2016.
 */
public class WordIDPair {
    private long word1ID;
    private long word2ID;

    private int numberOftest = 0;
    private int succcessfulTest = 0;

    public int[] getStatistics() {
        return new int[]{numberOftest, succcessfulTest};
    }

    public void successfulTest() {
        numberOftest++;
        succcessfulTest++;
    }

    public void unsuccessfulTest() {
        numberOftest++;
    }
}

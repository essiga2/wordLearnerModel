package vocalulary;

/**
 * Created by EmerenciaAmarylla on 9/29/2016.
 */
public class WordIDPair {

    private long word1ID;
    private long word2ID;

    private int numberOftest = 0;
    private int succcessfulTest = 0;

    public WordIDPair(long _word1ID, long _word2ID){
        word1ID = _word1ID;
        word2ID = _word2ID;
    }

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

    public long getWord1ID() {
        return word1ID;
    }

    public long getWord2ID() {
        return word2ID;
    }

}

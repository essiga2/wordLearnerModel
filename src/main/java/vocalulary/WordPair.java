package vocalulary;

import vocabularyInterfaces.IWordPair;

/**
 * Created by EmerenciaAmarylla on 9/29/2016.
 */
public class WordPair implements IWordPair {
    private WordIDPair wordIDPair;
    private String fromWord;
    private String toWord;

    public WordPair(String _fromWord, String _toWord, WordIDPair _wordIDPair) {
        wordIDPair = _wordIDPair;
        fromWord = _fromWord;
        toWord = _toWord;
    }

    public String[] getWords() {
        return new String[]{fromWord, toWord};
    }

    public int[] getStatistics() {
        return wordIDPair.getStatistics();
    }

    public void successfulTest() {
        wordIDPair.successfulTest();
    }

    public void unsuccessfulTest() {
        wordIDPair.unsuccessfulTest();
    }
}

package vocalulary;

import vocabularyInterfaces.IWordPair;

/**
 * Created by EmerenciaAmarylla on 9/29/2016.
 */
public class WordPair implements IWordPair {
    private WordIDPair wordIDPair;
    private String fromLanguage;
    private String toLanguage;

    public WordPair(String from, String to, WordIDPair _wordIDPair) {
        wordIDPair = _wordIDPair;
        fromLanguage = from;
        toLanguage = to;
    }

    public String[] getWords() {
        return new String[]{fromLanguage, toLanguage};
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

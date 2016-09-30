package vocalulary;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by EmerenciaAmarylla on 9/29/2016.
 */
public class SubVocabulary {

    private String name;
    private Language[] languages;



    private ArrayList<WordIDPair> paires = new ArrayList<WordIDPair>();

    public SubVocabulary(String _name,Language[] _languages, ArrayList<String[]> wordPaires) throws Exception {
        name = _name;
        languages = _languages;

        for(String[] pair: wordPaires){
            paires.add(new WordIDPair(languages[0].getIDByWord(pair[0]), languages[1].getIDByWord(pair[1])));
        }
    }

    public ArrayList<WordIDPair> getPaires() {
        return paires;
    }

}

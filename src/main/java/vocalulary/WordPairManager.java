package vocalulary;

import vocabularyInterfaces.IWordPair;
import vocabularyInterfaces.IWordPairManager;

import java.util.ArrayList;

/**
 * Created by EmerenciaAmarylla on 9/29/2016.
 */
public class WordPairManager implements IWordPairManager {

    private ArrayList<IWordPair> wordPaires = new ArrayList<IWordPair>();
    private int index = 0;

    public WordPairManager(ArrayList<IWordPair> _wordPaires){
        wordPaires = _wordPaires;
    }
    public IWordPair getNext() {
        if(index < wordPaires.size())
           return wordPaires.get(index++);
        else
            return null;
    }

    public boolean hasNext() {
        return index < wordPaires.size();
    }

    public ArrayList<IWordPair> getAll() {
        return wordPaires;
    }
}

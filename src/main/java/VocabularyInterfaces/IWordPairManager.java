package VocabularyInterfaces;

import java.util.ArrayList;

/**
 * Created by EmerenciaAmarylla on 9/28/2016.
 */
public interface IWordPairManager {
    public IWordPair getNext();

    public ArrayList<IWordPair> getAll();
}

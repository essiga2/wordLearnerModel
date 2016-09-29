package vocalulary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by EmerenciaAmarylla on 9/29/2016.
 */
public class SubVocabularyManager {
    private static HashMap<Long,SubVocabularyManager> IDlSubVocabularyManagerHashMap = new HashMap<Long, SubVocabularyManager>();
    private static HashMap<String, Long> typeIdHashMap = new HashMap<String, Long>();
    private static long nextID = 0;

    private Language[] languages;


    private SubVocabularyManager(String[] _languages){
        languages = new Language[]{Language.getLanguageByName(_languages[0]), Language.getLanguageByName(_languages[0]) };

        IDlSubVocabularyManagerHashMap.put(nextID, this);
        typeIdHashMap.put(format(_languages),nextID);

        nextID++;
    }

    private static String format(String[] _languages) {
        return _languages[0]+"-"+_languages[1];
    }

    protected static void createSubVocabulary(String language1, String language2, ArrayList<String[]> wordPaires){
        ArrayList<String> _languages  =new ArrayList<String>();
        _languages.add(language1);
        _languages.add(language2);
        Collections.sort(_languages);

        if(language1 != _languages.get(0)){
            ArrayList<String[]> inTheRightOrder = new ArrayList<String[]>();
            for (String[] element:
                    wordPaires) {
                String[] next = new String[2];
                next[0] = element[1];
                next[1] = element[0];
                inTheRightOrder.add(next);
            }
            wordPaires = inTheRightOrder;
        }

        long subVocabularyManagerID = getSubVocabularyManagerID(new String[]{_languages.get(0), _languages.get(1)});

        /**Itt hagytad abba.
         * Folytatás:
         * megvan az ID
         * ebböl lekérdezzük a SVM-t
         * és hozzéadunk egy uj SV-t
         *
         * **/

    }

    private static long getSubVocabularyManagerID(String[] _languages){
        if(!typeIdHashMap.containsKey(format(_languages))){
            new SubVocabularyManager(_languages);
        }
        return typeIdHashMap.get(format(_languages));
    }
}

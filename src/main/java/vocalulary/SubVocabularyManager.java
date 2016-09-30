package vocalulary;

import vocabularyInterfaces.IWordPair;
import vocabularyInterfaces.IWordPairManager;

import java.util.*;

/**
 * Created by EmerenciaAmarylla on 9/29/2016.
 */
public class SubVocabularyManager {
    private static HashMap<Long, SubVocabularyManager> IDlSubVocabularyManagerHashMap = new HashMap<Long, SubVocabularyManager>();
    private static HashMap<String, Long> typeIdHashMap = new HashMap<String, Long>();
    private static long nextSubVocabularyManagerID = 0;
    private static long nextSubVocabularyID = 0;

    private Language[] languages;
    private HashMap<Long, SubVocabulary> IDSubVocabularyHashMap = new HashMap<Long, SubVocabulary>();
    private HashMap<String, Long> nameIDHashMap = new HashMap<String, Long>();

    private SubVocabularyManager(String[] _languages) {
        languages = new Language[]{Language.getLanguageByName(_languages[0]), Language.getLanguageByName(_languages[0])};

        IDlSubVocabularyManagerHashMap.put(nextSubVocabularyManagerID, this);
        typeIdHashMap.put(format(_languages), nextSubVocabularyManagerID);

        nextSubVocabularyManagerID++;
    }


    protected static void createSubVocabulary(String name, String language1, String language2, ArrayList<String[]> wordPaires) throws Exception {
        String[] _languages = getSortedLanguages(language1, language2);

        if (!language1.toLowerCase().equals(_languages[0])) {
            ArrayList<String[]> inTheRightOrder = new ArrayList<String[]>();
            for (String[] element :
                    wordPaires) {
                String[] next = new String[2];
                next[0] = element[1];
                next[1] = element[0];
                inTheRightOrder.add(next);
            }
            wordPaires = inTheRightOrder;
        }

        long subVocabularyManagerID = getSubVocabularyManagerID(_languages);

        SubVocabularyManager manager = IDlSubVocabularyManagerHashMap.get(subVocabularyManagerID);

        manager.addSubVocabulary(name, wordPaires);

    }

    private static String[] getSortedLanguages(String language1, String language2) {
        ArrayList<String> _languages = new ArrayList<String>();
        _languages.add(language1.toLowerCase());
        _languages.add(language2.toLowerCase());
        Collections.sort(_languages);
        return new String[]{_languages.get(0), _languages.get(1)};
    }

    private static long getSubVocabularyManagerID(String[] _languages) {
        if (!typeIdHashMap.containsKey(format(_languages))) {
            new SubVocabularyManager(_languages);
        }
        return typeIdHashMap.get(format(_languages));
    }

    public static HashMap<Long, String> getSubVocabularies(String language1, String language2) {
        long subVocabularyManagerID = getSubVocabularyManagerID(getSortedLanguages(language1, language2));

        SubVocabularyManager manager = IDlSubVocabularyManagerHashMap.get(subVocabularyManagerID);

        HashMap<Long, String> subVocabularies = new HashMap<Long, String>();

        Iterator it = manager.nameIDHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            subVocabularies.put(Long.parseLong(pair.getValue().toString()),  pair.getKey().toString());
        }
        return subVocabularies;
    }

    private static String format(String[] _languages) {
        return _languages[0] + "-" + _languages[1];
    }

    public static IWordPairManager getWordPaires(Long[] IDs, String fromLanguage, String toLanguage, double percent) throws Exception {
        long subVocabularyManagerID = getSubVocabularyManagerID(getSortedLanguages(fromLanguage, toLanguage));
        SubVocabularyManager manager = IDlSubVocabularyManagerHashMap.get(subVocabularyManagerID);

        String[] _languages = getSortedLanguages(fromLanguage, toLanguage);
        int from = 0;
        int to = 1;
        if (!fromLanguage.toLowerCase().equals(_languages[0])) {
            from = 1;
            to = 0;
        }

        ArrayList<IWordPair> paires = new ArrayList<IWordPair>();

        for (int i = 0; i < IDs.length; i++) {
            ArrayList<WordIDPair> IDPaires = manager.IDSubVocabularyHashMap.get(IDs[i]).getPaires();
            for (int j = 0; j < IDPaires.size(); j++) {
                WordIDPair element = IDPaires.get(j);
                int[] statistics = element.getStatistics();
                double result = 0;
                if(statistics[0] != 0 && statistics[1] != 0 ){
                    Integer test = statistics[0];
                    Integer succ = statistics[1];
                    result = succ.doubleValue()/test.doubleValue();
                }
                if (result < percent) {
                    long[] from_to_IDs = new long[]{element.getWord1ID(),element.getWord2ID()};
                    String fromWord = manager.languages[from].getWordByID(from_to_IDs[from]);
                    String toWord = manager.languages[to].getWordByID(from_to_IDs[to]);
                    paires.add(new WordPair(fromWord, toWord, element));
                }
            }
        }

        return  new WordPairManager(paires);
    }

    private void addSubVocabulary(String name, ArrayList<String[]> wordPaires) throws Exception {
        if (nameIDHashMap.containsKey(name)) {
            throw new Exception("Már létezik ilyen nevű alszotár'");
        } else {
            nameIDHashMap.put(name, nextSubVocabularyID);
            IDSubVocabularyHashMap.put(nextSubVocabularyID, new SubVocabulary(name, languages, wordPaires));
            nextSubVocabularyID++;
        }
    }


}

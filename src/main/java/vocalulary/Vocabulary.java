package vocalulary;

import vocabularyInterfaces.IVocabulary;
import vocabularyInterfaces.IWordPairManager;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by EmerenciaAmarylla on 9/29/2016.
 */
public class Vocabulary implements IVocabulary {
    private ArrayList<Language> languages = new ArrayList<Language>();

    public void createSubVocabulary(FileInputStream excelFile) throws Exception{
        /**Excel file read ...**/
        String name = "TeSt VoCaB1";
        String language1 = "AnGoL";
        String language2 = "MaGyAr";

        ArrayList<String[]> wordPaires = new ArrayList<String[]>();
        wordPaires.add(new String[]{"one", "egy"});
        wordPaires.add(new String[]{"two", "KeTTő"});
        wordPaires.add(new String[]{"tHree", "HÁROM"});
        wordPaires.add(new String[]{"four", "NéGy"});
        wordPaires.add(new String[]{"Five", "öt"});
        wordPaires.add(new String[]{"siX", "hat"});
        wordPaires.add(new String[]{"seven", "hét"});
        wordPaires.add(new String[]{"eIght", "nyolc"});
        wordPaires.add(new String[]{"nine", "KilenC"});
        wordPaires.add(new String[]{"ten", "TiZ"});

        SubVocabularyManager.createSubVocabulary(name ,language1, language2, wordPaires);

        name = "TeSt VoCaB2";
        language1 = "MAGYAR";
        language2 = "angol";

        wordPaires = new ArrayList<String[]>();
        wordPaires.add(new String[]{"ÉN", "I"});
        wordPaires.add(new String[]{"te", "you"});
        wordPaires.add(new String[]{"ö", "he/she/it"});
        wordPaires.add(new String[]{"mI", "wE"});
        wordPaires.add(new String[]{"Ti", "YOU"});
        wordPaires.add(new String[]{"Ök", "ThEy"});


        SubVocabularyManager.createSubVocabulary(name ,language1, language2, wordPaires);

    }

    public void deleteSubVocabulares(Long[] IDs, String language1, String language2) {

    }

    public IWordPairManager getWordPaires(Long[] IDs, String fromLanguage, String toLanguage) throws Exception {
        return SubVocabularyManager.getWordPaires(IDs,fromLanguage,toLanguage, 1.0);
    }

    public IWordPairManager geHardWordPaires(Long[] IDs, String fromLanguage, String toLanguage, double percent) throws Exception {
        return SubVocabularyManager.getWordPaires(IDs,fromLanguage,toLanguage, percent);
    }

    public Set<String> getLanguages() {
        return Language.getLanguages();
    }

    public HashMap<Long, String> getSubVocabularies(String language1, String language2) {
        return SubVocabularyManager.getSubVocabularies(language1,language2);
    }
}

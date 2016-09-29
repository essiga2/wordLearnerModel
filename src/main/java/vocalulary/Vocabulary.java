package vocalulary;

import vocabularyInterfaces.IVocabulary;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by EmerenciaAmarylla on 9/29/2016.
 */
public class Vocabulary implements IVocabulary {
    private ArrayList<Language> languages = new ArrayList<Language>();

    public void createSubVocabulary(FileInputStream excelFile) {
        /**Excel file read ...**/
        String name = "TeSt VoCaB";
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

        SubVocabulary.createSubVocabulary(language1, language2, wordPaires);

    }

    public void deleteSubVocabulary(Long[] IDs, String language1, String language2) {

    }

    public Set<String> getLanguages() {
        return Language.getLanguages();
    }

    public HashMap<Long, String> getSubVocabularies(String language1, String language2) {
        return null;
    }
}

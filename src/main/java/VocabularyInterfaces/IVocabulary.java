package VocabularyInterfaces;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by EmerenciaAmarylla on 9/28/2016.
 */
public interface IVocabulary {

    public void createSubVocabulary(FileInputStream excelFile);

    public void deleteSubVocabulary(Long[] IDs, String language1, String language2);

    public ArrayList<String> getLanguages();

    public HashMap<Long, String> getSubVocabularies(String language1, String language2);


}

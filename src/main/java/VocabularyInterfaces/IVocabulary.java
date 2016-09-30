package vocabularyInterfaces;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by EmerenciaAmarylla on 9/28/2016.
 */
public interface IVocabulary {

    public void createSubVocabulary(FileInputStream excelFile) throws Exception;

    public void deleteSubVocabulares(Long[] IDs, String language1, String language2);

    public IWordPairManager getWordPaires(Long[] IDs, String fromLanguage, String toLanguage) throws Exception;

    public IWordPairManager geHardWordPaires(Long[] IDs, String fromLanguage, String toLanguage, double percent) throws Exception;

    public Set<String> getLanguages();

    public  HashMap<Long, String> getSubVocabularies(String language1, String language2);


}

package vocabularyInterfaces;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by EmerenciaAmarylla on 9/28/2016.
 */
public interface IVocabulary {

    public void createSubVocabulary(FileInputStream excelFile);

    public void deleteSubVocabulary(Long[] IDs, String language1, String language2);

    public Set<String> getLanguages();

    public  HashMap<Long, String> getSubVocabularies(String language1, String language2);


}

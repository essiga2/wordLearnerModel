package vocalulary;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by EmerenciaAmarylla on 9/29/2016.
 */
public class Language {
    private static HashMap<Long, Language> IDlanguageHashMap = new HashMap<Long, Language>();
    private static HashMap<String, Long> nameIdHashMap = new HashMap<String, Long>();
    private static long nextID = 0;

    private String name;

    private Language(String _name) {
        name = _name;

        IDlanguageHashMap.put(nextID, this);
        nameIdHashMap.put(name,nextID);

        nextID++;
    }

    public static Set<String> getLanguages(){
       return nameIdHashMap.keySet();
    }

    public static  String getNameByID(long ID){
       return IDlanguageHashMap.get(ID).name;
    }

    public static long getIDByName(String _name){
        return nameIdHashMap.get(_name);
    }

    protected static Language getLanguageByName(String _name){
        if(!nameIdHashMap.containsKey(_name.toLowerCase())){
            return new Language(_name.toLowerCase());
        }
        return IDlanguageHashMap.get(nameIdHashMap.get(_name.toLowerCase()));
    }
}

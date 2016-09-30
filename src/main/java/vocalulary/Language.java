package vocalulary;


import org.apache.commons.collections.bidimap.AbstractBidiMapDecorator;
import org.apache.commons.collections.bidimap.DualHashBidiMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by EmerenciaAmarylla on 9/29/2016.
 */
public class Language {
    private static HashMap<Long, Language> IDlanguageHashMap = new HashMap<Long, Language>();
    private static HashMap<String, Long> nameIdHashMap = new HashMap<String, Long>();
    private static long nextLanguageID = 0;
    private static long nextWordID = 0;


    private String name;
    private HashMap<Long, String> IDWordHashMap= new HashMap<Long, String>();

    private Language(String _name) {
        name = _name;

        IDlanguageHashMap.put(nextLanguageID, this);
        nameIdHashMap.put(name, nextLanguageID);

        nextLanguageID++;
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

    public long getIDByWord(String _word) throws Exception {
        Iterator it = IDWordHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (((pair.getValue().toString()).equals(_word.toLowerCase()))) {
                return Long.parseLong(pair.getKey().toString());
            }
        }
        IDWordHashMap.put(nextWordID, _word.toLowerCase());
        return nextWordID++;
    }

    public String getWordByID(long _ID) throws Exception {
        return IDWordHashMap.get(_ID);
    }
}

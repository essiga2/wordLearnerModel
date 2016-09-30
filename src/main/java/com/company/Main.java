package com.company;


import vocabularyInterfaces.IWordPairManager;
import vocalulary.Vocabulary;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        Vocabulary testVoc = new Vocabulary();
        try {
            testVoc.createSubVocabulary(null);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Szopo van" + e.getMessage());
        }

        HashMap<Long,String> subVocabs = testVoc.getSubVocabularies("MaGYAR", "AngoL");

        Set<Long> vocabsID = subVocabs.keySet();
        for (Long element :
                vocabsID) {
            Long[] ids = new Long[]{element};
            IWordPairManager manager = testVoc.getWordPaires(ids,"Magyar", "Angol");
            while(manager.hasNext()){
                String[] words = manager.getNext().getWords();
                System.out.println(words[0] +"-" + words[1]);
            }

        }


    }
}

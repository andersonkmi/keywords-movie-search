package org.sharpsw.service;

public class KeywordSearchFactory {
    public enum Version {
        MK_I,
        MK_II
    }

    public static KeywordsSearch build(Version version) {
        if(version == Version.MK_I) {
            return new KeywordsSearchMkI();
        }
        return null;
    }
}

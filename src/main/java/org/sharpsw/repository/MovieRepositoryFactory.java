package org.sharpsw.repository;

public class MovieRepositoryFactory {
    public enum Version {
        MK_I,
        MK_II
    }

    public static MovieRepository build(Version version) {
        if(version == Version.MK_I) {
            return new MovieRepositoryMkI("data");
        }
        return null;
    }
}

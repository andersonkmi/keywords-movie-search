package org.sharpsw.service;

import org.sharpsw.repository.MovieRepository;

import java.io.IOException;
import java.util.Set;

public interface KeywordsSearch {
    Set<String> search(MovieRepository repository, String ... words) throws IOException;
}

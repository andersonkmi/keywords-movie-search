package org.sharpsw.service;

import org.sharpsw.repository.MovieRepository;

import java.io.IOException;
import java.util.*;

public class KeywordsSearch {

    public Set<String> search(MovieRepository repository, String ... words) throws IOException {
        List<String> keywords = Arrays.asList(words);
        Map<String, Set<String>> data = repository.loadData();

        if(verifyKeywordsExist(data, keywords)) {
            return generateSearchResult(data, keywords);
        }
        return new HashSet<>();
    }

    private boolean verifyKeywordsExist(Map<String, Set<String>> data, List<String> keywords) {
        return keywords.stream().allMatch(data::containsKey);
    }

    private Set<String> generateSearchResult(Map<String, Set<String>> data, List<String> keywords) {
        Set<String> elements = new TreeSet<>();
        keywords.stream().map(data::get).forEach(files -> elements.addAll(files));
        return elements;
    }
}

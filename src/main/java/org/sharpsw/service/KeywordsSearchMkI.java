package org.sharpsw.service;

import org.sharpsw.repository.MovieRepository;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class KeywordsSearchMkI implements KeywordsSearch {

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

        Map<String, Integer> filesMap = new HashMap<>();
        keywords.stream().map(data::get).forEach(files -> files.stream().forEach(file -> {
            if(filesMap.containsKey(file)) {
                filesMap.put(file, filesMap.get(file) + 1);
            } else {
                filesMap.put(file, 1);
            }
        }));

        filesMap.entrySet().stream().filter(item -> item.getValue() == keywords.size()).collect(Collectors.toSet()).forEach(tuple -> elements.add(tuple.getKey()));
        return elements;
    }
}

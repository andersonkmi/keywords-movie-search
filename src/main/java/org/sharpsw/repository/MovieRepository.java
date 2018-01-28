package org.sharpsw.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MovieRepository {
    public Map<String, Set<String>> loadFiles(String folder) {
        Map<String, Set<String>> repository = new HashMap<>();

        try {
            Files.list(Paths.get(folder)).forEach(file -> {
                try {
                    Set<String> sentences = getSentences(file);
                    sentences.forEach(word -> {
                        if(repository.containsKey(word)) {
                            repository.get(word).add(file.toString());
                        } else {
                            Set<String> files = new HashSet<>();
                            files.add(file.toString());
                            repository.put(word, files);
                        }
                    });
                } catch (IOException exception) {
                    System.err.println(exception.getMessage());
                }

            });
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

        return repository;
    }

    private Set<String> getSentences(Path file) throws IOException {
        BufferedReader reader = Files.newBufferedReader(file);
        return reader.lines().collect(Collectors.toSet());
    }
}

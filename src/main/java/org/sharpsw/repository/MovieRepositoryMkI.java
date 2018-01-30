package org.sharpsw.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

class MovieRepositoryMkI implements MovieRepository {
    private String folder;

    public MovieRepositoryMkI(String folder) {
        this.folder = folder;
    }

    public Map<String, Set<String>> loadData() throws IOException {
        Map<String, Set<String>> repository = new HashMap<>();

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

        return repository;
    }

    private Set<String> getSentences(Path file) throws IOException {
        BufferedReader reader = Files.newBufferedReader(file);
        Set<String> words = new HashSet<>();
        reader.lines().forEach(line -> {
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                words.add(tokenizer.nextToken().trim());
            }
        });
        return words;
    }
}

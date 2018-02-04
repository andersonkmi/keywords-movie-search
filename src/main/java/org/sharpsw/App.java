package org.sharpsw;

import org.sharpsw.repository.MovieRepositoryFactory;
import org.sharpsw.service.KeywordSearchFactory;
import org.sharpsw.service.KeywordsSearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    public static void main(String[] args) throws IOException {
        if(args.length > 0) {
            StringTokenizer tokenizer = new StringTokenizer(args[0]);
            List<String> tokens = new ArrayList<>();
            while(tokenizer.hasMoreTokens()) {
                tokens.add(tokenizer.nextToken().trim());
            }

            KeywordsSearch service = KeywordSearchFactory.build(KeywordSearchFactory.Version.MK_I);
            Set<String> results = service.search(MovieRepositoryFactory.build(MovieRepositoryFactory.Version.MK_I), tokens.stream().toArray(String[]::new));
            System.out.println("Number of occurences: " + results.size());
            results.forEach(System.out::println);
        } else {
            System.out.println("Missing arguments");
        }
    }
}

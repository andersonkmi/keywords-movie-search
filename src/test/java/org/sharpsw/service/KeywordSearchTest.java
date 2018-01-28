package org.sharpsw.service;

import org.junit.Assert;
import org.junit.Test;
import org.sharpsw.repository.MovieRepositoryFactory;

import java.io.IOException;
import java.util.Set;
import static org.hamcrest.CoreMatchers.is;

public class KeywordSearchTest {

    @Test
    public void testCase001() throws IOException {
        KeywordsSearch service = new KeywordsSearch();
        Set<String> results = service.search(MovieRepositoryFactory.build(MovieRepositoryFactory.Version.MK_I), "walt", "disney");
        Assert.assertThat(results.isEmpty(), is(false));
    }
}

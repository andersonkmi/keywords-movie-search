package org.sharpsw.repository;

import org.junit.Test;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieRepositoryMk1Test {
    @Test
    public void testCase001() throws IOException {
        MovieRepository classUnderTest = new MovieRepositoryMkI("data");
        Map<String, Set<String>> repository = classUnderTest.loadData();
        assertThat(repository.isEmpty(), is(false));
    }
}

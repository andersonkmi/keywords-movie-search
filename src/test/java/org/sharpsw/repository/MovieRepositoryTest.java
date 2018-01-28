package org.sharpsw.repository;

import org.junit.Test;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieRepositoryTest {
    @Test
    public void testCase001() throws IOException {
        MovieRepository classUnderTest = new MovieRepository();
        Map<String, Set<String>> repository = classUnderTest.loadFiles("data");
        assertThat(repository.isEmpty(), is(false));
    }
}

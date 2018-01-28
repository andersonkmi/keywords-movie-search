package org.sharpsw.repository;

import org.junit.jupiter.api.Test;

public class MovieRepositoryTest {
    @Test
    public void testCase001() {
        MovieRepository classUnderTest = new MovieRepository();
        classUnderTest.loadFiles("data");
    }
}

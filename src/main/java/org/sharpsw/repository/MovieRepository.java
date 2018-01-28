package org.sharpsw.repository;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public interface MovieRepository {
    Map<String, Set<String>> loadData() throws IOException;
}

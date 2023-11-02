package hexlet.code.factory;

import java.util.Map;

public interface Parser {
    Map<String, Object> parseToMap(String contentFile) throws Exception;
}

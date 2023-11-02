package hexlet.code.factory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public final class JsonParser implements Parser {
    @Override
    public Map<String, Object> parseToMap(String contentFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(contentFile, new TypeReference<>() {
        });
    }
}

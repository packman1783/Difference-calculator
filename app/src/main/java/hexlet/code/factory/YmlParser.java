package hexlet.code.factory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public final class YmlParser implements Parser {
    @Override
    public Map<String, Object> parseToMap(String contentFile) throws Exception {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(contentFile, new TypeReference<>() {
        });
    }
}

package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parseToMap(String contentFile, String fileFormat) throws Exception {

        switch (fileFormat) {
            case "json" -> {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(contentFile, new TypeReference<>() { });
            }

            case "yml" -> {
                ObjectMapper mapper = new YAMLMapper();
                return mapper.readValue(contentFile, new TypeReference<>() { });
            }
            default -> throw new Exception("Unexpected format: " + fileFormat);
        }
    }
}

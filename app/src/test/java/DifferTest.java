import hexlet.code.Differ;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DifferTest {
    static String expectedJson;
    static String jsonPathFile1;
    static String jsonPathFile2;

    @BeforeAll
    public static void beforeAll() throws Exception {
        jsonPathFile1 = "src/test/resources/file1.json";
        jsonPathFile2 = "src/test/resources/file2.json";
        expectedJson = getContent("src/test/resources/expectedJson.txt");
    }

    public static String getContent(String pathString) throws Exception {
        Path path = Paths.get(pathString);
        return Files.readString(path);
    }

    @Test
    public void testJson() throws Exception {
        String actual = Differ.generate(jsonPathFile1, jsonPathFile2);
        assertThat(actual).isEqualTo(expectedJson);
    }
}

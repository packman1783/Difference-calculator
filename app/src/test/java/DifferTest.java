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
// newline problem for Unix \n and Windows \r\n
        List<String> lines = Files.readAllLines(path);
        return String.join("\n", lines);
    }

    @Test
    public void testJson() throws Exception {
        String actual = Differ.generate(jsonPathFile1, jsonPathFile2);
        System.out.println(expectedJson);
//        String expected = "{\n" +
//                "  - follow: false\n" +
//                "    host: hexlet.io\n" +
//                "  - proxy: 123.234.53.22\n" +
//                "  - timeout: 50\n" +
//                "  + timeout: 20\n" +
//                "  + verbose: true\n" +
//                "}";
        assertThat(actual).isEqualTo(expectedJson);
    }

}

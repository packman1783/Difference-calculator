import hexlet.code.Differ;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {
    static String expectedJson;
    static String expectedYml;
    static String expectedTreeJson;
    static String expectedTreeYml;
    static String jsonPathFile1;
    static String jsonPathFile2;
    static String ymlPathFile1;
    static String ymlPathFile2;
    static String jsonTreePathFile1;
    static String jsonTreePathFile2;
    static String ymlTreePathFile1;
    static String ymlTreePathFile2;

    @BeforeAll
    public static void beforeAll() throws Exception {
        jsonPathFile1 = "src/test/resources/file1.json";
        jsonPathFile2 = "src/test/resources/file2.json";
        expectedJson = getContent("src/test/resources/expectedJson.txt");
        ymlPathFile1 = "src/test/resources/file1.yml";
        ymlPathFile2 = "src/test/resources/file2.yml";
        expectedYml = getContent("src/test/resources/expectedYml.txt");
        jsonTreePathFile1 = "src/test/resources/fileTree1.json";
        jsonTreePathFile2 = "src/test/resources/fileTree2.json";
        expectedTreeJson = getContent("src/test/resources/expectedTreeJson.txt");
        ymlTreePathFile1 = "src/test/resources/fileTree1.yml";
        ymlTreePathFile2 = "src/test/resources/fileTree2.yml";
        expectedTreeYml = getContent("src/test/resources/expectedTreeYml.txt");
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

    @Test
    public void testYml() throws Exception {
        String actual = Differ.generate(ymlPathFile1, ymlPathFile2);
        assertThat(actual).isEqualTo(expectedYml);
    }

    @Test
    public void testTreeJson() throws Exception {
        String actual = Differ.generate(jsonTreePathFile1, jsonTreePathFile2);
        assertThat(actual).isEqualTo(expectedTreeJson);
    }

    @Test
    public void testTreeYml() throws Exception {
        String actual = Differ.generate(ymlTreePathFile1, ymlTreePathFile2);
        assertThat(actual).isEqualTo(expectedTreeYml);
    }
}

import hexlet.code.Differ;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {

    public static String getContent(String pathString) throws Exception {
        Path path = Paths.get(pathString);
        return Files.readString(path);
    }

    @Test
    public void testSimpleJson() throws Exception {
        String jsonPathFile1 = "src/test/resources/file1.json";
        String jsonPathFile2 = "src/test/resources/file2.json";
        String expectedSimpleComparing = getContent("src/test/resources/expectedSimpleComparing.txt");

        String actual = Differ.generate(jsonPathFile1, jsonPathFile2);
        assertThat(actual).isEqualTo(expectedSimpleComparing);
    }

    @Test
    public void testSimpleYml() throws Exception {
        String ymlPathFile1 = "src/test/resources/file1.yml";
        String ymlPathFile2 = "src/test/resources/file2.yml";
        String expectedSimpleComparing = getContent("src/test/resources/expectedSimpleComparing.txt");

        String actual = Differ.generate(ymlPathFile1, ymlPathFile2);
        assertThat(actual).isEqualTo(expectedSimpleComparing);
    }

    @Test
    public void testStylishJson() throws Exception {
        String jsonTreePathFile1 = "src/test/resources/fileTree1.json";
        String jsonTreePathFile2 = "src/test/resources/fileTree2.json";
        String expectedStylish = getContent("src/test/resources/expectedStylish.txt");

        String actual = Differ.generate(jsonTreePathFile1, jsonTreePathFile2, "stylish");
        assertThat(actual).isEqualTo(expectedStylish);
    }

    @Test
    public void testStylishYml() throws Exception {
        String ymlTreePathFile1 = "src/test/resources/fileTree1.yml";
        String ymlTreePathFile2 = "src/test/resources/fileTree2.yml";
        String expectedStylish = getContent("src/test/resources/expectedStylish.txt");

        String actual = Differ.generate(ymlTreePathFile1, ymlTreePathFile2, "stylish");
        assertThat(actual).isEqualTo(expectedStylish);
    }

    @Test
    public void testPlainJson() throws Exception {
        String jsonTreePathFile1 = "src/test/resources/fileTree1.json";
        String jsonTreePathFile2 = "src/test/resources/fileTree2.json";
        String expectedPlain = getContent("src/test/resources/expectedPlain.txt");

        String actual = Differ.generate(jsonTreePathFile1, jsonTreePathFile2, "plain");
        assertThat(actual).isEqualTo(expectedPlain);
    }

    @Test
    public void testPlainYml() throws Exception {
        String ymlTreePathFile1 = "src/test/resources/fileTree1.yml";
        String ymlTreePathFile2 = "src/test/resources/fileTree2.yml";
        String expectedPlain = getContent("src/test/resources/expectedPlain.txt");

        String actual = Differ.generate(ymlTreePathFile1, ymlTreePathFile2, "plain");
        assertThat(actual).isEqualTo(expectedPlain);
    }

    @Test
    public void testJson() throws Exception {
        String jsonTreePathFile1 = "src/test/resources/fileTree1.json";
        String jsonTreePathFile2 = "src/test/resources/fileTree2.json";
        String expectedJson = getContent("src/test/resources/expectedJson.txt");

        String actual = Differ.generate(jsonTreePathFile1, jsonTreePathFile2, "json");
        assertThat(actual).isEqualTo(expectedJson);
    }
}

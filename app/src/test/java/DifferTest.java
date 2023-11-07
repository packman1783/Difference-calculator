import hexlet.code.Differ;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DifferTest {
    static String expectedSimpleComparing;
    static String expectedStylish;
    static String expectedPlain;
    static String expectedJson;


    @BeforeAll
    public static void beforeAll() {
        expectedSimpleComparing = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";


        expectedStylish = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";

        expectedPlain = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";

        expectedJson = "[{\"value1\":[\"a\",\"b\",\"c\"],\"key\":\"chars1\",\"status\":\"unchanged\"},{\"value2" +
                "\":false,\"value1\":[\"d\",\"e\",\"f\"],\"key\":\"chars2\",\"status\":\"changed\"},{" +
                "\"value2\":true,\"value1\":false,\"key\":\"checked\",\"status\":\"changed\"},{\"value2" +
                "\":[\"value1\",\"value2\"],\"value1\":null,\"key\":\"default\",\"status\":\"changed\"},{" +
                "\"value2\":null,\"value1\":45,\"key\":\"id\",\"status\":\"changed\"},{\"value1\":\"value1" +
                "\",\"key\":\"key1\",\"status\":\"deleted\"},{\"value2\":\"value2\",\"key\":\"key2\"," +
                "\"status\":\"added\"},{\"value1\":[1,2,3,4],\"key\":\"numbers1\",\"status\":\"unchanged" +
                "\"},{\"value2\":[22,33,44,55],\"value1\":[2,3,4,5],\"key\":\"numbers2\",\"status\":" +
                "\"changed\"},{\"value1\":[3,4,5],\"key\":\"numbers3\",\"status\":\"deleted\"},{\"value2" +
                "\":[4,5,6],\"key\":\"numbers4\",\"status\":\"added\"},{\"value2\":{\"nestedKey\":\"value\"," +
                "\"isNested\":true},\"key\":\"obj1\",\"status\":\"added\"},{\"value2\":\"Another value\",\"value1" +
                "\":\"Some value\",\"key\":\"setting1\",\"status\":\"changed\"},{\"value2\":300,\"value1\":200,\"key" +
                "\":\"setting2\",\"status\":\"changed\"},{\"value2\":\"none\",\"value1\":true,\"key\":\"setting3\"," +
                "\"status\":\"changed\"}]";
    }

    @Test
    public void testSimpleJson() throws Exception {
        String jsonPathFile1 = "src/test/resources/file1.json";
        String jsonPathFile2 = "src/test/resources/file2.json";

        String actual = Differ.generate(jsonPathFile1, jsonPathFile2);
        assertThat(actual).isEqualTo(expectedSimpleComparing);
    }

    @Test
    public void testSimpleYml() throws Exception {
        String ymlPathFile1 = "src/test/resources/file1.yml";
        String ymlPathFile2 = "src/test/resources/file2.yml";

        String actual = Differ.generate(ymlPathFile1, ymlPathFile2);
        assertThat(actual).isEqualTo(expectedSimpleComparing);
    }

    @Test
    public void testStylishJson() throws Exception {
        String jsonTreePathFile1 = "src/test/resources/fileTree1.json";
        String jsonTreePathFile2 = "src/test/resources/fileTree2.json";

        String actual = Differ.generate(jsonTreePathFile1, jsonTreePathFile2, "stylish");
        assertThat(actual).isEqualTo(expectedStylish);
    }

    @Test
    public void testStylishYml() throws Exception {
        String ymlTreePathFile1 = "src/test/resources/fileTree1.yml";
        String ymlTreePathFile2 = "src/test/resources/fileTree2.yml";

        String actual = Differ.generate(ymlTreePathFile1, ymlTreePathFile2, "stylish");
        assertThat(actual).isEqualTo(expectedStylish);
    }

    @Test
    public void testPlainJson() throws Exception {
        String jsonTreePathFile1 = "src/test/resources/fileTree1.json";
        String jsonTreePathFile2 = "src/test/resources/fileTree2.json";

        String actual = Differ.generate(jsonTreePathFile1, jsonTreePathFile2, "plain");
        assertThat(actual).isEqualTo(expectedPlain);
    }

    @Test
    public void testPlainYml() throws Exception {
        String ymlTreePathFile1 = "src/test/resources/fileTree1.yml";
        String ymlTreePathFile2 = "src/test/resources/fileTree2.yml";

        String actual = Differ.generate(ymlTreePathFile1, ymlTreePathFile2, "plain");
        assertThat(actual).isEqualTo(expectedPlain);
    }

    @Test
    public void testJson() throws Exception {
        String jsonTreePathFile1 = "src/test/resources/fileTree1.json";
        String jsonTreePathFile2 = "src/test/resources/fileTree2.json";

        String actual = Differ.generate(jsonTreePathFile1, jsonTreePathFile2, "json");
        assertThat(actual).isEqualTo(expectedJson);
    }
}

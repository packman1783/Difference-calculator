package hexlet.code.factory;

public final class ParserFactory {
    public Parser getParser(FileType type) {

        return switch (type) {
            case JSON -> new JsonParser();
            case YML -> new YmlParser();
        };
    }
}



package hexlet.code.factory;

public final class ParserFactory {
    public Parser getParser(FileType type) throws Exception {
        Parser parser;

        switch (type) {
            case JSON:
                parser = new JsonParser();
                break;
            case YML:
                parser = new YmlParser();
                break;
            default:
                throw new Exception("Unexpected type: " + type);
        }

        return parser;
    }
}



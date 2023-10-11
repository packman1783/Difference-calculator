package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "Compares two configuration files and shows a difference."
)

public class App implements Runnable {
    @Parameters(
            index = "0",
            paramLabel = "filepath1",
            description = "path to first file"
    )
    private String filepath1;

    @Parameters(
            index = "1",
            paramLabel = "filepath2",
            description = "path to second file"
    )
    private String filepath2;

    @Option(
            names = {"-f", "--format"},
            defaultValue = "stylish",
            paramLabel = "format",
            description = "output format [default: stylish]"
    )
    private String format;

    @Option(
            names = {"-h", "--help"},
            usageHelp = true,
            description = "Show this help message and exit."
    )
    private boolean helpRequested;

    @Option(
            names = {"-v", "--version"},
            versionHelp = true,
            description = "Print version information and exit."
    )
    private boolean versionRequested;

    @Override
    public void run() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}

### Hexlet tests and linter status:
[![Actions Status](https://github.com/packman1783/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/packman1783/java-project-71/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/a74e4cd2fc529f000cf5/maintainability)](https://codeclimate.com/github/packman1783/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/a74e4cd2fc529f000cf5/test_coverage)](https://codeclimate.com/github/packman1783/java-project-71/test_coverage)

## Description:
Application find difference between two json, yml files.
Output support formats: stylish(default), plate.

### Use:
The difference between files can be displayed in different ways:
 * format plain:    
./app --format plain path/to/file.yml another/path/file.json
 * format stylish:    
./app filepath1.json filepath2.json

 for example:
```
$ ./build/install/app/bin/app -f json src/test/resources/fileTree1.json src/test/resources/fileTree2.json 

```

**Asciinema default comparing .json files**
[![asciicast](https://asciinema.org/a/614631.svg)](https://asciinema.org/a/614631)

**Asciinema default comparing .yml files**
[![asciicast](https://asciinema.org/a/616643.svg)](https://asciinema.org/a/616643)

**Asciinema "stylish" comparing nested json, nested yml files**  
[![asciicast](https://asciinema.org/a/616996.svg)](https://asciinema.org/a/616996)

**Asciinema "plain" comparing nested json, yml files**
[![asciicast](https://asciinema.org/a/617098.svg)](https://asciinema.org/a/617098)

**Asciinema "json" comparing nested json, yml files**
[![asciicast](https://asciinema.org/a/617242.svg)](https://asciinema.org/a/617242)

## External libraries

This project includes forked external libraries that GWT uses. 

### Guava 33.0-rebased
GWT uses a rebased Guava build, to ensure that the compiler classpath doesn't clash with any Guava version
that is part of the application being built.

### Closure-compiler's sourcemap library
GWT uses a subset of the Closure-compiler's sourcemap library to support source maps in compiled output.

### Protobuf-java 2.5.0-rebased
GWT's legacy dev mode uses a very old build of protobuf, rebased to ensure it doesn't conflict with other dependencies.

### Android JSON
A rebased version of org.json from Android is used in several places in GWT.

### Closure-stylesheets
GWT uses a rebased build of closure-stylesheets for CSS processing.

### Stream HTML Parser
GWT uses a rebased version of the Stream HTML Parser for templates.

### Flute w3c CSS parser
GWT uses the Flute w3c CSS parser for CSS processing, not released elsewhere in maven.

### ant-zipscanner
GWT uses a subset of Ant's core library for scanning zip files

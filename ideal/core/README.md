Minimal dependencies to compile a GWT project. This necessarily requires
javaemul to simulate various aspects of the JVM, java emulation, and parts of the
com.google.gwt.core.Core. There are interdependencies between these, so they should
probably be merged into one single project:

 * java.lang.Object depends on com.google.gwt.core.client.JavaScriptObject - this means we can't split Core from the simplest parts of the JRE
 * Object also depends on java.lang.SuppressWarnings - this means we can't split the "how does the language works" parts of the JRE easily from the rest of the JRE.
 * Object also depends on javaemul.internal.HashCodes - this means we can't separate javaemul internal packages from JRE emulation

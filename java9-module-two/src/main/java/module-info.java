module module.two {
    requires module.one;

    // jdeps for this module
    // jdeps --module-path ~/.m2/repository/org/apache/commons/commons-lang3/3.9/commons-lang3-3.9.jar:../../java9-module-one/target/java9-module-one-1.0-SNAPSHOT.jar \
    // -s java9-module-two-1.0-SNAPSHOT.jar
}
module module.one {
    // clients will not have to require again
    // this is using automatic-module
    requires transitive org.apache.commons.lang3;

    // you can generate the module-info with:
    //jdeps -verbose:class --generate-module-info . ~/.m2/repository/org/apache/commons/commons-lang3/3.9/commons-lang3-3.9.jar
    // cat org.apache.commons.lang3/module-info.java

    // after compile you can use jdeps to check your modules dependency
    // jdeps --module-path ~/.m2/repository/org/apache/commons/commons-lang3/3.9/commons-lang3-3.9.jar -s java9-module-one-1.0-SNAPSHOT.jar

    exports java9.module.exported;

    // or restrict which modules have access
//    exports java9.module.exported to module.two;
}
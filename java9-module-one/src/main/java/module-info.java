module module.one {
    // clients will not have to require again
    requires transitive org.apache.commons.lang3;

    exports java9.module.exported;

    // or restrict which modules have access
//    exports java9.module.exported to module.two;
}
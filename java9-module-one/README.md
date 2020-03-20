## java-9

**PS: compile the project with maven first**

### Modules description

* java9-module-two - requires
* java9-module-one - exports

```bash
$ jar -f java9-module-one/target/java9-module-one-1.0-SNAPSHOT.jar -d
$ jar -f java9-module-two/target/java9-module-two-1.0-SNAPSHOT.jar -d
```
 
### Modules dependency

```bash
$ jdeps --module-path ~/.m2/repository/org/apache/commons/commons-lang3/3.9/commons-lang3-3.9.jar -s java9-module-one/target/java9-module-one-1.0-SNAPSHOT.jar
$ jdeps --module-path ~/.m2/repository/org/apache/commons/commons-lang3/3.9/commons-lang3-3.9.jar:java9-module-one/target/java9-module-one-1.0-SNAPSHOT.jar -s java9-module-two/target/java9-module-two-1.0-SNAPSHOT.jar
```

### jlink

Let's use `jlink` to create a small version of java with only the modules that are required in this project.
In order to use `jlink`, all modules should be _modularized_.  
`commons-lang3` needs to be _modularize_ manually.
Since there's many steps for this check the script [java9-module-build.sh](../java9-module-build.sh)

Run the script and follow the steps. _Make sure you are on the project root folder_.
```bash
$ java9-module-build.sh
```

Compare the regular and the custom `java` size at the end:

Regular:
```bash
$ java --list-modules
```

Custom:
```bash
$ ./java9-target/build/bin/java --list-modules
```

package java9.module.two;

import java9.module.exported.FirstModule;
import org.apache.commons.lang3.StringUtils;

/**
 * jar -f java9-module-one/target/java9-module-one-1.0-SNAPSHOT.jar -d
 * jar -f java9-module-two/target/java9-module-two-1.0-SNAPSHOT.jar -d
 *
 * To execute from the console:
 *
 * $ java -p java9-module-one/target/java9-module-one-1.0-SNAPSHOT.jar:java9-module-two/target/java9-module-two-1.0-SNAPSHOT.jar:$HOME/.m2/repository/org/apache/commons/commons-lang3/3.9/commons-lang3-3.9.jar \
 *  -m module.two/java9.module.two.SecondModule
 *
 *   -m module.two/java9.module.two.SecondModule
 */
public class SecondModule {
    public static void main(String[] args) {

        System.out.println("main @ " + SecondModule.class.getModule());

        FirstModule firstModule = new FirstModule();

        System.out.println(firstModule.getInfo());


        System.out.println(
            StringUtils.trim("Testing 'requires transitive org.apache.commons.lang3;'")
        );
    }
}

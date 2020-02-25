package java9.module.exported;


import org.apache.commons.lang3.StringUtils;

/**
 * Tips:
 *
 * java --list-modules
 *
 * java -p <module path> -m <MODULENAME>/org.example.module2.FirstModule
 * jar -f
 */
public class FirstModule {

    public String getInfo() {
        return StringUtils.trim("getInfo @ " + FirstModule.class.getModule());

    }

    public static void main(String[] args) {
        System.out.println(new FirstModule().getInfo());
    }

}

package java9.module.close;

public class NotVisible {

    public String getInfo() {
        return "getInfo @ " + NotVisible.class.getModule();
    }

}

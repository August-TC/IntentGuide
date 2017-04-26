package technetium.intentappactivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by August-Tancheng on 2017/4/14.
 */

public class Website {

    private String name;
    private String address;

    public static List<Website>websites = new ArrayList<>();

    public Website(String name,String address)
    {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public static void addWebsite(Website website)
    {
        websites.add(website);
    }
}

package project;

import java.util.HashMap;
public class IDandPassword {

    HashMap<String, String> logininfor = new HashMap<String, String>();
    IDandPassword(){
        logininfor.put("admin","admin");
        logininfor.put("a", "b");
    }
  protected HashMap getinfor(){
        return logininfor;
    }
}


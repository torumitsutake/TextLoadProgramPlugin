package com.gmail.sitoa.TextLoadProgram;

import java.io.*;
import java.util.Properties;

/**
 * Created by torumitsutake on 2017/03/06.
 */
public class FileLoadManager {
    private  static FileLoadManager instance = new FileLoadManager();
    public  Properties property = new Properties();
    public  int fileamount = 0;
    public  int nowfileindex = 1;
    public  File nowFile = null;


    FileLoadManager(){
        propertiesload();


    }




public boolean propertiesload() {
    try {
        File propertyfile = new File("properties/textlist.properties");
        InputStreamReader isr = new InputStreamReader(new FileInputStream(propertyfile), "UTF-8");
        BufferedReader reader = new BufferedReader(isr);
        System.out.println(System.getProperty("file.encording"));

        property.load(reader);

        fileamount = Integer.parseInt(property.getProperty("fileamount"));

        System.out.println("PropertyLoad!");

        System.out.println("fileamount:"+fileamount);
        fileload(1);

    return  true;
    } catch (IOException e){
        e.printStackTrace();
        return false;
    }

}
public  Properties getProperty(){
    return property;
}

public static FileLoadManager getInstance(){
    return instance;
}

public File fileload(int index){
    if(index > fileamount){
        System.out.println("OutOfFileIndex");
    }
    String key = "File"+nowfileindex;
    String filepath = property.getProperty(key);
    System.out.println(filepath);
    File loadfile = new File(filepath);
    nowfileindex = index;
    nowFile = loadfile;
    System.out.println("Fileload!");
    return loadfile;
}
public File getnowFile(){
    return nowFile;
}

public void nextFile(){
    nowfileindex++;
    fileload(fileamount);
}







}

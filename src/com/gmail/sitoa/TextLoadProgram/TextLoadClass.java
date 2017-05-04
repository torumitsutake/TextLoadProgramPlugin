package com.gmail.sitoa.TextLoadProgram;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by torumitsutake on 2017/03/06.
 */
public class TextLoadClass {
    private File usedFile ;
    public ArrayList<String> lines = new ArrayList<String>();
    public int nowindex = 0;
    public TextLoadClass(){

        System.setProperty("file.encoding", "UTF-8");

        newFileLoad();
    }

    public  String next(){
        nowindex++;
        if(nowindex >= lines.size()){
            FileLoadManager FLM = FileLoadManager.getInstance();
            FLM.nextFile();

            newFileLoad();
        }
        return  lines.get(nowindex);
    }
    public ArrayList<String> getLines(){
        return  lines;
    }

    public void newFileLoad(){

        FileLoadManager FLM = FileLoadManager.getInstance();
        nowindex = 0;
        usedFile = FLM.getnowFile();
        lines.clear();
        try {

            InputStreamReader filereader = new InputStreamReader(new FileInputStream(usedFile), "UTF-8");

            BufferedReader br = new BufferedReader(filereader);
            String str = "";
            while(str != null){
                System.out.println(str);
                lines.add(str);
                str = br.readLine();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }



}


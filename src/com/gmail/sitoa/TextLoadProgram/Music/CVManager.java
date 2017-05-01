package com.gmail.sitoa.TextLoadProgram.Music;

import javax.sound.sampled.Clip;

/**
 * Created by torumitsutake on 2017/03/07.
 */
public class CVManager {
    private static CVManager instance = new CVManager();
    public static Clip nowCV ;


    public void playCV(String path){
        if(nowCV !=null){
            nowCV.stop();
        }
        CVPlayClass CPC = new CVPlayClass(path);
        nowCV = CPC.getCV();
    }


    public static CVManager getInstance(){
        return instance;
    }

}

package com.gmail.sitoa.TextLoadProgram.Music;

import javax.sound.sampled.Clip;

/**
 * Created by torumitsutake on 2017/03/08.
 */
public class SEManager {
    private static SEManager instance = new SEManager();
    public static Clip nowSE ;


    public void playSE(String path){
        if(nowSE !=null){
            nowSE.stop();
        }
        SEPlayClass SPC = new SEPlayClass(path);
        nowSE = SPC.getSE();
    }


    public static SEManager getInstance(){
        return instance;
    }
}

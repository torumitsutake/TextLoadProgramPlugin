package com.gmail.sitoa.TextLoadProgram.Music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by torumitsutake on 2017/03/08.
 */
public class BGMusicManager {
    private static BGMusicManager instance = new BGMusicManager();
    public static Clip nowBGM ;


    public void setBGM(String path){
        if(nowBGM !=null){
            nowBGM.stop();
        }
        BGMusicPlayClass BPC = new BGMusicPlayClass(path);
        nowBGM = BPC.getBGM();
    }

    public void BGMStop(){
        if(nowBGM !=null){
        nowBGM.stop();
    }
    }


    public static BGMusicManager getInstance(){
    return instance;
    }

}

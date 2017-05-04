package com.gmail.sitoa.TextLoadProgram.Music;

import javafx.scene.media.AudioClip;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by torumitsutake on 2017/03/08.
 */
public class BGMusicManager {
    private static BGMusicManager instance = new BGMusicManager();
    public static Clip nowBGM ;
    int frameposition = 0;


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
    public void BGMPause(){
        if(nowBGM !=null){
            frameposition = nowBGM.getFramePosition();
            nowBGM.stop();
        }
    }
    public void BGMRE(){
        if(nowBGM !=null){
            nowBGM.setFramePosition(frameposition);
            nowBGM.loop(nowBGM.LOOP_CONTINUOUSLY);

        }
    }
    public void BGMFade(){
        if(nowBGM !=null){
            FadeThread FT =  new FadeThread(nowBGM);
            FT.start();
        }
    }


    public static BGMusicManager getInstance(){
    return instance;
    }



}

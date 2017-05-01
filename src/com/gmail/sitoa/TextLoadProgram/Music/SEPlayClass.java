package com.gmail.sitoa.TextLoadProgram.Music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by torumitsutake on 2017/03/08.
 */
public class SEPlayClass implements LineListener{
    Clip SE ;
    AudioInputStream audioInputStream;




    public SEPlayClass(String path){
        File audioFile = new File(path);
        try {
            audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            SE = (Clip)AudioSystem.getLine(info);
            SE.addLineListener(this);

            SE.open(audioInputStream);
            SE.setFramePosition(0);
            SE.start();
            audioInputStream.close();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }


    }
    public Clip getSE(){
        return SE;
    }

    public void stop(){
        SE.stop();
    }

    @Override
    public void update(LineEvent event) {
        if (event.getType() == LineEvent.Type.STOP) {
            Clip clip = (Clip) event.getSource();
            clip.stop();
            clip.setFramePosition(0); // 再生位置を最初に戻す
        }
    }
}

package com.gmail.sitoa.TextLoadProgram.Music;

import javafx.scene.media.AudioClip;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;

/**
 * Created by torumitsutake on 2017/03/07.
 */
public class CVPlayClass  implements LineListener{
   Clip CV ;
    AudioInputStream audioInputStream;


    public void run(){
        CV.start();

    }

    public CVPlayClass(String path){
        File audioFile = new File(path);
        try {
            audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            CV = (Clip)AudioSystem.getLine(info);
            CV.addLineListener(this);

            CV.open(audioInputStream);
            CV.setFramePosition(0);
            audioInputStream.close();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }


    }
    public Clip getCV(){
        return CV;
    }

    public void stop(){
        CV.stop();
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

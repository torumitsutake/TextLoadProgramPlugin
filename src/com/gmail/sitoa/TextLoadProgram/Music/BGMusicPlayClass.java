package com.gmail.sitoa.TextLoadProgram.Music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by torumitsutake on 2017/03/08.
 */
public class BGMusicPlayClass implements LineListener {
    Clip BGM ;
    AudioInputStream audioInputStream;




    public BGMusicPlayClass(String path){
        File audioFile = new File(path);
        try {
            audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
            BGM = (Clip)AudioSystem.getLine(info);
            BGM.addLineListener(this);

            BGM.open(audioInputStream);
            BGM.setFramePosition(0);
            BGM.loop(1000);
            audioInputStream.close();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }


    }
    public Clip getBGM(){
        return BGM;
    }

    public void stop(){
        BGM.stop();
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

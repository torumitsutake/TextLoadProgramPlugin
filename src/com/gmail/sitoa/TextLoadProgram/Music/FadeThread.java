package com.gmail.sitoa.TextLoadProgram.Music;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 * Created by torumitsutake on 2017/05/03.
 */
public class FadeThread extends Thread {
    Clip nowBGM;
    FadeThread(Clip now){
        nowBGM = now;
    }


   public void run(){

        for(int i=10;i>=0;i--) {
            FloatControl control = (FloatControl) nowBGM.getControl(FloatControl.Type.MASTER_GAIN);
            controlByLinearScalar(control, i/10);

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nowBGM.stop();

    }

    private void controlByLinearScalar(FloatControl control, double linearScalar) {
        control.setValue((float)Math.log10(linearScalar) * 20);
    }
}

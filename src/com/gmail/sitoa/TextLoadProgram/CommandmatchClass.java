package com.gmail.sitoa.TextLoadProgram;

import com.gmail.sitoa.TextLoadProgram.Music.BGMusicManager;
import com.gmail.sitoa.TextLoadProgram.Music.CVManager;
import com.gmail.sitoa.TextLoadProgram.Music.SEManager;

/**
 * Created by torumitsutake on 2017/03/06.
 */
public class CommandmatchClass {
    String line = "";
    String cmd = "";
    String option ="";
    public CommandmatchClass(String line){
        this.line = line;
        separate();

    }



    public void separate(){
        if(line.matches(".*:.*")){
            String[] words = line.split(":",2);

            cmd = words[0];
            option = words[1];
        }

    }

    public String getOption(){
        return option;
    }


    public String getCmd() {
        System.out.println(cmd);
        //コマンド部分が人以外の時
        if (cmd.equalsIgnoreCase("Font")) {


            return line;
        }else
        if (cmd.equalsIgnoreCase("BLACKOUT")) {


            return "Blackout";
        }else
        if (cmd.equalsIgnoreCase("BGMSTOP")) {

            BGMusicManager BGMManager = BGMusicManager.getInstance();
            BGMManager.BGMStop();

            return "BGMStop";
        } else if (cmd.equalsIgnoreCase("BGM")) {
            BGMusicManager BGMManager = BGMusicManager.getInstance();
            BGMManager.setBGM(option);
            return "BGM";

        } else if (cmd.equalsIgnoreCase("BGP")) {


            return "BGP";
        } else if (cmd.equalsIgnoreCase("PAUSE")) {

            return "PAUSE";
        } else if (cmd.equalsIgnoreCase("SELECT")) {

            return "SELECT";
        } else if (cmd.equalsIgnoreCase("SE")) {
            SEManager SEM = SEManager.getInstance();
            SEM.playSE(option);


            return "SE";
        } else if (cmd.equalsIgnoreCase("CV")) {

            CVManager CVM = CVManager.getInstance();
            CVM.playCV(option);

            return "CV";
        } else {

            //コマンド部分がコマンドではない（人名が入る)場合通常のテキスト処理
            return cmd;
        }
    }


}

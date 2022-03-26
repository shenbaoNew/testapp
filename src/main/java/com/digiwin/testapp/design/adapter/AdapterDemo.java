package com.digiwin.testapp.design.adapter;

/**
 * FileName:AdapterDemo
 * Author: shenbao
 * Date: 2022/3/26 21:39
 * Description:
 */
public class AdapterDemo {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new AudioPlayer();
        mediaPlayer.play("中国心.mp3");
        mediaPlayer.play("月亮.vlc");
        mediaPlayer.play("心上人.mp4");
    }
}

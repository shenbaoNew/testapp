package com.digiwin.testapp.design.adapter;

/**
 * FileName:VlcPlayer
 * Author: shenbao
 * Date: 2022/3/26 21:35
 * Description:
 */
public class Mp4Player implements AdvanceMediaPlayer {
    @Override
    public void playVlc(String fileName) {
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println(String.format("play mp4 %s ...", fileName));
    }
}

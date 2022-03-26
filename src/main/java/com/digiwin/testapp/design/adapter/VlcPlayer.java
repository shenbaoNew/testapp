package com.digiwin.testapp.design.adapter;

/**
 * FileName:VlcPlayer
 * Author: shenbao
 * Date: 2022/3/26 21:35
 * Description:
 */
public class VlcPlayer implements AdvanceMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println(String.format("play vlc %s ...", fileName));
    }

    @Override
    public void playMp4(String fileName) {

    }
}

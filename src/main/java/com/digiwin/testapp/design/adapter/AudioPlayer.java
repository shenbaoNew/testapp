package com.digiwin.testapp.design.adapter;

/**
 * FileName:AudioPlayer
 * Author: shenbao
 * Date: 2022/3/26 21:34
 * Description:
 */
public class AudioPlayer implements MediaPlayer {
    private MediaAdapter adapter;

    @Override
    public void play(String fileName) {
        if (fileName.endsWith(".mp3")) {
            System.out.println(String.format("play mp3 %s ...", fileName));
        } else {
            adapter = new MediaAdapter(fileName);
            adapter.play(fileName);
        }
    }
}

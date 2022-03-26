package com.digiwin.testapp.design.adapter;

/**
 * FileName:MediaAdapter
 * Author: shenbao
 * Date: 2022/3/26 21:42
 * Description:
 */
public class MediaAdapter implements MediaPlayer {
    AdvanceMediaPlayer advanceMediaPlayer;

    public MediaAdapter(String fileName) {
        if (fileName.endsWith(".vlc")) {
            advanceMediaPlayer = new VlcPlayer();
        } else if (fileName.endsWith(".mp4")) {
            advanceMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String fileName) {
        if (advanceMediaPlayer instanceof VlcPlayer) {
            advanceMediaPlayer.playVlc(fileName);
        } else if (advanceMediaPlayer instanceof Mp4Player) {
            advanceMediaPlayer.playMp4(fileName);
        }
    }
}

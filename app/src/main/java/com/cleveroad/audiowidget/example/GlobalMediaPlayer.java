package com.cleveroad.audiowidget.example;

import android.media.AudioManager;
import android.media.MediaPlayer;

/**
 * Created by sandip on 2/24/2017.
 */

public class GlobalMediaPlayer {

    private MediaPlayer mediaPlayer = new MediaPlayer();

    public MediaPlayer getMediaPlayer() {
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        return mediaPlayer;
    }
}

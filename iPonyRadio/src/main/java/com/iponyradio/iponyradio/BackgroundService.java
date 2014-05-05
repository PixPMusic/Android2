package com.iponyradio.iponyradio;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.os.PowerManager;
import java.io.IOException;

public class BackgroundService extends Service implements MediaPlayer.OnPreparedListener {

    // Fields
    // Stream Related
    private String currentStreamUrl;
    private boolean isPlaying;

    // Notification Stuff
    private String streamTitle;
    private String artist;
    private String song;
    private String coverURL;
    private String notificationTitle;
    private String notificationBody;

    // More MediaPlayer and WifiLock stuff
    private MediaPlayer m;
    private WifiManager.WifiLock wifiLock = ((WifiManager) getSystemService(Context.WIFI_SERVICE))
            .createWifiLock(WifiManager.WIFI_MODE_FULL, "mylock");
    private Boolean wifiLocked;

    public BackgroundService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    // Accessor Methods

    /**
     * Sets Playing variable to true
     */
    public void setPlaying() {
        isPlaying = true;
    }

    /**
     * Sets Playing variable to False
     */
    public void setStopped() {
        isPlaying = false;
    }

    /**
     * @return Playining Variable as Boolean
     */
    public boolean checkPlaying() {
        return isPlaying;
    }

    /**
     * Change the Stream URL and restart the stream if it's running
     * @param url
     */
    public void setCurrentStreamUrl(String url) throws IOException {
        currentStreamUrl = url;
        restartWithNewURL();
    }

    /**
     * @return the current Stream URL
     */
    public String checkURL() {
        return currentStreamUrl;
    }

    /**
     * Enables Wifi Lock and sets
     * wifiLocked boolean true
     */
    public void lockWifi() {
        if (!checkWifiLock()) {
            wifiLock.acquire();
            wifiLocked = true;
        }
    }

    /**
     * Disables Wifi Lock and
     * Sets wifiLocked boolean false
     */
    public void unlockWifi() {
        if (checkWifiLock()) {
            wifiLock.release();
            wifiLocked = false;
        }
    }

    /**
     * returns the value of boolean wifiLocked
     */
    public boolean checkWifiLock() {
        return wifiLocked;
    }

    /**
     * Toggles MainActivity/Pause state
     */
    public void togglePlayPause() throws IOException {
        if (checkPlaying()) {
            pause();
        } else {
            play();
        }
    }

    /**
     * Stops the Media Player
     */
    public void stopPlaying() {
        if (checkPlaying()) {
            stop();
        }
    }

    /**
     * Check player state and kill the mediaplayer
     */
    public void killMedia() {
        if (isPlaying) {
            stop();
        }
        destroy();
    }


    // Private Methods

    /**
     * Restarts the Stream
     * (Called by <code>setCurrentStreamURL()</code>
     */
    private void restartWithNewURL() throws IOException {
        if (checkPlaying()) {
            stop();
        }
        play();
    }

    private void play() throws IOException {
        if (!checkPlaying()) {
           setPlaying();
        }
        m.setAudioStreamType(AudioManager.STREAM_MUSIC);
        m.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        lockWifi();
        m.setDataSource(currentStreamUrl);
        m.setOnPreparedListener(this);
        m.prepareAsync();
    }

    private void stop() {
        if (checkPlaying()) {
            m.stop();
            wifiLock.release();
        }
    }

    private void pause() {
        if (checkPlaying()) {
            m.pause();
        }
    }

    private void destroy() {
        if (checkPlaying()) {
            stop();
        }
        m.release();
        m = null;
        unlockWifi();
    }


    // Public Methods

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }
}

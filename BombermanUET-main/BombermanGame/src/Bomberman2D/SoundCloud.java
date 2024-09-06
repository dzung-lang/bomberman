package Bomberman2D;

import javax.sound.sampled.*;
import java.net.URL;

public class SoundCloud {
    Clip clip;
    URL soundURL[] = new URL[10];
    FloatControl fc;
    int volumeScale = 5;
    float volume;
    public SoundCloud() {
        soundURL[0] = getClass().getResource("/sound/res_sound_bomb_explosion.wav");
        soundURL[1] = getClass().getResource("/sound/res_sound_just_died.wav");
        soundURL[2] = getClass().getResource("/sound/res_sound_title_screen.wav");
        soundURL[3] = getClass().getResource("/sound/coin.wav");
        soundURL[4] = getClass().getResource("/sound/powerup.wav");
    }
    public void setFile(int i){
        try{
            AudioInputStream ip = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ip);
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            checkVolume();
        }catch (Exception e){

        }
    }
    public void playing(){
        clip.start();
    }
    public void Loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stopPlay() {
        try {
            clip.stop();
        } catch (NullPointerException e) {

        }
    }
    public void checkVolume() throws NullPointerException {
        switch (volumeScale) {
            case 0: volume = -80f; break;
            case 1: volume = -20f; break;
            case 2: volume = -12f; break;
            case 3: volume = -5f; break;
            case 4: volume = 1f; break;
            case 5: volume = 6f; break;
        }
        if(fc != null) {
            fc.setValue(volume);
        }
    }
}

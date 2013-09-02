package com.bing.support.chimeinnight; 
 
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
 
//http://www.itniwo.net/docu/v/245074.html
//http://www.jameselsey.co.uk/blogs/techblog/android-a-really-easy-tutorial-on-how-to-use-text-to-speech-tts-and-how-you-can-enter-text-and-have-it-spoken/
/**
 * This class demonstrates checking for a TTS engine, and if one is
 * available it will spit out some speak.
 */
public class SpeakService extends Service implements TextToSpeech.OnInitListener
{
    private TextToSpeech mTts;
    // This code can be any value you want, its just a checksum.
    private static final int MY_DATA_CHECK_CODE = 1234;
 
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate()
    {
        super.onCreate();
        // Fire off an intent to check if a TTS engine is installed
        mTts = new TextToSpeech(this, this);
        onInit(1);
    }
 
    /**
     * Executed when a new TTS is instantiated. Some static text is spoken via TTS here.
     * @param i
     */
    public void onInit(int i)
    {
        mTts.speak("Hello folks, welcome to my little demo on Text To Speech.",
                TextToSpeech.QUEUE_FLUSH,  // Drop all pending entries in the playback queue.
                null);
    }
 
 
 
    /**
     * Be kind, once you've finished with the TTS engine, shut it down so other
     * applications can use it without us interfering with it :)
     */
    @Override
    public void onDestroy()
    {
        // Don't forget to shutdown!
        if (mTts != null)
        {
            mTts.stop();
            mTts.shutdown();
        }
        super.onDestroy();
    }

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
}
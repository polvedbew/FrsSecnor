import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javax.speech.Central;
import javax.speech.EngineException;

/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 27/10/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/


//    https://chromium.googlesource.com/chromiumos/third_party/espeak-ng/+/HEAD/docs/mbrola.md

//    https://github.com/numediart/MBROLA-voices
public class TTS_Mbrola {
    private static Voice freettsVoice;
    static {
        VoiceManager freettsVM;
      //  System.setProperty("mbrola.base", "/usr/share/mbrola");
        System.setProperty("freetts.voices","com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        try {
            Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
        } catch (EngineException e) {
            throw new RuntimeException(e);
        }

        freettsVM = VoiceManager.getInstance();
        freettsVoice = freettsVM.getVoice("kevin16");
        System.out.println("pitch :"+freettsVoice.getPitch()
                +"     volume :"+freettsVoice.getVolume()
                +" pitch range :"+freettsVoice.getPitchRange()
                +"   pitch shift :"+freettsVoice.getPitchShift());

        freettsVoice.allocate();
        freettsVoice.setRate(130);
        freettsVoice.setPitch(190f);
        freettsVoice.setVolume(4000);
        freettsVoice.setPitchRange(13);
        freettsVoice.setPitchShift(1.1f);
        freettsVoice.setStyle("casual");



    }


    public static void doSpeak(String str){
      //  sayHi();
        freettsVoice.speak(str);
    }
    private static void sayHi(){
        //freettsVoice.setDurationStretch(.95f);
        freettsVoice.speak("hai");
    }
}

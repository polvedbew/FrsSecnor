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
        //System.setProperty("mbrola.base", "/home/harsh/IdeaProjects/FrsSecnor/data");
        System.setProperty("freetts.voices","com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        try {
            Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
        } catch (EngineException e) {
            throw new RuntimeException(e);
        }

        freettsVM = VoiceManager.getInstance();
        freettsVoice = freettsVM.getVoice("kevin16");
        freettsVoice.allocate();
    }


    public static void doSpeak(String str){
        freettsVoice.speak(str);
    }
}

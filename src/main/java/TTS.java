import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Voice;
import java.beans.PropertyVetoException;
import java.util.Locale;

/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 27/10/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/
public class TTS {
    private static Synthesizer synthesizer = null;
    static{
        System.setProperty("freetts.voices","com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        try {
            Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
        } catch (EngineException e) {
            throw new RuntimeException(e);
        }

        SynthesizerModeDesc desc = new SynthesizerModeDesc(null,"general",  Locale.US,null,null);
       // Synthesizer synthesizer = null;//if(true)return;
        try {
            synthesizer = Central.createSynthesizer(desc);
        } catch (EngineException e) {
            throw new RuntimeException(e);
        }
        desc = (SynthesizerModeDesc)  synthesizer.getEngineModeDesc();
        try {
            synthesizer.allocate();
           // synthesizer.getSynthesizerProperties().setSpeakingRate(130);
           // synthesizer.getSynthesizerProperties().setPitch(180f);

        } catch (EngineException eee) {
            throw new RuntimeException("ee");
        }
        Voice[] voices = desc.getVoices();

        try {
            synthesizer.getSynthesizerProperties().setVoice(voices[1]);
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }


    }

    public static void doSpeak(String str){
        System.out.println("received string on TTS "+str);
        try {

            synthesizer.resume();
            synthesizer.speakPlainText(str, null);
            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
            synthesizer.pause();
            //synthesizer.deallocate();
        }catch ( Exception ee){
            System.out.println(ee);
        }
    }

}

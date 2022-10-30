import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Voice;
import java.util.Locale;

public class MqttClbk  implements MqttCallback {
    MainInterfaceControllerFinal ctrl;
    private static PollyDemo polly;
    public MqttClbk(MainInterfaceControllerFinal ctrl,final PollyDemo polly){
        this.ctrl=ctrl;
        this.polly=polly;

        try{


        }catch (Exception e){
            //
        }


    }

    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        try {
            String rcv = new String(mqttMessage.getPayload());
            String name = rcv.substring(rcv.indexOf("PersonName") + 11, rcv.indexOf("FaceImgPath") - 3);

            System.out.println(name + "  Message received:\n\t" + rcv);
            ctrl.setHiText(name);
            //TTS_Mbrola.doSpeak("Hi, "+name+"   \n welcome to norden \n nice to meet you.");
           // CommandTTS.doSpeak(name);
            if(name.contains(":nul")){
                name = "friend";
            }
            polly.playNow(FeedBackStrings.preSpeech+name+",, , "+ FeedBackStrings.postSpeech);
        }catch (Exception e){
            //
        }
        // System.out
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        // not used in this example
    }


}
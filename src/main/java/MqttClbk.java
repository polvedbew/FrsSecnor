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
    public MqttClbk(MainInterfaceControllerFinal ctrl){
        this.ctrl=ctrl;

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
            TTS_Mbrola.doSpeak("Hi, "+name+"   \n welcome to norden \n nice to meet you.");
           // CommandTTS.doSpeak(name);
        }catch (Exception e){
            //
        }
        // System.out
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        // not used in this example
    }


}
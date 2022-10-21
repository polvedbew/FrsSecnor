import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttClbk  implements MqttCallback {
    MainInterfaceControllerFinal ctrl;
    public MqttClbk(MainInterfaceControllerFinal ctrl){
        this.ctrl=ctrl;
    }

    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        String rcv=new String(mqttMessage.getPayload());
        String name=rcv.substring(rcv.indexOf("PersonName")+11,rcv.indexOf("FaceImgPath")-3);

        System.out.println(name +"  Message received:\n\t"+ rcv) ;
        ctrl.setHiText(name);
       // System.out
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        // not used in this example
    }
}
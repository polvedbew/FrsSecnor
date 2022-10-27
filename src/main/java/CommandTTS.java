import java.io.IOException;

public class CommandTTS {

    public static void doSpeak(String name) throws IOException {
        try {
            Runtime.getRuntime().exec("espeak-ng -s 120 -v mb-us1 \"Hai "+name+" welcome to norden  lets transform some more lives  the norden way \"  ");
            Runtime.getRuntime().exec("espeak-ng -s 120 -v mb-us1 \" "+name+"\"  ");
            Runtime.getRuntime().exec("espeak-ng -s 120 -v mb-us1 \"welcome to norden  lets transform some more lives  the norden way \"  ");

        }catch (Exception e){
            //
        }

    }



}

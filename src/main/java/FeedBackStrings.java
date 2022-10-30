import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 30/10/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/
public class FeedBackStrings {
    public static final String LOCAL_CONFIG_BASE_DIR=System.getProperty("user.dir");
    public static final String LOCAL_CONFIG_DATA_DIR=LOCAL_CONFIG_BASE_DIR+ File.separatorChar+"data"+File.separatorChar;
    public static final String preText;
    public static final String preSpeech;
    public static final String postText;
    public static final String postSpeech;

    static{
        String temp;
        try {
            temp = Files.readString(Paths.get(LOCAL_CONFIG_DATA_DIR+"preText.txt"));
        } catch (IOException e) {
            //throw new RuntimeException(e);
            temp =" ";
        }
        preText = temp;
        try {
            temp = Files.readString(Paths.get(LOCAL_CONFIG_DATA_DIR+"preSpeech.txt"));
        } catch (IOException e) {
            //throw new RuntimeException(e);
            temp =" ";
        }
        preSpeech = temp;

        try {
            temp = Files.readString(Paths.get(LOCAL_CONFIG_DATA_DIR+"postText.txt"));
        } catch (IOException e) {
            //throw new RuntimeException(e);
            temp =" ";
        }
        postText = temp;

        try {
            temp = Files.readString(Paths.get(LOCAL_CONFIG_DATA_DIR+"postSpeech.txt"));
        } catch (IOException e) {
            //throw new RuntimeException(e);
            temp =" ";
        }
        postSpeech = temp;

    }




}

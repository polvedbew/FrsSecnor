import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 07/05/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/

public class ImageUtils {
    public static Image getImageFx2(String path) throws FileNotFoundException {
        return new Image(new FileInputStream(path));
    }

 public static Image getImageFx(String path) throws FileNotFoundException {
        Image img=null;
        try{
            img=new Image(ImageUtils.class.getResourceAsStream(path));
        }catch (Exception e){
            //
        }
        return img;
    }
}

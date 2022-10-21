import javafx.scene.image.Image;

import java.io.File;
import java.io.FileNotFoundException;


/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 28/04/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/
public class ImageCache {

    public static Image PERSON_IMAGE;
    public static Image GROUP_IMAGE;
    public static Image ZONE_IMAGE;
    public static Image DOOR_IMAGE;
    public static Image CONTROLLER_IMAGE;
    public static Image CARDS_IMAGE;
    public static Image CALENDER_CLOCK;
    public static Image ASSETS_IMAGE;
    public static Image SOFTWARE_IMAGE;
    public static Image FLOOR_PLAN_IMAGE;
    public static Image Loading1;
    public static Image Loading2;
    public static Image Loading3;
    public static Image Loading4;
    public static Image SECNOR_ICON;
    public static final String imgPth="src"+ File.separatorChar+"main"+File.separatorChar+"resources"+File.separatorChar+"images";

    static {

        try {
            SECNOR_ICON =ImageUtils.getImageFx(ImageIcons.SECNOR_ICON.src);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            PERSON_IMAGE =ImageUtils.getImageFx(ImageIcons.USER.src);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            GROUP_IMAGE =ImageUtils.getImageFx(ImageIcons.USERS.src);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }try {
            ZONE_IMAGE =ImageUtils.getImageFx(ImageIcons.ZONES.src);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }try {
            DOOR_IMAGE =ImageUtils.getImageFx(ImageIcons.DOOR.src);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }try {
            CONTROLLER_IMAGE =ImageUtils.getImageFx(ImageIcons.CHIP.src);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }try {
            CARDS_IMAGE =ImageUtils.getImageFx(ImageIcons.CARDS.src);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            CALENDER_CLOCK =ImageUtils.getImageFx(ImageIcons.CALENDER_CLOCK.src);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ASSETS_IMAGE =ImageUtils.getImageFx(ImageIcons.ITEMS.src);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            SOFTWARE_IMAGE =ImageUtils.getImageFx(ImageIcons.CONVERTER.src);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            FLOOR_PLAN_IMAGE =ImageUtils.getImageFx(ImageIcons.FLOOR_PLAN.src);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}

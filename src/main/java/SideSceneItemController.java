import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.concurrent.atomic.AtomicBoolean;


/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 5/7/22/05/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/

public class SideSceneItemController {
    public AnchorPane id_anchor_pane;
    public Rectangle id_side_home_rect;
    public ImageView id_icon;
    public Text id_text;
    public SidePanelItems thisItem;
    public AtomicBoolean selectionFlag=new AtomicBoolean(false);


    public void setAsSelected(){
        id_side_home_rect.setOpacity(.37d);
    }

    public void setAsNormal(){
        if(!selectionFlag.get()) {
            id_side_home_rect.setOpacity(.17d);
        }
    }




    public void populate(final SidePanelItems si){
        thisItem=si;
        try {
            id_icon.setImage(ImageUtils.getImageFx(si.msli.imgSrc));
        }catch (Exception e){
        }
        id_text.setText(si.msli.label);

        id_side_home_rect.setOnMouseEntered(e->{
            setAsSelected();
        });
        id_side_home_rect.setOnMouseExited(e->{
            setAsNormal();
        });
        id_side_home_rect.setOnMouseClicked(e->{
            selectionFlag.set(true);
            setAsSelected();
        });

    }

}

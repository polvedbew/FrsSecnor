
import javafx.application.Platform;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 5/7/22/05/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/

public class MainInterfaceControllerFinal {
    public ImageView id_secnorLogo;
    public FlowPane id_content_flow_pane;
    public FlowPane id_flow_pane_side;
    public ImageView id_session_manage_icon;
    public ImageView id_add_button_main;
    public ImageView id_loading_image;
    public Rectangle id_content_rectangle;
    public AnchorPane id_main_anchor_pane;
    final AtomicInteger currentImage=new AtomicInteger(0);
    public ScrollPane id_content_scroll_pane;
    public ScrollPane id_side_scroll_pane;
    public AnchorPane id_top_right_anchor_pane;
    public Text id_norden_url;
    public TextField id_main_text_search;
    public ImageView id_main_search_button;
    public ImageView id_top_right_image;
    public ImageView id_bottom_right_image;
    public ImageView id_image_centre;

    public ImageView id_refresh_button_main;
    public ImageView id_image_bottom_left;
    public Text id_main_help;
    public Text id_hi_text;

    public void registerListeners(){

    }

    public void setSideList(final List<SidePanelItems> list) {
        for(SidePanelItems item:list){
            SideItemPresenter presenter =new SideItemPresenter(item);
            presenter.initialize(null,null);
            id_flow_pane_side.getChildren().add(presenter.getScene());
        }
    }


    public void setHiText(final String str){
        Platform.runLater(()->{
            id_hi_text.setText("Hi,\n Stupid "+str+"\n this is secnor \nand \njust get lost");
        });
    }




}

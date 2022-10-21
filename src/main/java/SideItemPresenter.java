import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 5/7/22/05/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/

public class SideItemPresenter implements  Initializable{

    private SideSceneItemController ssic=null;
    private final SidePanelItems item;
    public SideItemPresenter( SidePanelItems item){
        this.item=item;
    }

    public AnchorPane getScene(){
        return ssic.id_anchor_pane;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader = new FXMLLoader(getResource(FxResourceLocator.SIDE_ITEM));
        try {
            loader.load();
            ssic=loader.getController();
            ssic.populate(item);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}

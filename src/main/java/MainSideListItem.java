
/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 07/05/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/

public class MainSideListItem {
    public String imgSrc="";
    public String label="label";
    public String hint="hint";
    public EntityTypes type=EntityTypes.DEFAULT;
    public MainSideListItem(String src, String label, String hint, EntityTypes type){
        this.type=type;
        this.imgSrc=src;
        this.label=label;
        this.hint=hint;
    }
}

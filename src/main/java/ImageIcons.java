/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 07/05/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/

public enum ImageIcons {
    HOME            ("/"+"images"+"/"+"sidePanel"  +"/"+"home.png"),
    USERS           ("/"+"images/sidePanel/users.png"),
    USER            ("/"+"images"+"/"+"sidePanel"  +"/"+"user.png"),
    FLOOR_PLAN      ("/"+"images"+"/"+"sidePanel"  +"/"+"floorPlan.png"),
    CHIP            ("/"+"images"+"/"+"sidePanel"  +"/"+"chip.png"),
    CARDS           ("/"+"images"+"/"+"sidePanel"  +"/"+"bankCards.png"),
    DOOR            ("/"+"images"+"/"+"sidePanel"  +"/"+"door.png"),
    ZONES           ("/"+"images"+"/"+"sidePanel"  +"/"+"floor.png"),
    REPORT          ("/"+"images"+"/"+"sidePanel"  +"/"+"report.png"),
    SECNOR_ICON     ("/"+"images"+"/"+"main"       +"/"+"SecnorIcon.png"),
    CONVERTER       ("/"+"images"+"/"+"sidePanel"  +"/"+"converter.png"),
    CALENDER_CLOCK  ("/"+"images"+"/"+"sidePanel"  +"/"+"calendar_clock.png"),
    ITEMS  ("/"+"images"+"/"+"sidePanel"  +"/"+"itms.png")
    ;



    public final String src;
    ImageIcons(String src){
        this.src=src;
        
    }

}

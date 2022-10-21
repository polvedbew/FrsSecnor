
/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 07/05/2022
 * R&D SCK
 * -----------------------------------------------------------------------------
 **/

public enum SidePanelItems {
    Home(new MainSideListItem(ImageIcons.HOME.src,"Home","", EntityTypes.DEFAULT)),
    //ZONES(new MainSideListItem(ImageIcons.ZONES.src,"Zones","", EntityTypes.ZONE)),
    GROUPS(new MainSideListItem(ImageIcons.USERS.src,"Groups","", EntityTypes.GROUP)),
    DOORS(new MainSideListItem(ImageIcons.DOOR.src,"Doors","", EntityTypes.DOOR)),
    PERSON(new MainSideListItem(ImageIcons.USER.src,"Person","", EntityTypes.PERSON)),
    CONTROLLER(new MainSideListItem(ImageIcons.CHIP.src,"Controller","", EntityTypes.CONTROLLER)),
    CARDS(new MainSideListItem(ImageIcons.CARDS.src,"Cards","", EntityTypes.CARD)),
    //REPORTS(new MainSideListItem(ImageIcons.REPORT.src,"Reports","", EntityTypes.DEFAULT)),
    SCHEDULES(new MainSideListItem(ImageIcons.CALENDER_CLOCK.src,"Schedules","", EntityTypes.SCHEDULE)),
    ASSETS(new MainSideListItem(ImageIcons.ITEMS.src,"Assets","", EntityTypes.ASSET)),
    SOFTWARE(new MainSideListItem(ImageIcons.CONVERTER.src,"Software","", EntityTypes.SOFTWARE))
    ;
    public MainSideListItem msli;
    SidePanelItems(MainSideListItem msli){
        this.msli=msli;
    }
}

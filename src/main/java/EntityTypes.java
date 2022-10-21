/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 7/3/22
 * at R&D (SMART CITY)
 * ----------------------------------------------------------------------------
 */
public enum EntityTypes {

    CONFIG("config_storage"),
    PERSON("person"),
    CONTROLLER("access_controller"),
    GROUP("group_division"),
    ZONE("zone_division"),
    DOOR("door_device"),
    DIVISION("division"),
    DRIVER_ACCESS_CONTROLLER("access_controller_driver"),
    TEMPORAL("temporal_event"),
    EVENT("event_point"),
    CARD("access_card"),
    SOFTWARE("soft_ware_entity"),
    ASSET("device_asset"),

    SCHEDULE("temporal_schedule"),
    DEFAULT("default_entity");

    private final String label;
    EntityTypes(String label){
        this.label=label;
    }
    public String getLabel(){return  label;}


}

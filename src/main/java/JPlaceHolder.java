
import retrofit2.http.*;
import rx.Observable;

import java.util.List;


/**
 * ----------------------*    Norden Communication    *-------------------------
 * Created on 09/03/2022
 * at R&D (SMART CITY)
 * ----------------------------------------------------------------------------
 */

public interface JPlaceHolder {


    @GET("face/status")
    Observable<List<StatusObj>> getStatus();

    @GET("events/enrolled/#")
    Observable<Obj> getSomething();

}

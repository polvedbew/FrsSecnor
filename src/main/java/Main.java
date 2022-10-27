import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;


import java.io.IOException;
import java.util.Arrays;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class Main {
    private static MainInterfaceControllerFinal micf;

    public static void main(String args[]) {



     /*  JPlaceHolder api= NaiveRetrofitBuilder.getApi();
        api.getStatus().subscribe(new Subscriber<List<StatusObj>>() {
            @Override
            public void onCompleted() {
                System.out.println("Completed ----------------");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error: "+throwable);

            }

            @Override
            public void onNext(List<StatusObj> obj) {
                System.out.println("Received list of size: "+obj.size());
                System.out.println("decoder type :"+obj.get(0).decoderType);
            }
        });
*/
        final String topic = "events/Face_Recognition/#";




        Platform.startup(() -> {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getResource(FxResourceLocator.MAIN_SCENE));
            try {
                Scene scene = new Scene(fxmlLoader.load());
                micf = fxmlLoader.getController();
                micf.registerListeners();
                stage.setTitle("Secnor access control");
                stage.setScene(scene);
                stage.show();
                try {
                    stage.getIcons().add(ImageCache.SECNOR_ICON);
                } catch (Exception exi) {
                    System.out.println("caught at main stage icon "+exi.getMessage()+exi.toString());
                }

                ObservableList<SidePanelItems> list = FXCollections.observableArrayList();
                list.addAll(Arrays.asList(SidePanelItems.values()));
                micf.setSideList(list);

                final double ivalW = scene.getWidth();
                final double ivalH = scene.getHeight();
                final double conRecW = micf.id_content_rectangle.getWidth();
                final double conScrW = micf.id_content_scroll_pane.getWidth();
                final double conFlwW = micf.id_content_flow_pane.getWidth();
                final double tRAncPnX = micf.id_top_right_anchor_pane.getLayoutX();
                final double nUrlX = micf.id_norden_url.getLayoutX();
                final double tRimgX = micf.id_top_right_image.getLayoutX();
                final double bRimgX = micf.id_bottom_right_image.getLayoutX();
                final double cImgX = micf.id_image_centre.getLayoutX();
                final double lbImgY = micf.id_image_bottom_left.getLayoutY();
                stage.widthProperty().addListener((obs, oldVal, newVal) -> {
                    if (newVal.intValue() < 800) {
                        return;
                    }
                    final double cwd = ivalW - newVal.doubleValue();
                    //micf.id_content_rectangle.setWidth(newVal.intValue()-380);
                    micf.id_content_rectangle.setWidth(conRecW - cwd);
                    micf.id_content_scroll_pane.setPrefWidth(conScrW - cwd);
                    micf.id_content_flow_pane.setPrefWidth(conFlwW - cwd);
                    micf.id_top_right_anchor_pane.setLayoutX(tRAncPnX - cwd);
                    micf.id_norden_url.setLayoutX(nUrlX - cwd);
                    micf.id_top_right_image.setLayoutX(tRimgX - cwd);
                    micf.id_bottom_right_image.setLayoutX(bRimgX - cwd);

                    micf.id_image_centre.setLayoutX(cImgX - (cwd / 2));
                });

                stage.heightProperty().addListener((obs, oldVal, newVal) -> {
                    if (newVal.intValue() < 400) {
                        return;
                    }
                    final double cwd = ivalH - newVal.doubleValue();
                    micf.id_content_rectangle.setHeight(newVal.intValue() - 170);
                    micf.id_content_scroll_pane.setPrefHeight(newVal.intValue() - 200);
                    micf.id_content_flow_pane.setPrefHeight(newVal.intValue() - 240);
                    micf.id_side_scroll_pane.setPrefHeight(newVal.intValue() - 100);
                    micf.id_norden_url.setLayoutY(newVal.intValue() - 50);
                    micf.id_image_bottom_left.setLayoutY(lbImgY - (cwd) - 50);

                });

                new Thread(() -> {
                    try {
                        final String cid = MqttClient.generateClientId();
                        MqttConnectOptions connOpt = new MqttConnectOptions();
                        connOpt.setCleanSession(true);
                        connOpt.setKeepAliveInterval(6000);

                        MqttClient client = new MqttClient("tcp://192.168.2.21:1885", cid);
                        MqttClbk clbk=new MqttClbk(micf);
                        client.setCallback(clbk);
                        client.connect(connOpt);
                        client.subscribe(topic, 0);


                    } catch (Exception e) {
                        System.out.println("caught exception at mqtt" + e.toString() + "         \n" + e.getMessage());
                    }
                }).start();

                new Thread(()->{
                    int v=20;
                    while(v-- >0) {
                        try {
                            Thread.sleep(3000);
                            //clbk.messageArrived("blaaaah",null);
                            TTS.doSpeak("hi, lets transform lives the norden way");
                        } catch (Exception e) {
                            //
                        }

                    }
                }).start();

            } catch (IOException e) {
                System.out.println("caught main "+e.toString());
            }
            stage.setOnCloseRequest(e -> {
                System.exit(0);
            });
        });
        Platform.setImplicitExit(false);

    }

}
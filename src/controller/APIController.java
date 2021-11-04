package controller;

import java.net.URI;
import java.net.http.*;

import view.MainFrm;

public class APIController {

    public static void setAPITest(){
        String apiURL = MainFrm.txtURL.getText() + "";
        URI uri = URI.create(apiURL);
        String apiContent = "";
        String apiStatus = "";
        try {
            HttpClient client = HttpClient.newHttpClient();
            apiStatus = client.send(HttpRequest.newBuilder().GET().uri(uri).build(), HttpResponse.BodyHandlers.ofString()).statusCode() + "";
            apiContent = client.send(HttpRequest.newBuilder().GET().uri(uri).build(), HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(apiStatus.length() == 3){
            MainFrm.lblStatus.setText("API Status: " + apiStatus);
            if(apiStatus.equals("200")){
                MainFrm.textPane.setText(apiContent);
            }
        }else{
            MainFrm.lblStatus.setText("API Status: Error");
            MainFrm.textPane.setText("");
        }
    }

}
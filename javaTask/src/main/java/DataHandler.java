

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class DataHandler {

    DataHandler(){
    };

    ArrayList populateHandler(String path) throws IOException {

        ArrayList jsonList = new ArrayList<Data>();
        String stringOfJsons = new String(Files.readAllBytes(Paths.get(path)));
        String[] jsonArray = stringOfJsons.split("}");
        Gson myJson = new Gson();
        for(int i=0; i!=jsonArray.length; i++){
            Map rawData = myJson.fromJson(jsonArray[i] + "}", Map.class);
            Data newNode = new Data((String)rawData.get("id"), (String)rawData.get("state"), (Double)rawData.get("timestamp"), (String)rawData.get("host"), (String)rawData.get("type"));
            jsonList.add(newNode);
        }
        return jsonList;
    }
}

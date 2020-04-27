import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class MainClass {

    public static void main(String[] args) throws IOException {
        String path = "C:/Users/torch/Desktop/logfile.txt";
        DataHandler myHandler = new DataHandler();
        ArrayList newNodes = myHandler.populateHandler(path);
        ExceptionFinder myFinder = new ExceptionFinder();
        Map matches = myFinder.getMatchingNodes(newNodes);
        ArrayList<Event> events = myFinder.getNodesExceedingThreshold(matches, newNodes);
        String insertQuery ="";
        for(int i=0; i!=events.size(); i++){
            Event myE = events.get(i);
            insertQuery = String.format("%sINSERT INTO EVENTS VALUES (%s, %s, %s, %s, %s);\n", insertQuery, myE.id, myE.alert, Double.toString(myE.duration), myE.host, myE.type);
        }
        System.out.println(insertQuery);
    }
}

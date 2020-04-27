import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExceptionFinder {

    double threshold = 4.0;
    ExceptionFinder(){
    }

    Map getMatchingNodes(ArrayList<Data> newNodes){
        Map matches = new HashMap<Integer,Integer>();
        for(int i=0; i!=newNodes.size()-1; i++){
            for(int j=i+1; j!=newNodes.size(); j++){
                if(newNodes.get(i).id.contentEquals(newNodes.get(j).id)){
                    matches.put(i,j);
                }
            }
        }
        return matches;
    }

    ArrayList getNodesExceedingThreshold(Map<Integer, Integer> matches, ArrayList<Data> newNodes){
        ArrayList toCommit = new ArrayList<Event>();
        for (int key : matches.keySet()) {
                Data a = newNodes.get(key);
                Data b = newNodes.get(matches.get(key));
                double calc;
                if(a.state.contentEquals("STARTED")){
                    calc = b.timestamp-a.timestamp;
                }
                else{
                    calc = a.timestamp-b.timestamp;
                }
                boolean alertFlag = false;
                if(calc > threshold){
                    alertFlag = true;
                }
                String h = a.host;
                if(b.host!=null){
                    h = b.host;
                }
                String t = a.type;
                if(b.type!=null){
                    t = b.type;
                }
                Event newEvent = new Event(a.id, alertFlag, calc, h, t);
                toCommit.add(newEvent);
            }
        return toCommit;
        }
    }


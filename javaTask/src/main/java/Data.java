public class Data {

    double timestamp;
    String state, type, host, id;

    Data(String id, String state, double timestamp, String host, String type){
        this.id = id;
        this.state = state;
        this.timestamp = timestamp;
        this.host = host;
        this.type = type;
    };
}

public class Event {

    double duration;
    String type, host, id;
    Boolean alert;

    Event(String id, Boolean alert, double duration, String host, String type){
        this.id = id;
        this.alert = alert;
        this.duration = duration;
        this.host = host;
        this.type = type;
    };
}

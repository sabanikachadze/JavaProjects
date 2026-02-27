package ConferenceSchedulePlanning;

public class Main {

    public static void main(String[] args) {
        Talk t1 = new Talk(1, "Intro to Java", 60, new Talk[]{});
        Talk t2 = new Talk(2, "Advanced Generics", 90, new Talk[]{t1});

        Conference conf = new Conference(5, 300);

        System.out.println(conf.addTalk(t2)); // false — prerequisite t1 not in conference yet
        System.out.println(conf.addTalk(t1)); // true
        System.out.println(conf.addTalk(t2)); // true — t1 is now accepted

        t1.present();
        Workshop w1 = Workshop.createWorkshop(3, "Build a Generic Cache", 90, t1); // not null
        Workshop w2 = Workshop.createWorkshop(4, "Hands-on Streams", 60, t2);     // null — t2 not presented

        System.out.println(conf.addWorkshop(w1)); // true — fits within remaining 150 min
        System.out.println(conf.getTotalDuration()); // 240
    }
}

package ConferenceSchedulePlanning;

public class Activity {
    private final int id;
    private final String title;
    private final int duration;
    private boolean presented;

    public Activity(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        presented = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isPresented() {
        return presented;
    }
    public void present(){
        presented = true;
    }
}

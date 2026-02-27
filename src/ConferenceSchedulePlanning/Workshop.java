package ConferenceSchedulePlanning;

public class Workshop extends Activity {
    private final Talk talk;

    public Workshop(int id, String title, int duration, Talk talk) {
        super(id, title, duration);
        this.talk = talk;
    }

    public static Workshop createWorkshop(int id, String title, int duration, Talk talk) {

        if (id <= 0) return null;

        if (title == null || title.isBlank()) return null;

        if (duration <= 0) return null;

        if (talk == null|| !talk.isPresented()) return null;

        return new Workshop(id, title, duration, talk);
    }

    @Override
    public String toString() {
        return "[Workshop " + getId() + "] " + talk.getTitle() + ": " + getTitle();
    }
}

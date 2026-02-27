package ConferenceSchedulePlanning;


public class Talk extends Activity{
    private final int count;
    private final Talk[] prerequisites;

    public Talk(int id, String title, int duration, Talk[] prerequisites) {
        super(id, title, duration);
        this.prerequisites = prerequisites;
        count = prerequisites.length;
    }

    @Override
    public void present(){
        int total = 0;
        for(int i = 0; i < count; i++){
            if(prerequisites[i].isPresented()) total++;
        }
        if(total == count) super.present();
    }

    public Talk[] getPrerequisites(){
        return prerequisites.clone();
    }

    @Override
    public String toString() {
        return "[Talk " + getId() + "] " + getTitle();
    }
}

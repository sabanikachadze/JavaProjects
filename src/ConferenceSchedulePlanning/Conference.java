package ConferenceSchedulePlanning;

public class Conference {
    private final int timeCapacity;
    private final int slotLimit;
    private final Activity[] activities;
    private int count;
    private int totalTime;

    public Conference(int slotLimit, int timeCapacity) {
        this.slotLimit = slotLimit;
        this.timeCapacity = timeCapacity;
        activities = new Activity[slotLimit];
        count = 0;
        totalTime = 0;
    }

    public boolean addTalk(Talk talk){
        if(talk == null) return false;
        if(talk.isPresented()) return false;
        if(totalTime + talk.getDuration() > timeCapacity) return false;
        if(slotLimit <= count) return false;

        for (Talk prereq : talk.getPrerequisites()) {
        if (!prereq.isPresented()) {
            boolean found = false;
            for (int i = 0; i < count; i++) {
                if (activities[i] == prereq) {
                    found = true;
                    break;
                }
            }
        if (!found) return false;
    }
}
        activities[count++] = talk;
        totalTime += talk.getDuration();
        return true;
    }


    public boolean addWorkshop(Workshop workshop){
        if(workshop == null) return false;
        if(workshop.isPresented()) return false;
        if(totalTime + workshop.getDuration() > timeCapacity) return false;
        if(slotLimit <= count) return false;

        activities[count++] = workshop;
        totalTime += workshop.getDuration();
        return true;
    }

    public Activity[] getActivities(){
        return activities.clone();
    }
    public int getTotalDuration(){
        return totalTime;
    }
}

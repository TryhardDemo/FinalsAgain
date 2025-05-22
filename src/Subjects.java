//Reasons tho hate this god forsaken language more
public enum Subjects {
    MATH, SCIENCE, HISTORY, ART, PHYSICAL_EDUCATION, COMPUTER_SCIENCE, MUSIC, LANGUAGE_ARTS, SOCIAL_STUDIES, HEALTH;
    private static final int LIMITED_SLOTS = 3;
    private int slotsLeft = 3;

    Subjects(){
        this.slotsLeft = LIMITED_SLOTS;
    }

    public boolean enroll(){
        if (slotsLeft > 0){
            slotsLeft--;
            return true;
        }
        return false;
    }

    public int getSlotsLeft(){
        return slotsLeft;
    }
}

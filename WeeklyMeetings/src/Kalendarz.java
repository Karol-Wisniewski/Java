import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Kalendarz {

    private ArrayList<ArrayList<Spotkanie>> spotkania;

    public Kalendarz(int liczbaDni) {
        if (liczbaDni > 0 && liczbaDni < 8) {
            spotkania = new ArrayList<ArrayList<Spotkanie>>();
            for (int i = 0; i < liczbaDni; i++) {
                spotkania.add(new ArrayList<Spotkanie>());
            }
        }
    }

    public Kalendarz() {
        this(7);
    }

    public void dodajSpotkanie(Spotkanie spotkanie, int dzienTygodnia) {
        spotkania.get(dzienTygodnia).add(spotkanie);
    }

    public void usunSpotkanie(int dzienTygodnia, int indexSpotkania) {
        spotkania.get(dzienTygodnia).remove(indexSpotkania);
    }

    public ArrayList<Spotkanie> getMeetingsByPredicate(Predicate<Spotkanie> condition, int day) {
        ArrayList<Spotkanie> filteredMeetings = new ArrayList<>();

        for (Spotkanie spotkanie : spotkania.get(day)) {
            if (condition.test(spotkanie)) {
                filteredMeetings.add(spotkanie);
            }
        }

        return filteredMeetings;
    }
}

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {

    private static final Scanner intScanner = new Scanner(System.in);

    private static final Scanner stringScanner = new Scanner(System.in);

    private static final ArrayList<String> dniTygodnia = new ArrayList<>(){{
        add("Monday");
        add("Tuesday");
        add("Wednesday");
        add("Thursday");
        add("Friday");
        add("Saturday");
        add("Sunday");
    }};

    private static void printMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Add a meeting");
        System.out.println("2. Remove a meeting");
        System.out.println("3. View meetings by day");
        System.out.println("4. View meetings by day and priority");
        System.out.println("5. View meetings by day and from time");
        System.out.println("6. View meetings by day and between times");
        System.out.println("7. View meetings by day and priority and from time");
        System.out.println("8. Exit");
    }

    private static void printDays(int liczbaDni) {
        System.out.println("Choose day:");
        for (int i = 0; i < liczbaDni; i++) {
            System.out.println((i + 1) + ". " + dniTygodnia.get(i));
        }
    }

    private static void printPriorities() {
        System.out.println("Choose priority:");
        System.out.println("1. Wysoki");
        System.out.println("2. Średni");
        System.out.println("3. Niski");
    }

    private static void checkIfDayIsCorrect(int day, int liczbaDni) {
        if (day < 1 || day > liczbaDni) {
            System.out.println("Invalid day! There are only " + liczbaDni + " days in this calendar.");
            System.exit(0);
        }
    }

    private static String convertIntToPriority(int priority) {
        switch (priority) {
            case 1 -> {
                return "Wysoki";
            }
            case 2 -> {
                return "Średni";
            }
            case 3 -> {
                return "Niski";
            }
            default -> {
                return "Invalid argument";
            }
        }
    }

    private static void usunSpotkanie(Kalendarz kalendarz, int liczbaDni) {
        printDays(liczbaDni);
        int dzienTygodnia = intScanner.nextInt();
        checkIfDayIsCorrect(dzienTygodnia, liczbaDni);
        System.out.println("Choose meeting:");
        Predicate<Spotkanie> predicate = (meeting -> true);
        ArrayList<Spotkanie> spotkania = kalendarz.getMeetingsByPredicate(predicate,dzienTygodnia - 1);
        for (int i = 0; i < spotkania.size(); i++) {
            Spotkanie spotkanie = spotkania.get(i);
            System.out.println((i + 1) +
                    ". " +
                    spotkanie.getOpis() +
                    " (" + spotkanie.getCzasPoczatku() +
                    " - " + spotkanie.getCzasZakonczenia() +
                    ")" +
                    "\n");
        }
        int indexSpotkania = intScanner.nextInt();
        kalendarz.usunSpotkanie(dzienTygodnia - 1, indexSpotkania - 1);
    }

    private static void dodajSpotkanie(Kalendarz kalendarz, int liczbaDni) {
        System.out.println("Enter meeting description:");
        String opis = stringScanner.nextLine();
        System.out.println("Enter meeting start time (hh:mm):");
        String czasPoczatku = stringScanner.nextLine();
        System.out.println("Enter meeting end time (hh:mm):");
        String czasZakonczenia = stringScanner.nextLine();
        System.out.println("Enter meeting priority:");
        printPriorities();
        int priorytet = intScanner.nextInt();
        Spotkanie spotkanie = new Spotkanie(opis, LocalTime.parse(czasPoczatku), LocalTime.parse(czasZakonczenia), convertIntToPriority(priorytet));
        printDays(liczbaDni);
        int dzienTygodnia = intScanner.nextInt();
        checkIfDayIsCorrect(dzienTygodnia, liczbaDni);
        if (Spotkanie.MIN_GODZINA_DNIA.isBefore(spotkanie.getCzasPoczatku())) {
            kalendarz.dodajSpotkanie(spotkanie, dzienTygodnia - 1);
        } else {
            System.out.println("The meeting was set too early!");
        }
    }

    private static void wyswietlSpotkaniaDnia(Kalendarz kalendarz, int liczbaDni) {
        printDays(liczbaDni);
        int dzienTygodnia = intScanner.nextInt();
        checkIfDayIsCorrect(dzienTygodnia, liczbaDni);
        Predicate<Spotkanie> predicate = (meeting -> true);
        ArrayList<Spotkanie> spotkania = kalendarz.getMeetingsByPredicate(predicate,dzienTygodnia - 1);
        for (Spotkanie s : spotkania) {
            System.out.println(s.toString());
        }
    }

    private static void wyswietlSpotkaniaDniaZPriorytetem(Kalendarz kalendarz, int liczbaDni) {
        printDays(liczbaDni);
        int dzienTygodnia = intScanner.nextInt();
        checkIfDayIsCorrect(dzienTygodnia, liczbaDni);
        printPriorities();
        int priorytetInt = intScanner.nextInt();
        String priorytet = convertIntToPriority(priorytetInt);
        Predicate<Spotkanie> predicate = (meeting -> meeting.getPriorytet().equals(priorytet));
        ArrayList<Spotkanie> spotkania = kalendarz.getMeetingsByPredicate(predicate,dzienTygodnia - 1);
        for (Spotkanie s : spotkania) {
            System.out.println(s.toString());
        }
    }

    private static void wyswietlSpotkaniaDniaOdCzasu(Kalendarz kalendarz, int liczbaDni) {
        printDays(liczbaDni);
        int dzienTygodnia = intScanner.nextInt();
        checkIfDayIsCorrect(dzienTygodnia, liczbaDni);
        System.out.println("Enter starting time (hh:mm):");
        String czas = stringScanner.nextLine();
        Predicate<Spotkanie> predicate = (meeting -> meeting.getCzasPoczatku().isAfter(LocalTime.parse(czas)));
        ArrayList<Spotkanie> spotkania = kalendarz.getMeetingsByPredicate(predicate,dzienTygodnia - 1);
        for (Spotkanie s : spotkania) {
            System.out.println(s.toString());
        }
    }

    private static void wyswietlSpotkaniaDniaPomiedzyCzasami(Kalendarz kalendarz, int liczbaDni) {
        printDays(liczbaDni);
        int dzienTygodnia = intScanner.nextInt();
        checkIfDayIsCorrect(dzienTygodnia, liczbaDni);
        System.out.println("Enter starting time (hh:mm):");
        String czasRozpoczecia = stringScanner.nextLine();
        System.out.println("Enter starting time (hh:mm):");
        String czasZakoczenia = stringScanner.nextLine();
        Predicate<Spotkanie> predicate = (meeting -> meeting.getCzasPoczatku().isAfter(LocalTime.parse(czasRozpoczecia))
                && meeting.getCzasZakonczenia().isBefore(LocalTime.parse(czasZakoczenia)));
        ArrayList<Spotkanie> spotkania = kalendarz.getMeetingsByPredicate(predicate,dzienTygodnia - 1);
        for (Spotkanie s : spotkania) {
            System.out.println(s.toString());
        }
    }

    private static void wyswietlSpotkaniaDniaZPriorytetemIOdCzasu(Kalendarz kalendarz, int liczbaDni) {
        printDays(liczbaDni);
        int dzienTygodnia = intScanner.nextInt();
        checkIfDayIsCorrect(dzienTygodnia, liczbaDni);
        printPriorities();
        int priorytetInt = intScanner.nextInt();
        String priorytet = convertIntToPriority(priorytetInt);
        System.out.println("Enter starting time (hh:mm):");
        String czas = stringScanner.nextLine();
        Predicate<Spotkanie> predicate = (meeting -> meeting.getPriorytet().equals(priorytet)
                && meeting.getCzasPoczatku().isAfter(LocalTime.parse(czas)));
        ArrayList<Spotkanie> spotkania = kalendarz.getMeetingsByPredicate(predicate,dzienTygodnia - 1);
        for (Spotkanie s : spotkania) {
            System.out.println(s.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Weekly Calendar!");
        System.out.println("This is a simple calendar that allows you to add meetings and view them by day or priority.");
        int liczbaDni = 3;
        Kalendarz kalendarz = new Kalendarz(liczbaDni);
        boolean run = true;

        while (run) {
            printMenu();
            int choice = intScanner.nextInt();
            switch (choice) {
                case 1 -> dodajSpotkanie(kalendarz, liczbaDni);
                case 2 -> usunSpotkanie(kalendarz, liczbaDni);
                case 3 -> wyswietlSpotkaniaDnia(kalendarz, liczbaDni);
                case 4 -> wyswietlSpotkaniaDniaZPriorytetem(kalendarz, liczbaDni);
                case 5 -> wyswietlSpotkaniaDniaOdCzasu(kalendarz, liczbaDni);
                case 6 -> wyswietlSpotkaniaDniaPomiedzyCzasami(kalendarz, liczbaDni);
                case 7 -> wyswietlSpotkaniaDniaZPriorytetemIOdCzasu(kalendarz, liczbaDni);
                case 8 -> {
                    System.out.println("Goodbye!");
                    run = false;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
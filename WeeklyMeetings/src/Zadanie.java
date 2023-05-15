import java.time.LocalTime;

public final class Zadanie extends Wydarzenie{
    private String status;

    public Zadanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, String status) {
        super(opis, czasPoczatku, czasZakonczenia);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return  "Task: " + getOpis() + "\n" +
                getCzasPoczatku() + " - " + getCzasZakonczenia() + "\n" +
                "Status: " + status + "\n";
    }
}

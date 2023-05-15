import java.time.LocalTime;

public final class Spotkanie extends Wydarzenie {
    private String priorytet;

    public Spotkanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, String priorytet) {
        super(opis, czasPoczatku, czasZakonczenia);
        this.priorytet = priorytet;
    }

    public String getPriorytet() {
        return priorytet;
    }

    @Override
    public String toString() {
        return  "Meeting: " + getOpis() + "\n" +
                getCzasPoczatku() + " - " + getCzasZakonczenia() + "\n" +
                "Priority: " + priorytet + "\n";
    }
}

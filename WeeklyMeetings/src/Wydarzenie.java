import java.time.LocalTime;

public abstract sealed class Wydarzenie permits Spotkanie, Zadanie {

    private String opis;
    private LocalTime czasPoczatku;
    private LocalTime czasZakonczenia;

    protected static final LocalTime MIN_GODZINA_DNIA = LocalTime.of(8, 0);

    protected Wydarzenie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia) {
        this.opis = opis;
        this.czasPoczatku = czasPoczatku;
        this.czasZakonczenia = czasZakonczenia;
    }

    protected LocalTime getCzasPoczatku() {
        return czasPoczatku;
    };

    protected LocalTime getCzasZakonczenia() {
        return czasZakonczenia;
    };

    protected String getOpis() {
        return opis;
    };
}

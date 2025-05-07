package proggestioneclub;

public class Atleta extends Persona {

    private String ruolo;

    // Costruttore
    public Atleta(String nome, String cognome, String ruolo) {
        super(nome, cognome);  // Chiama il costruttore della classe base Persona
        this.ruolo = ruolo;
    }

    // Getter per ruolo
    public String getRuolo() {
        return ruolo;
    }

    // Setter per ruolo
    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    // Metodo toString per una rappresentazione leggibile dell'oggetto
    @Override
    public String toString() {
        return super.toString()+"," + ruolo;
    }
}

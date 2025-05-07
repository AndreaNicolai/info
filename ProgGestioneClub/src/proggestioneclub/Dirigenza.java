package proggestioneclub;

public class Dirigenza extends Persona {
    private String ruolo;
    
    // Costruttore
    public Dirigenza(String nome, String cognome, String ruolo) {
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
    
    // Override del metodo toString() per includere anche il ruolo
    @Override
    public String toString() {
        return super.toString() + "," + ruolo;
    }
}

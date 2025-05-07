package proggestioneclub;

/**
 *
 * @author andrea.nicolai
 */
public class Persona {

    private String nome;
    private String cognome;

    // Costruttore
    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    // Getter per nome
    public String getNome() {
        return nome;
    }

    // Setter per nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter per cognome
    public String getCognome() {
        return cognome;
    }

    // Setter per cognome
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    // Metodo toString per rappresentare l'oggetto come stringa
    @Override
    public String toString() {
        return nome + "," + cognome ;
    }
}

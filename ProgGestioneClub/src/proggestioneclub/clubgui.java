package proggestioneclub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.io.*;

/**
 * La classe principale per la GUI della gestione di un club.
 */
public class clubgui extends JFrame {

    private LinkedList club = new LinkedList();  // La lista dei membri del club
    JLabel wel = new JLabel("Benvenuto nella gestione della società");  // Etichetta di benvenuto
    JButton S = new JButton("Aggiungi membri staff");  // Bottone per aggiungere membri dello staff
    JButton SrcS = new JButton("Ricerca staff");  // Bottone per cercare membri dello staff nel file
    JButton G = new JButton("Aggiungi atleta");  // Bottone per aggiungere un atleta
    JButton SrcA = new JButton("Ricerca atleta");  // Bottone per cercare un atleta nel file
    JButton send = new JButton("Invia dati");  // Bottone per inviare i dati inseriti
    JButton exit = new JButton("TORNA ALL'INIZIO");  // Bottone per tornare alla schermata iniziale
    JLabel nome = new JLabel("Inserire nome: ");  // Etichetta per il campo nome
    JLabel cognome = new JLabel("Inserire cognome: ");  // Etichetta per il campo cognome
    JLabel ruolo = new JLabel("Inserire ruolo: ");  // Etichetta per il campo ruolo
    JTextField uno = new JTextField();  // Campo di testo per il nome
    JTextField due = new JTextField();  // Campo di testo per il cognome
    JTextField tre = new JTextField();  // Campo di testo per il ruolo
    GestBottone S1 = new GestBottone();  // Classe per la gestione degli eventi

    /**
     * Costruttore che configura l'interfaccia grafica e i componenti.
     */
    public clubgui(LinkedList club) {
        this.club = club;
        this.setLayout(null);  // Layout assoluto per il posizionamento manuale dei componenti
        this.addWindowListener(new ChiudiWin());  // Gestore per la chiusura della finestra
        BackgroundPanel background = new BackgroundPanel("/proggestioneclub/img/sfondo.jpg");
        background.setLayout(null);
        this.setContentPane(background);

        // Impostazioni del font per l'interfaccia (aumento la dimensione)
        Font font = new Font("Arial", Font.PLAIN, 20);  // Font più grande
        wel.setFont(font);  // Imposta il font per l'etichetta di benvenuto
        wel.setBounds(750, 50, 370, 80);  // Posizione dell'etichetta di benvenuto
        wel.setOpaque(true); // IMPORTANTE per vedere il background
        wel.setBackground(Color.YELLOW); // Colore evidenziato
        wel.setForeground(Color.BLACK); // Colore del testo
        this.add(wel);
        nome.setOpaque(true); // IMPORTANTE per vedere il background
        nome.setBackground(Color.YELLOW); // Colore evidenziato
        nome.setForeground(Color.BLACK); // Colore del testo

        cognome.setOpaque(true); // IMPORTANTE per vedere il background
        cognome.setBackground(Color.YELLOW); // Colore evidenziato
        cognome.setForeground(Color.BLACK); // Colore del testo

        ruolo.setOpaque(true); // IMPORTANTE per vedere il background
        ruolo.setBackground(Color.YELLOW); // Colore evidenziato
        ruolo.setForeground(Color.BLACK); // Colore del testo
        // Carica l'immagine
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/proggestioneclub/img/logo.png"));
        Image scaledImage = logoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledImage));
        //x,y,width,height
        logoLabel.setBounds(0, -10, 200, 300);
        this.add(logoLabel);

        // Aggiunta dei componenti all'interfaccia
        this.add(S);
        this.add(G);
        this.add(nome);
        this.add(cognome);
        this.add(ruolo);
        this.add(uno);
        this.add(due);
        this.add(tre);
        this.add(send);
        this.add(SrcA);
        this.add(SrcS);

        // Impostazioni dei font per le etichette
        nome.setFont(font);
        cognome.setFont(font);
        ruolo.setFont(font);

        // Impostazioni di visibilità per i componenti
        send.setVisible(false);  // Nasconde il bottone "Invia dati" inizialmente
        uno.setVisible(false);  // Nasconde il campo di testo per il nome inizialmente
        due.setVisible(false);  // Nasconde il campo di testo per il cognome inizialmente
        tre.setVisible(false);  // Nasconde il campo di testo per il ruolo inizialmente
        nome.setVisible(false);  // Nasconde l'etichetta per il nome inizialmente
        cognome.setVisible(false);  // Nasconde l'etichetta per il cognome inizialmente
        ruolo.setVisible(false);  // Nasconde l'etichetta per il ruolo inizialmente
        this.add(exit);  // Aggiunge il bottone "TORNA ALL'INIZIO"

        // Aggiunta dei listener per i pulsanti
        SrcS.addActionListener(S1);
        SrcA.addActionListener(S1);
        S.addActionListener(S1);
        G.addActionListener(S1);
        exit.addActionListener(S1);
        send.addActionListener(S1);

        // Impostazioni delle posizioni dei componenti (dimensioni e posizioni)
        S.setBounds(1000, 250, 400, 50);  // Dimensioni più grandi per i bottoni
        G.setBounds(400, 250, 400, 50);
        SrcS.setBounds(1000, 500, 400, 50);
        SrcA.setBounds(400, 500, 400, 50);
        exit.setBounds(0, 700, 250, 60);  // Bottone più grande per l'uscita
        send.setBounds(750, 450, 250, 60);
        uno.setBounds(1050, 170, 250, 40);
        due.setBounds(1050, 270, 250, 40);
        tre.setBounds(1050, 370, 250, 40);
        nome.setBounds(750, 150, 150, 60);
        cognome.setBounds(750, 250, 170, 60);
        ruolo.setBounds(750, 350, 150, 60);

        // Cambia il colore di sfondo dei bottoni con il colore richiesto (153, 0, 0)
        Color yellow = new Color(255, 208, 45, 255);
        Color blue = new Color(33, 83, 158, 255);
        S.setBackground(blue);  // Bottone "Aggiungi membri staff"
        G.setBackground(blue);  // Bottone "Aggiungi atleta"
        SrcS.setBackground(blue);
        SrcA.setBackground(blue);
        send.setBackground(blue);  // Bottone "Invia dati"
        exit.setBackground(blue);  // Bottone "TORNA ALL'INIZIO"

        // Cambia il colore del testo (foreground) dei bottoni
        S.setForeground(Color.WHITE);  // Colore bianco per il testo del bottone "Aggiungi membri staff"
        G.setForeground(Color.WHITE);  // Colore bianco per il testo del bottone "Aggiungi atleta"
        SrcS.setForeground(Color.WHITE);  // Colore bianco per il testo del bottone "Ricerca staff"
        SrcA.setForeground(Color.WHITE);  // Colore bianco per il testo del bottone "Ricerca atleta"
        send.setForeground(Color.WHITE);  // Colore bianco per il testo del bottone "Invia dati"
        exit.setForeground(Color.WHITE);  // Colore bianco per il testo del bottone "TORNA ALL'INIZIO"

        // Imposta la posizione e la dimensione della finestra principale
        this.setLocation(200, 100);
        this.setSize(300, 300);
        this.setVisible(true);
    }

    /**
     * Metodo principale che non viene utilizzato in questo esempio.
     */
    public static void main(String[] s) {
    }

    /**
     * Metodo per scrivere i dati di un atleta nel file "atleti.txt".
     *
     * @param a l'atleta da scrivere nel file.
     */
    private void WriteAtleta(Atleta a) {
        try {
            // Apre il file "atleti.txt" in modalità append (per non sovrascrivere)
            FileWriter filescritto = new FileWriter("atleti.txt", true);
            filescritto.write(a.toString() + "\n");  // Scrive i dati dell'atleta nel file
            filescritto.close();  // Chiude il file
        } catch (IOException e) {
            e.printStackTrace();  // Gestione degli errori di I/O
        }
    }

    public static Atleta cercaAtleta(String nomeDaCercare) {
        try (BufferedReader br = new BufferedReader(new FileReader("atleti.txt"))) {
            String riga;
            while ((riga = br.readLine()) != null) {
                String[] dati = riga.split(",");
                if (dati.length == 3) {
                    String nome = dati[0].trim();
                    String cognome = dati[1].trim();
                    String ruolo = dati[2].trim();

                    if (nome.equalsIgnoreCase(nomeDaCercare)) {
                        return new Atleta(nome, cognome, ruolo);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Metodo per scrivere i dati di un membro della dirigenza nel file
     * "dirigenti.txt".
     *
     * @param d il dirigente da scrivere nel file.
     */
    private void WriteDir(Dirigenza d) {
        try {
            // Apre il file "dirigenti.txt" in modalità append (per non sovrascrivere)
            FileWriter filescritto = new FileWriter("dirigenti.txt", true);
            filescritto.write(d.toString() + "\n");  // Scrive i dati del dirigente nel file
            filescritto.close();  // Chiude il file
        } catch (IOException e) {
            e.printStackTrace();  // Gestione degli errori di I/O
        }
    }

    public static Dirigenza cercaDirigente(String nomeDaCercare) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("dirigenti.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] dati = line.split(",");
                if (dati.length == 3) {
                    String nome = dati[0].trim();
                    String cognome = dati[1].trim();
                    String ruolo = dati[2].trim();

                    if (nome.equalsIgnoreCase(nomeDaCercare)) {
                        reader.close();
                        return new Dirigenza(nome, cognome, ruolo);
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Se non trovato
    }

    /**
     * Classe per gestire gli eventi dei pulsanti nella GUI.
     */
    class GestBottone implements ActionListener {

        /**
         * Metodo per gestire gli eventi di clic sui pulsanti.
         */
        public void actionPerformed(ActionEvent E) {

            // Gestione del pulsante "Aggiungi membri staff" (S)
            if (E.getSource() == S) {
                G.setVisible(false);  // Nasconde il bottone "Aggiungi atleta"
                S.setVisible(false);  // Nasconde il bottone "Aggiungi membri staff"
                SrcS.setVisible(false);// Nasconde il bottone "Ricerca membri staff"
                SrcA.setVisible(false);// Nasconde il bottone "Ricerca atleta"
                wel.setText("Inserimento membro staff/dirigenza:");  // Modifica il testo dell'etichetta

                // Rende visibili i campi per inserire i dati
                uno.setVisible(true);
                due.setVisible(true);
                tre.setVisible(true);
                nome.setVisible(true);
                cognome.setVisible(true);
                ruolo.setVisible(true);
                send.setVisible(true);
            }

            // Gestione del pulsante "Aggiungi atleta" (G)
            if (E.getSource() == G) {
                G.setVisible(false);  // Nasconde il bottone "Aggiungi atleta"
                S.setVisible(false);  // Nasconde il bottone "Aggiungi membri staff"
                SrcS.setVisible(false);// Nasconde il bottone "Ricerca membri staff"
                SrcA.setVisible(false);// Nasconde il bottone "Ricerca atleta"
                wel.setText("Inserimento calciatore:");  // Modifica il testo dell'etichetta

                // Rende visibili i campi per inserire i dati
                uno.setVisible(true);
                due.setVisible(true);
                tre.setVisible(true);
                nome.setVisible(true);
                cognome.setVisible(true);
                ruolo.setVisible(true);
                send.setVisible(true);
            }
            // Gestione del pulsante "Ricerca membri staff"(SrcS)
            if (E.getSource() == SrcS) {
                G.setVisible(false);  // Nasconde il bottone "Aggiungi atleta"
                S.setVisible(false);  // Nasconde il bottone "Aggiungi membri staff"
                SrcS.setVisible(false);// Nasconde il bottone "Ricerca membri staff"
                SrcA.setVisible(false);// Nasconde il bottone "Ricerca atleta"
                wel.setText("Ricerca membro staff/dirigenza:");  // Modifica il testo dell'etichetta

                // Rende visibili i campi per inserire i dati
                uno.setVisible(true);
                nome.setVisible(true);
                send.setVisible(true);
            }
            // Gestione del pulsante "Ricerca atleta"(SrcA)
            if (E.getSource() == SrcA) {
                G.setVisible(false);  // Nasconde il bottone "Aggiungi atleta"
                S.setVisible(false);  // Nasconde il bottone "Aggiungi membri staff"
                SrcS.setVisible(false);// Nasconde il bottone "Ricerca membri staff"
                SrcA.setVisible(false);// Nasconde il bottone "Ricerca atleta"
                wel.setText("Ricerca calciatore:");  // Modifica il testo dell'etichetta

                // Rende visibili i campi per inserire i dati
                uno.setVisible(true);
                nome.setVisible(true);
                send.setVisible(true);
            }

            // Gestione del pulsante "Invia dati" (send)
            if (E.getSource() == send) {
                // Raccogli i dati dai JTextField e assegna valori predefiniti se vuoti
                String temp1;
                if (uno.getText().isEmpty()) {
                    temp1 = "vuoto";  // Se il campo nome è vuoto, assegna "vuoto"
                } else {
                    temp1 = uno.getText();
                }

                String temp2;
                if (due.getText().isEmpty()) {
                    temp2 = "vuoto";  // Se il campo cognome è vuoto, assegna "vuoto"
                } else {
                    temp2 = due.getText();
                }

                String temp3;
                if (tre.getText().isEmpty()) {
                    temp3 = "vuoto";  // Se il campo ruolo è vuoto, assegna "vuoto"
                } else {
                    temp3 = tre.getText();
                }

                // Aggiungi i dati alla lista club a seconda del tipo di membro
                if (wel.getText().contains("Inserimento membro staff/dirigenza:")) {
                    Dirigenza d = new Dirigenza(temp1, temp2, temp3);
                    club.add(d);  // Aggiungi il membro staff alla lista
                    WriteDir(d);  // Scrivi i dati nel file dei dirigenti
                    System.out.println("Aggiunto membro staff/dirigenza: " + d);
                } else if (wel.getText().contains("Inserimento calciatore:")) {
                    Atleta a = new Atleta(temp1, temp2, temp3);
                    club.add(a);  // Aggiungi l'atleta alla lista
                    WriteAtleta(a);  // Scrivi i dati nel file degli atleti
                    System.out.println("Aggiunto calciatore: " + a);
                } else if (wel.getText().contains("Ricerca membro staff/dirigenza:")) {
                    Dirigenza trovato = cercaDirigente(temp1);
                    if (trovato != null) {
                        JOptionPane.showMessageDialog(null, "Dirigente presente:\n" + trovato);
                    } else {
                        JOptionPane.showMessageDialog(null, "Dirigente non trovato,riprovare");
                    }

                } else if (wel.getText().contains("Ricerca calciatore:")) {
                    Atleta trovato = cercaAtleta(temp1);
                    if (trovato != null) {
                        JOptionPane.showMessageDialog(null, "Atleta presente:\n" + trovato);
                    } else {
                        JOptionPane.showMessageDialog(null, "Atleta non trovato,riprovare");
                    }
                }

                // Resetta i campi di input
                uno.setText("");
                due.setText("");
                tre.setText("");

                // Ripristina la visibilità dei pulsanti
                G.setVisible(true);
                S.setVisible(true);
                SrcS.setVisible(true);
                SrcA.setVisible(true);

                // Nascondi i campi di inserimento e il pulsante send
                uno.setVisible(false);
                due.setVisible(false);
                tre.setVisible(false);
                nome.setVisible(false);
                cognome.setVisible(false);
                ruolo.setVisible(false);
                send.setVisible(false);

                // Ripristina il messaggio di benvenuto
                wel.setText("Benvenuto nella gestione della società");
            }

            // Gestione del pulsante "TORNA ALL'INIZIO" (exit)
            if (E.getSource() == exit) {
                G.setVisible(true);  // Rende visibile il bottone "Aggiungi atleta"
                S.setVisible(true);  // Rende visibile il bottone "Aggiungi membri staff"
                SrcS.setVisible(true);// Rende visibile il bottone "Ricerca membri staff"
                SrcA.setVisible(true);// Rende visibile il bottone "Ricerca atleta"
                wel.setText("Benvenuto nella gestione della società");  // Ripristina il messaggio di benvenuto
                uno.setVisible(false);
                due.setVisible(false);
                tre.setVisible(false);
                nome.setVisible(false);
                cognome.setVisible(false);
                ruolo.setVisible(false);
                send.setVisible(false);
            }
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proggestioneclub;

/**
 *
 * @author andrea.nicolai
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChiudiWin extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        // Codice per la chiusura della finestra
        System.out.println("La finestra sta per essere chiusa.");
        System.exit(0);  // Chiude l'applicazione
    }
}

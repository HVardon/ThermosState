package rodez.iut.thermosstate;

import java.util.Calendar;
import java.util.Date;

/** Classe qui gère un horaire exprimé en heures, minutes et secondes*/
public class Horaire {

    private long heure, minute, seconde;

    // Instanciation du calendrié
    Calendar cal = Calendar.getInstance();

    /** Constructeur par défaut */
    public Horaire() {
        heure = 0;
        minute = 0;
        seconde = 0;
    }

    /**
     * Constructeur qui initialise l'horaire courant avec celui donné en
     * argument
     * @param heure   nombre d'heures
     * @param minute  nombre de minutes
     * @param seconde nombre de secondes
     */
    public Horaire(long heure, long minute, long seconde) {

        this.heure = heure;
        this.minute = minute;
        this.seconde = seconde;
    }

    /* Getter pour seconde */
    public long getSeconde() {
        return seconde;
    }

    /* Getter pour minute */
    public long getMinute() {
        return minute;
    }

    /* Getter pour heure */
    public long getHeure() {
        return heure;
    }

    /* Setter pour seconde */
    public void setSeconde(long seconde) {
        this.seconde = seconde;
    }

    /* Setter pour minute */
    public void setMinute(long minute) {
        this.minute = minute;
    }

    /* Setter pour heure */
    public void setHeure(long heure) {
        this.heure = heure;
    }

    /**
     * Transforme l'horaire courant en une chaîne dans le format heure:minute
     * @return une chaîne contenant l'horaire
     */
    public String horaireToString() {
        return heure + ":" + minute + ":" + seconde;
    }

    //horaire actuelle
    public static String horaireAct() {

        // Instanciation du calendrié
        Calendar cal = Calendar.getInstance();
        int heure = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int seconde = cal.get(Calendar.SECOND);
        return (new Horaire(heure,minute,seconde).horaireToString());
    }



}

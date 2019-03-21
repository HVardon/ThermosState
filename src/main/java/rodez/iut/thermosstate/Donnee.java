/**
 *
 */
package rodez.iut.thermosstate;

import java.io.Serializable;
import java.util.Date;

/**
 * Une donnée est représentée par une date et une température.
 * La date sera gérée par la classe Date fournie dans le JDK.
 * La température sera de type double.
 * @author Matthiou
 *
 */
public class Donnee implements Serializable {

    /**
     * Numéro de version pour la sérialisation
     */
    private static final long serialVersionUID = 4753360660415950573L;

    /** Date à laquelle a été relevée la température */
    private Date date;

    /** Valeur de la température */
    private double temperature;

    /**
     * Constructeur par défaut
     */
    @SuppressWarnings("deprecation")
    public Donnee() {
        this.date = new Date(119,0,1,0,0,0); // Date(année,mois,jour,heure,minute,seconde)
        // pour l'année : année - 1900 ; mois entre 0 et 11
        this.temperature = Double.NaN;
    }

    /**
     * Constructeur avec valeurs
     * @param laDate date à laquelle a été effectué le relevé
     * @param laTemperature
     */
    public Donnee(Date laDate, double laTemperature) {
        this.date = laDate;
        this.temperature = laTemperature;
    }

    /**
     * Renvoie la date du relevé
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Fixe la date du relevé
     * @param date la date à attribuer
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Renvoie la température relevée
     * @return the temperature
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Fixe la température relevée
     * @param temperature la température à attribuer
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * *** Méthode utilisée pour les test ***
     * Renvoie une donnée sous forme de chaîne de caractères.
     */
    public String toString() {
        return ("Date relevé : "
                + this.date.toString()
                + " ; Température : "
                + this.temperature);
    }
}

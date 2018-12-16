package rodez.iut.thermosstate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Classe permettant de traiter des fichiers texte
 */
public class LectureFichier {


    /**
     * Détermine le nombre de lignes du fichier
     * @param nomFichier le nom du fichier source
     * @return le nombre de lignes
     */
    public static int lignesFichier(String nomFichier) {

        String ligne = ""; //ligne lue dans le fichier
        int nbLignes = 0;

        try {
            /* Déclaration et création de l'objet fichier */
            BufferedReader fichier = new BufferedReader(new FileReader(nomFichier + ".txt"));

            /* Lit le fichier */
            do {
                ligne = fichier.readLine(); // lecture d'une ligne

                if (ligne != null) {
                    nbLignes++;
                }
            } while (ligne != null);

            fichier.close(); // ferme le fichier
        } catch (IOException e) {
            System.out.println("Problème d'accès au fichier");
        }
        return nbLignes;
    }

    /**
     * Lit le fichier texte puis fourni un tableau de dates
     * @param nomFichier le nom du fichier source
     * @return le tableau de dates
     */
    public static Date[] datesFichier(String nomFichier) {

        String ligne = ""; //ligne lue dans le fichier
        String tab = "\t";
        Date[] dates = new Date[lignesFichier(nomFichier)]; // les dates du fichier
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int index = 0;

        try {
            /* Déclaration et création de l'objet fichier */
            BufferedReader fichier = new BufferedReader(new FileReader(nomFichier + ".txt"));

            /* Lit le fichier */
            do {
                ligne = fichier.readLine(); // lecture d'une ligne

                if (ligne != null) {
                    dates[index] = format.parse(ligne.substring(0,ligne.indexOf(tab)));
                }
                index++;
            } while (ligne != null);

            fichier.close();  // ferme le fichier
        } catch (IOException e) {
            System.out.println("Problème d'accès au fichier");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dates;
    }

    /**
     * Lit le fichier texte puis fourni un tableau de température
     */
    public static Double[] tempFichier(String nomFichier) {

        String ligne = ""; //ligne lue dans le fichier
        String tab = "\t";
        Double[] temperatures = new Double[lignesFichier(nomFichier)]; // les températures du fichier
        int index = 0;

        try {
            /* Déclaration et création de l'objet fichier */
            BufferedReader fichier = new BufferedReader(new FileReader(nomFichier + ".txt"));

            /* Lit le fichier */
            do {
                ligne = fichier.readLine(); // lecture d'une ligne

                if (ligne != null) {
                    temperatures[index] = Double.valueOf(ligne.substring(ligne.indexOf(tab)+tab.length()));
                }
                index++;
            } while (ligne != null);

            fichier.close();  // ferme le fichier
        } catch (IOException e) {
            System.out.println("Problème d'accès au fichier");
        }
        return temperatures;
    }


    //TEST
    public static void main(String[] args) {

        System.out.println(lignesFichier("Temperature"));
        for(int i=0;i<lignesFichier("Temperature");i++) {
            System.out.println((datesFichier("Temperature"))[i]);
        }

    }

}

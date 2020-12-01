package cartes;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PaquetDeCartes {

    private final ArrayList<Carte> paquet;

    public PaquetDeCartes() {
        this.paquet = new ArrayList<>();
    }

    public int getNombreDeCartes() {
        return this.paquet.size();
    }

    public boolean estVide() {
        return this.paquet.isEmpty();
    }

    public int getValeur() {
        int s = 0;
        for (Carte i : this.paquet) {
            s += i.getValeur();
        }
        return s;
    }

    public String toString() {
        StringBuilder s = new StringBuilder(this.getNombreDeCartes() * 30);
        for (Carte i : this.paquet) {
            s.append(i.toString()).append(" ");
        }
        return s.toString();
    }

    public void ajouter(Carte... cartes) {
        Collections.addAll(this.paquet, cartes);
    }

    public void ajouter(PaquetDeCartes pdc) {
        this.paquet.addAll(pdc.paquet);
    }

    public void melanger() {
        Collections.shuffle(this.paquet);
    }

    public void retourner() {
        Collections.reverse(this.paquet);
    }

    public Carte getSommet() {
        if (this.estVide()) {
            return this.paquet.get(0);
        }
        return null;
    }

    public Carte piocher() {
        if (this.estVide()) {
            Carte c = this.paquet.get(0);
            this.paquet.remove(0);
            return c;
        }
        return null;
    }

    public void ecrire(String args) throws IOException {
        PrintWriter flotFiltre;
        FileWriter flot;
        File chemin = new File(args);
        boolean estLa = chemin.exists();
        if (estLa) {
            throw new IOException("Fichier déjà existant !");
        }
        try {
            flot = new FileWriter(args);
            flotFiltre = new PrintWriter(flot);
            int i = 0;
            while (i < this.getNombreDeCartes()) {
                switch (paquet.get(i).effet()) {
                    case 1:
                        flotFiltre.println("CarteChiffre " + this.paquet.get(i).getCouleur() + " " + this.paquet.get(i).getValeur());
                        break;
                    case 2:
                        flotFiltre.println("CarteChangementDeSens " + this.paquet.get(i).getCouleur());
                        break;
                    case 3:
                        flotFiltre.println("CarteJoker");
                        break;
                    case 4:
                        flotFiltre.println("CartePasseTonTour " + this.paquet.get(i).getCouleur());
                        break;
                    case 5:
                        flotFiltre.println("CartePlus2 " + this.paquet.get(i).getCouleur());
                        break;
                    case 6:
                        flotFiltre.println("CartePlus4");
                        break;
                }
                i++;
            }
            flotFiltre.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lire(String args) {
        File fichier;
        Scanner scan;
        fichier = new File(args);
        try {
            scan = new Scanner(fichier);
            while (scan.hasNextLine()) {
                scan.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
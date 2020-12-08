package cartes;

import uno.Uno;

import javax.annotation.Nonnull;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class PaquetDeCartes implements Iterable<Carte> {

    private final ArrayList<Carte> paquet;

    public PaquetDeCartes() {
        this.paquet = new ArrayList<>();
    }

    public ArrayList<Carte> getPaquet() {
        return paquet;
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

    public void ajouter(Carte... cartes) {
        Collections.addAll(this.paquet, cartes);
    }

    public void ajouter(PaquetDeCartes pdc) {
        this.paquet.addAll(pdc.paquet);
    }

    public void melanger() {
        Collections.shuffle(this.paquet);
    }

    public void retourner() { Collections.reverse(this.paquet); }

    public Carte getSommet() {
        if (this.estVide()) {
            return null;
        }
        return paquet.get(getNombreDeCartes()-1);
    }

    public Carte piocher() {
        if (!this.estVide()) {
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

    public void lire(String args) throws FileNotFoundException {
        FileReader file = new FileReader(args);
        BufferedReader buffer = new BufferedReader(file);
        String ligne;
        Uno uno = new Uno();
        try {
            while ((ligne = buffer.readLine()) != null) {
                String[] mots = ligne.split(" ");
                Couleur couleur = null;
                if (mots[0].equals("CarteChiffre")) {
                    if (mots[1].equals("Bleu")) {
                        couleur = Couleur.BLEU;
                    }
                    if (mots[1].equals("Rouge")) {
                        couleur = Couleur.ROUGE;
                    }
                    if (mots[1].equals("Jaune")) {
                        couleur = Couleur.JAUNE;
                    }
                    if (mots[1].equals("Vert")) {
                        couleur = Couleur.VERT;
                    }
                    this.ajouter(new CarteChiffre(uno, couleur, Integer.parseInt(mots[2])));
                }
                if (mots[0].equals("CarteChangementDeSens")) {
                    if (mots[1].equals("Bleu")) {
                        couleur = Couleur.BLEU;
                    }
                    if (mots[1].equals("Rouge")) {
                        couleur = Couleur.ROUGE;
                    }
                    if (mots[1].equals("Jaune")) {
                        couleur = Couleur.JAUNE;
                    }
                    if (mots[1].equals("Vert")) {
                        couleur = Couleur.VERT;
                    }
                    this.ajouter(new CarteChangementDeSens(uno, couleur));
                }
                if (mots[0].equals("CarteJoker")) {
                    this.ajouter(new CarteJoker(uno));
                }
                if (mots[0].equals("CartePasseTonTour")) {
                    if (mots[1].equals("Bleu")) {
                        couleur = Couleur.BLEU;
                    }
                    if (mots[1].equals("Rouge")) {
                        couleur = Couleur.ROUGE;
                    }
                    if (mots[1].equals("Jaune")) {
                        couleur = Couleur.JAUNE;
                    }
                    if (mots[1].equals("Vert")) {
                        couleur = Couleur.VERT;
                    }
                    this.ajouter(new CartePasseTonTour(uno, couleur));
                }
                if (mots[0].equals("CartePlus2")) {
                    if (mots[1].equals("Bleu")) {
                        couleur = Couleur.BLEU;
                    }
                    if (mots[1].equals("Rouge")) {
                        couleur = Couleur.ROUGE;
                    }
                    if (mots[1].equals("Jaune")) {
                        couleur = Couleur.JAUNE;
                    }
                    if (mots[1].equals("Vert")) {
                        couleur = Couleur.VERT;
                    }
                    this.ajouter(new CartePlus2(uno, couleur));
                }
                if (mots[0].equals("CartePlus4")) {
                    this.ajouter(new CartePlus4(uno));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Nonnull
    public Iterator<Carte> iterator() {
        return paquet.iterator();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(this.getNombreDeCartes() * 30);
        for (Carte i : this.paquet) {
            s.append(i.toString()).append("\n");
        }
        return s.toString();
    }
}
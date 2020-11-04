package cartes;

import java.util.*;

public class PaquetDeCartes {

    private ArrayList<Carte> paquet;

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
        for (Carte i : cartes) {
            this.paquet.add(i);
        }
    }

    public void ajouter(PaquetDeCartes pdc) {
        for (Carte i : pdc.paquet) {
            this.paquet.add(i);
        }
    }

    public void melanger() {
        Collections.shuffle(this.paquet);
    }

    public void retourner() {
        Collections.reverse(this.paquet);
    }

    public Carte getSommet() {
        if (!this.estVide()) {
            return this.paquet.get(0);
        }
        return null;
    }

    public Carte piocher() {
        if (!this.estVide()) {
            Carte c = this.paquet.get(0);
            this.paquet.remove(0);
            return c;
        }
        return null;
   }

}

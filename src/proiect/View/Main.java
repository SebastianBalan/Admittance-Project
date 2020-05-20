package proiect.View;

import proiect.Service.AdmitereServiciu;

import java.util.Scanner;

public class Main {

    Scanner sc = new Scanner(System.in);
    AdmitereServiciu ob = new AdmitereServiciu();

    public static void main(String[] args) {

        Main main = new Main();

        while(true) {
            main.meniu();
            int option = main.optiune();
            main.execute(option);
        }

    }

    public void meniu() {
        System.out.println("Alege o optiune!");
        System.out.println("1.Adauga un candidat");
        System.out.println("2.Listeaza toti candidatii ordonati crescator dupa nume");
        System.out.println("3.Listeaza toti candidatii neordonati");
        System.out.println("4.Cauta un candidat dupa nume");
        System.out.println("5.Numarul de candidati inscrisi pana acum ");
        System.out.println("6.Stergere candidat dupa nume");
        System.out.println("7.Numarul de locuri ramase");
        System.out.println("8.Listeaza toti candidatii ordonati descrescator dupa nume");
        System.out.println("9.Adauga candidatii din fisier");
        System.out.println("10.Adauga facultatile din fisier");
        System.out.println("11.Adauga examenele din fisier");
        System.out.println("12.Adauga examenele de bac din fisier");
        System.out.println("13.Salveaza un examen de bac in baza de date");
        System.out.println("14.Iesire");
    }

    public int optiune() {
        String s = sc.nextLine();
        return Integer.parseInt(s);
    }

    public void execute(int option) {
        switch (option) {
            case 1:
                ob.adaugareCandidat();
                break;
            case 2:
                ob.afisareSortareNume();
                break;
            case 3:
                ob.afisare();
                break;
            case 4:
                ob.cautareDupaNume();
                break;
            case 5:
                ob.candidatiInscrisi();
                break;
            case 6:
                ob.stergereCandidatNume();
                break;
            case 7:
                ob.locuriRamase();
                break;
            case 8:
                ob.afisareSortareDescrNume();
                break;
            case 9:
                ob.adaugaCandidatiFisier();
                break;
            case 10:
                ob.adaugaFacultatiFisier();
                break;
            case 11:
                ob.adaugaExamenFisier();
                break;
            case 12:
                ob.adaugaBacFisier();
                break;
            case 13:
                ob.bacToSave();
                break;
            case 14:
                System.exit(0);
        }
    }

}

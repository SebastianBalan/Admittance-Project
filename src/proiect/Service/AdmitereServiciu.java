package proiect.Service;

import proiect.Domain.*;
import proiect.Persistence.Persistenta;

import java.util.*;


public class AdmitereServiciu {

    private List<Candidat> candidatsList = new ArrayList<Candidat>();
    private Set<Candidat> candidatsSet = new HashSet<Candidat>();
    private Set<Facultate> facultateSet = new HashSet<>();
    private Set<Examen> examenSet = new HashSet<>();
    private Set<Bac> bacSet = new HashSet<>();

    private Persistenta persistenta = Persistenta.getInstance();

    private static final BacService bacService = BacService.getInstance();
    private static final CandidatService candidatService = CandidatService.getInstance();
    private static final ExamenService examenService = ExamenService.getInstance();
    private static final FacultateService facultateService = FacultateService.getInstance();

    public void bacToSave() { Bac bacToSave = bacService.saveBac(10, "scris");}

    public void bacToFind() {Bac bacToFind = bacService.findBac("scris");}

    public void bacUpdate() {
        Bac bacUpdate = new Bac(9, "oral");
        bacUpdate = bacService.updateBac(bacUpdate);
    }

    public void bacDelete() {
        boolean result = bacService.deleteBac(10);
    }

    public void adaugaBacFisier() {
        bacSet = persistenta.readBacFromFile("bac.csv");
        persistenta.writeToFile("bac_registry");
    }

    public void adaugaExamenFisier() {
        examenSet = persistenta.readExamensFromFile("examens.csv");
        persistenta.writeToFile("examens_registry");
    }

    public void adaugaCandidatiFisier() {
        candidatsList = persistenta.readPersonsFromFile("candidati.txt");
        persistenta.writeToFile("candidats_registery");
    }

    public void adaugaFacultatiFisier() {
        facultateSet = persistenta.readFacultiesFromFile("facultati.txt");
        persistenta.writeToFile("faculties_registery");
    }

    public void adaugareCandidat() {
        Candidat candidat = new Candidat();
        Scanner sc = new Scanner(System.in);

        System.out.println("Dati numele candidatului");
        String nume = sc.nextLine();
        candidat.setNume(nume);

        System.out.println("Dati varsta candidatului");
        int varsta = sc.nextInt();
        candidat.setVarsta(varsta);

        System.out.println("Dati media din BAC a candidatului");
        float media = sc.nextFloat();
        candidat.setMedieBac(media);

        System.out.println("Dati nota din examen a candidatului");
        float nota = sc.nextFloat();
        candidat.setMedieBac(nota);

        candidatsList.add(candidat);
        candidatsSet.add(candidat);
    }

    public void afisareSortareNume() {
        CandidatNumeComparator candidatNumeComparator = new CandidatNumeComparator();
        Collections.sort(candidatsList,candidatNumeComparator);
        for ( Candidat candidat : candidatsList ) {
            candidat.afisare();
        }
    }

    public void afisare() {

        for ( Candidat candidat : candidatsSet ) {
            candidat.afisare();
        }
    }

    public void cautareDupaNume() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dati numele candidatului cautat ");
        String nume = sc.nextLine();

        int gasit = 0;
        for (Candidat candidat : candidatsList) {
            String aux = candidat.getNume();
                if (aux.equalsIgnoreCase(nume)==true){
                    System.out.println("Candidatul a fost inscris");
                    gasit = 1;
                    break;
                }
            }
        if(gasit==0) {
            System.out.println("Candidatul nu a fost inscris");
        }
    }

    public void candidatiInscrisi() {
        System.out.println(candidatsSet.size());
    }

    public void stergereCandidatNume() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dati numele candidatului ");
        String nume = sc.nextLine();

        for (Candidat candidat : candidatsList) {
            if (candidat.getNume().equalsIgnoreCase(nume) == true) {
                candidatsList.remove(candidat);
                candidatsSet.remove(candidat);
                System.out.println("Candidat scos cu succes!");
                break;
            }
        }
    }

    public void locuriRamase() {
        System.out.println(300-candidatsSet.size());
    }

    public void afisareSortareDescrNume() {

        for ( int i=candidatsList.size()-1;i>=0;i-- ) {
            candidatsList.get(i).afisare();
        }
    }
}

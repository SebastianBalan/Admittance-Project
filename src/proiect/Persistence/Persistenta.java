package proiect.Persistence;
import proiect.Domain.Bac;
import proiect.Domain.Candidat;
import proiect.Domain.Examen;
import proiect.Domain.Facultate;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;

public class Persistenta {

    private static Persistenta citireScriere = null;
    private Persistenta() {}

    public static Persistenta getInstance()
    {
        if (citireScriere == null)
            citireScriere = new Persistenta();

        return citireScriere;
    }

    public List<Candidat> readPersonsFromFile(String file) {
        String[] data;
        List<Candidat> candidats = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                data = currentLine.split(",");
                Candidat candidat = new Candidat();
                candidat.setNume(data[0]);
                candidat.setVarsta(Integer.parseInt(data[1]));
                candidat.setMedieBac(Float.parseFloat(data[2]));
                candidat.setNotaExamen(Float.parseFloat(data[3]));
                candidats.add(candidat);
            }
        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return candidats;
        }
        System.out.println("Successfully read!");
        return candidats;
    }

    public void writeToFile(String action) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            File file = new File("audit.csv");

            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);

            bw.write(action + "," + timestamp);
            bw.newLine();


        } catch (IOException e) {
            System.out.println("Could not write data to file: " + e.getMessage());
            return;
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }
        System.out.println("Successfully wrote.");
    }

    public Set<Facultate> readFacultiesFromFile(String file) {
        String[] data;
        Set<Facultate> faculties = new HashSet<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                data = currentLine.split(",");
                Facultate facultate = new Facultate(data[0],data[1],Integer.parseInt(data[2]));
                faculties.add(facultate);
            }
        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return faculties;
        }
        System.out.println("Successfully read!");
        return faculties;
    }

    public Set<Examen> readExamensFromFile(String file) {
        String[] data;
        Set<Examen> examens = new HashSet<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                data = currentLine.split(",");
                Examen examen = new Examen(data[0],Float.parseFloat(data[1]));
                examens.add(examen);
            }
        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return examens;
        }
        System.out.println("Successfully read!");
        return examens;
    }

    public Set<Bac> readBacFromFile(String file) {
        String[] data;
        Set<Bac> bacs = new HashSet<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                data = currentLine.split(",");
                Bac bac = new Bac(Integer.parseInt(data[0]),data[1]);
                bacs.add(bac);
            }
        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return bacs;
        }
        System.out.println("Successfully read!");
        return bacs;
    }
}
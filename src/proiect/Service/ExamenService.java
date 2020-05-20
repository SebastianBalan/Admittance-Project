package proiect.Service;

import proiect.Repository.ExamenRepository;
import proiect.Domain.Examen;

public class ExamenService {

    private static ExamenService instance;

    private final ExamenRepository examenRepository = ExamenRepository.getInstance();

    private ExamenService(){}

    public static ExamenService getInstance() {
        if(instance==null) {
            instance = new ExamenService();
        }

        return instance;
    }

    public Examen saveExamen(String tipExamen, float notaExamen) {
        Examen examen = new Examen();
        examen.setMedieExamen(notaExamen);
        examen.setTipExamen(tipExamen);

        return examenRepository.saveExamen(examen);
    }

    public Examen findExamen(String tipExamen) {return examenRepository.findExamen(tipExamen);}

    public Examen updateExamen(Examen examen){return examenRepository.updateExamen(examen);}

    public boolean deleteExamen(float notaExamen) {return examenRepository.deleteExamen(notaExamen);}


}

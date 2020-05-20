package proiect.Repository;

import proiect.Connection.DatabaseConnection;
import proiect.Domain.Examen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamenRepository {

    private static ExamenRepository instance;

    private static final String INSERT_STATEMENT = "INSERT INTO examens (tipExamen, medieExamen) VALUES (?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM examens WHERE tipExamen = ?";
    private static final String UPDATE_STATEMENT = "UPDATE examens SET medieExamen = ? WHERE tipExamen = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM examens WHERE medieExamen = ?";

    private ExamenRepository() {}

    public static ExamenRepository getInstance() {
        if (instance == null) {
            instance = new ExamenRepository();
        }

        return instance;
    }

    public Examen saveExamen(Examen examen) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setString(1, examen.getTipExamen());
            statement.setFloat(2, examen.getMedieExamen());

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new examen was inserted");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new examen: " + e.getMessage());
            return new Examen();
        }
        return examen;
    }

    public Examen findExamen(String tipExamen) {
        Examen examen = new Examen();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, tipExamen);

            try (ResultSet result = statement.executeQuery()) {
                if(!result.next()) {
                    System.out.println("Somenthing went wrong when trying to find that examen: Wasn't found");
                    return examen;
                }

                System.out.println("Examen wasn't found");
                examen.setTipExamen(result.getString("tipExamen"));
                examen.setMedieExamen(result.getFloat("medieExamen"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find a examen: " + e.getMessage());
        }
        return examen;
    }

    public Examen updateExamen(Examen examen) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setFloat(1, examen.getMedieExamen());
            statement.setString(2, examen.getTipExamen());

            int rowUpdated = statement.executeUpdate();
            if (rowUpdated > 0) {
                System.out.println("Examen was updated successfully");
                return examen;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update examen: " + e.getMessage());
            return new Examen();
        }

        System.out.println("Something went wrong when trying to update examen: Examen was not found!");
        return new Examen();
    }

    public boolean deleteExamen(float notaExamen) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setFloat(1, notaExamen);

            int rowDeleted = statement.executeUpdate();
            if (rowDeleted > 0) {
                System.out.println("Examen was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete examen: " + e.getMessage());
            return false;
        }
        System.out.println("Something went wrong when trying to delete examen: examen wasn't found!");
        return false;
    }

}

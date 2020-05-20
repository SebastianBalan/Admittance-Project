package proiect.Repository;

import proiect.Connection.DatabaseConnection;
import proiect.Domain.Candidat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidatRepository {
    private static CandidatRepository instance;

    private static final String INSERT_STATEMENT = "INSERT INTO candidati (nume, varsta, medieBac, notaExamen) VALUES (?, ?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM candidati WHERE nume = ?";
    private static final String UPDATE_STATEMENT = "UPDATE candidati SET medieBac = ? WHERE nume = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM candidati WHERE nume = ?";

    private CandidatRepository() {}

    public static CandidatRepository getInstance() {
        if (instance == null) {
            instance = new CandidatRepository();
        }

        return instance;
    }

    public Candidat saveCandidat(Candidat candidat) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setString(1, candidat.getNume());
            statement.setInt(2, candidat.getVarsta());
            statement.setFloat(3, candidat.getMedieBac());
            statement.setFloat(4, candidat.getNotaExamen());

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new candidat was inserted");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new candidat: " + e.getMessage());
            return new Candidat();
        }
        return candidat;
    }

    public Candidat findCandidat(String nume) {
        Candidat candidat = new Candidat();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, nume);

            try (ResultSet result = statement.executeQuery()) {
                if(!result.next()) {
                    System.out.println("Somenthing went wrong when trying to find that candidat: Wasn't found");
                    return candidat;
                }

                System.out.println("Candidat wasn't found");
                candidat.setNume(result.getString("nume"));
                candidat.setVarsta(result.getInt("varsta"));
                candidat.setMedieBac(result.getFloat("medieBac"));
                candidat.setNotaExamen(result.getFloat("notaExamen"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find a candidat: " + e.getMessage());
        }
        return candidat;
    }

    public Candidat updateCandidat(Candidat candidat) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setFloat(1, candidat.getMedieBac());
            statement.setString(2, candidat.getNume());

            int rowUpdated = statement.executeUpdate();
            if (rowUpdated > 0) {
                System.out.println("Candidat was updated successfully");
                return candidat;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update candidat: " + e.getMessage());
            return new Candidat();
        }

        System.out.println("Something went wrong when trying to update candidat: candidat was not found!");
        return new Candidat();
    }

    public boolean deleteCandidat(String nume) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setString(1, nume);

            int rowDeleted = statement.executeUpdate();
            if (rowDeleted > 0) {
                System.out.println("Candidat was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete candidat: " + e.getMessage());
            return false;
        }
        System.out.println("Something went wrong when trying to delete candidat: Candidat wasn't found!");
        return false;
    }
}

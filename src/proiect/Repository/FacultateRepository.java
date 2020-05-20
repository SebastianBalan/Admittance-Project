package proiect.Repository;

import proiect.Connection.DatabaseConnection;
import proiect.Domain.Facultate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultateRepository {

    private static FacultateRepository instance;

    private static final String INSERT_STATEMENT = "INSERT INTO facultati (nume, locatie, numarTotalLocuri) VALUES (?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM facultati WHERE nume = ?";
    private static final String UPDATE_STATEMENT = "UPDATE facultati SET numarTotalLocuri = ? WHERE nume = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM facultati WHERE nume = ?";

    private FacultateRepository() {}

    public static FacultateRepository getInstance() {
        if (instance == null) {
            instance = new FacultateRepository();
        }

        return instance;
    }

    public Facultate saveFaculty(Facultate facultate) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setString(1, facultate.getNume());
            statement.setString(2, facultate.getLocatie());
            statement.setInt(3, facultate.getNumarTotalLocuri());

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new faculty was inserted");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new faculty: " + e.getMessage());
            return new Facultate();
        }
        return facultate;
    }

    public Facultate findFaculty(String nume) {
        Facultate facultate = new Facultate();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, nume);

            try (ResultSet result = statement.executeQuery()) {
                if(!result.next()) {
                    System.out.println("Somenthing went wrong when trying to find that faculty: Wasn't found");
                    return facultate;
                }

                System.out.println("Faculty wasn't found");
                facultate.setNume(result.getString("nume"));
                facultate.setLocatie(result.getString("locatie"));
                facultate.setNumarTotalLocuri(result.getInt("numarTotalLocuri"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find a faculty: " + e.getMessage());
        }
        return facultate;
    }

    public Facultate updateFacultate(Facultate facultate) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setInt(1, facultate.getNumarTotalLocuri());
            statement.setString(2, facultate.getNume());

            int rowUpdated = statement.executeUpdate();
            if (rowUpdated > 0) {
                System.out.println("FAculty was updated successfully");
                return facultate;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update faculty: " + e.getMessage());
            return new Facultate();
        }

        System.out.println("Something went wrong when trying to update faculty: Faculty was not found!");
        return new Facultate();
    }

    public boolean deleteFacultate(String nume) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setString(1, nume);

            int rowDeleted = statement.executeUpdate();
            if (rowDeleted > 0) {
                System.out.println("Faculty was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete faculty: " + e.getMessage());
            return false;
        }
        System.out.println("Something went wrong when trying to delete faculty: faculty wasn't found!");
        return false;
    }

}

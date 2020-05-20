package proiect.Repository;

import proiect.Connection.DatabaseConnection;
import proiect.Domain.Bac;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class BacRepository {

    private static BacRepository instance;

    private static final String INSERT_STATEMENT = "INSERT INTO bac (notaBac, tipExamen) VALUES (?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM bac WHERE tipExamen = ?";
    private static final String UPDATE_STATEMENT = "UPDATE bac SET notaBac = ? WHERE tipExamen = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM bac WHERE notaBac = ?";

    private BacRepository() {}

    public static BacRepository getInstance() {
        if (instance == null) {
            instance = new BacRepository();
        }

        return instance;
    }

    public Bac saveBac(Bac bac) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setInt(1, bac.getNotaBac());
            statement.setString(2, bac.getTipExamen());

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new bac was inserted");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new bac: " + e.getMessage());
            return new Bac();
        }
        return bac;
    }

    public Bac findBac(String tipExamen) {
        Bac bac = new Bac();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, tipExamen);

            try (ResultSet result = statement.executeQuery()) {
                if(!result.next()) {
                    System.out.println("Somenthing went wrong when trying to find that bac: Wasn't found");
                    return bac;
                }

                System.out.println("Bac wasn't found");
                bac.setTipExamen(result.getString("tipExamen"));
                bac.setNotaBac(result.getInt("notaBac"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to find a bac: " + e.getMessage());
        }
        return bac;
    }

    public Bac updateBac(Bac bac) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setInt(1, bac.getNotaBac());
            statement.setString(2, bac.getTipExamen());

            int rowUpdated = statement.executeUpdate();
            if (rowUpdated > 0) {
                System.out.println("Bac was updated successfully");
                return bac;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update bac: " + e.getMessage());
            return new Bac();
        }

        System.out.println("Something went wrong when trying to update bac: bac was not found!");
        return new Bac();
    }

    public boolean deleteBac(int notaBac) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setInt(1, notaBac);

            int rowDeleted = statement.executeUpdate();
            if (rowDeleted > 0) {
                System.out.println("Bac was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete bac: " + e.getMessage());
            return false;
        }
        System.out.println("Something went wrong when trying to delete bac: Bac wasn't found!");
        return false;
    }
}

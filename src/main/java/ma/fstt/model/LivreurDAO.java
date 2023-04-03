package ma.fstt.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivreurDAO extends BaseDAO<Livreur>{
    public LivreurDAO() throws SQLException {

        super();
    }

    @Override
    public void save(Livreur object) throws SQLException {

        String request = "insert into livreur (nom , telephone) values (? , ?)";

        // mapping objet table

        this.preparedStatement = this.connection.prepareStatement(request);
        // mapping
        this.preparedStatement.setString(1 , object.getNom());

        this.preparedStatement.setString(2 , object.getTelephone());


        this.preparedStatement.execute();
    }

    @Override
    public void update(Livreur object) throws SQLException {
        Livreur livreur = object;

        {
            boolean modification = false;
            try {
                connection =this.preparedStatement.getConnection();
                String sql = "UPDATE Livreur SET nom = ?, telephone = ?, WHERE id_liv = ?";
                this.preparedStatement= this.connection.prepareStatement(sql);
                this.preparedStatement.setString(1, livreur.getNom());
                this.preparedStatement.setString(1, livreur.getTelephone());
                int rowsUpdated = this.preparedStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    modification = true;
                }
            } catch (SQLException ex) {
                System.out.println("Erreur lors de la modification du livreur : " + ex.getMessage());
            } finally {
                this.preparedStatement.close();
            }
        }

    }



    @Override
    public void delete(Livreur object) throws SQLException {
        Livreur livreur = object;
        boolean suppression = false;

        try {
            connection = this.preparedStatement.getConnection();
            String sql = "DELETE FROM Livreur WHERE id_liv = ?";
            statement = connection.prepareStatement(sql);
            this.preparedStatement.setLong(1, livreur.getId_livreur());
            int rowsDeleted = this.preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                suppression = true;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression du livreur : " + ex.getMessage());
        } finally {
            this.preparedStatement.close();
        }

    }




    @Override
    public List<Livreur> getAll()  throws SQLException {

        List<Livreur> mylist = new ArrayList<Livreur>();

        String request = "select * from livreur ";

        this.statement = this.connection.createStatement();

        this.resultSet =   this.statement.executeQuery(request);

// parcours de la table
        while ( this.resultSet.next()){

// mapping table objet
            mylist.add(new Livreur(this.resultSet.getLong(1) ,
                    this.resultSet.getString(2) , this.resultSet.getString(3)));


        }


        return mylist;
    }

    @Override
    public Livreur getOne(Long id) throws SQLException {
        return null;
    }

    @Override
    public Commande getOne(long id) throws SQLException {
        return null;
    }
}

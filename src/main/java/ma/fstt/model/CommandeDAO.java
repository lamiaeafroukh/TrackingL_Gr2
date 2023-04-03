package ma.fstt.model;

import  java.sql.SQLException;
import  java.util.List;
import  java.util.ArrayList;
import  java.lang.String;
import  java.sql.*;

public   class CommandeDAO extends BaseDAO <Commande>{
    public CommandeDAO() throws SQLException{
        super();
    }
    @Override
    public void save(Commande object ) throws  SQLException{
        String request=" INSERT INTO  Commande (id,date) VALUES (?,?) ";
        this.preparedStatement=this.connection.prepareStatement((request));
        this.preparedStatement.setDate(1, (Date) object.getDate());

        this.preparedStatement.execute();
    }
    @Override
    public void update(Commande object) throws  SQLException{
        Commande commande = object;

        {
            boolean modification = false;
            try {
                connection =this.preparedStatement.getConnection();
                String sql = "UPDATE Commande SET date= ?,  WHERE id = ?";
                this.preparedStatement= this.connection.prepareStatement(sql);
                this.preparedStatement.setDate(1, (java.sql.Date) commande.getDate());

                int rowsUpdated = this.preparedStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    modification = true;
                }
            } catch (SQLException ex) {
                System.out.println("Erreur lors de la modification du commande : " + ex.getMessage());
            } finally {
                this.preparedStatement.close();
            }
        }

    }
    @Override
    public void delete(Commande object) throws  SQLException{
       Commande commande = object;
        boolean suppression = false;

        try {
            connection = this.preparedStatement.getConnection();
            String sql = "DELETE FROM Commande WHERE id = ?";
            statement = connection.prepareStatement(sql);
            this.preparedStatement.setLong(1, commande.getId());
            int rowsDeleted = this.preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                suppression = true;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression du commande : " + ex.getMessage());
        } finally {
            this.preparedStatement.close();
        }
    }
    @Override
    public List<Commande> getAll() throws  SQLException{
        List<Commande> mylist=new ArrayList<Commande>();
        String request ="SELECT * FROM Commande";
        this.statement=this.connection.createStatement();
        this.resultSet=this.statement.executeQuery(request);
        while (this.resultSet.next()){
            mylist.add(new Commande(this.resultSet.getLong(1),
                    this.resultSet.getDate(2)));

        }
        return mylist;
    }

    @Override
    public Commande getOne(Long id) throws SQLException {
        return null;
    }

    @Override
    public Commande getOne(long id) throws SQLException {
        return null;
    }


}


package ma.fstt.model;

import java.sql.Date;
import  java.sql.SQLException;
import  java.util.List;
import  java.util.ArrayList;
import  java.lang.String;

public   class CreditDAO extends BaseDAO <Credit>{



    CreditDAO() throws SQLException {
        super();
    }

    @Override
    public void save(Credit object ) throws  SQLException{
        String request="insert into  Credit (id,montant,tauxInteret,duree,DateCredit,dateDebutRemboursement) values (?,?,?,?,?,?)";
        this.preparedStatement=this.connection.prepareStatement((request));
        this.preparedStatement.setDouble(1, object.getMontant());
        this.preparedStatement.setDouble(2, object.getTauxInteret());
        this.preparedStatement.setInt(3, object.getDuree());
        this.preparedStatement.setString(4, String.valueOf(object.getDateCredit()));
        this.preparedStatement.setString(5, String.valueOf(object.getDateDebutRemboursement()));
        this.preparedStatement.execute();
    }
    @Override
    public void update(Credit object) throws  SQLException{
        Credit credit = object;

        {
            boolean modification = false;
            try {
                connection =this.preparedStatement.getConnection();
                String sql = "UPDATE Livreur SET montant = ?, tauxInteret = ?,duree = ? ,DateCredit = ?,dateDebutRemboursement = ? WHERE id = ?";
                this.preparedStatement= this.connection.prepareStatement(sql);
                this.preparedStatement.setDouble(1, credit.getMontant());
                this.preparedStatement.setDouble(1, credit.getTauxInteret());
                this.preparedStatement.setInt(1, credit.getDuree());
                this.preparedStatement.setDate(1, (Date) credit.getDateCredit());
                this.preparedStatement.setDate(1, (Date) credit.getDateDebutRemboursement());
                int rowsUpdated = this.preparedStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    modification = true;
                }
            } catch (SQLException ex) {
                System.out.println("Erreur lors de la modification du credit : " + ex.getMessage());
            } finally {
                this.preparedStatement.close();
            }
        }
    }
    @Override
    public void delete(Credit object) throws  SQLException{
        Credit credit = object;
        boolean suppression = false;

        try {
            connection = this.preparedStatement.getConnection();
            String sql = "DELETE FROM Credit WHERE id = ?";
            statement = connection.prepareStatement(sql);
            this.preparedStatement.setLong(1, credit.getId());
            int rowsDeleted = this.preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                suppression = true;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression du credit : " + ex.getMessage());
        } finally {
            this.preparedStatement.close();
        }
    }@Override
    public List<Credit> getAll() throws  SQLException{
        List<Credit> mylist=new ArrayList<Credit>();
        String request ="SELECT * FROM Credit";
        this.statement=this.connection.createStatement();
        this.resultSet=this.statement.executeQuery(request);
        while (this.resultSet.next()){
            mylist.add(new Credit(this.resultSet.getLong(1),this.resultSet.getDouble(2),
                    this.resultSet.getDouble(3),
                    this.resultSet.getInt(4),
                    this.resultSet.getDate(5),
                    this.resultSet.getDate(6)));
        }
        return mylist;
    }

    @Override
    public Credit getOne(Long id) throws SQLException {
        return null;
    }

    @Override
    public Commande getOne(long id) throws SQLException {
        return null;
    }


}


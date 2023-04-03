package ma.fstt.model;

import  java.sql.SQLException;
import  java.util.List;
import  java.util.ArrayList;
import  java.lang.String;
import  java.sql.ResultSet;
public   class ProduitDAO extends BaseDAO <Produit>{
    public ProduitDAO() throws SQLException{
        super();
    }
    @Override
    public void save(Produit object ) throws  SQLException{
        String request="insert into  Produit (nom,prix,quantite) values (?,?,?)";
        this.preparedStatement=this.connection.prepareStatement((request));
        this.preparedStatement.setString(1, object.getNom());
        this.preparedStatement.setDouble(2, object.getPrix());
        this.preparedStatement.setInt(3, object.getQuantite());

        this.preparedStatement.execute();
    }
    @Override
    public void update(Produit object) throws  SQLException{
        Produit produit = object;

        {
            boolean modification = false;
            try {
                connection =this.preparedStatement.getConnection();
                String sql = "UPDATE Produit SET nom = ?, prix = ?,quantite=? WHERE Num_PRD = ?";
                this.preparedStatement= this.connection.prepareStatement(sql);
                this.preparedStatement.setString(1, produit.getNom());
                this.preparedStatement.setDouble(2, produit.getPrix());
                this.preparedStatement.setInt(3, produit.getQuantite());
                int rowsUpdated = this.preparedStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    modification = true;
                }
            } catch (SQLException ex) {
                System.out.println("Erreur lors de la modification du produit : " + ex.getMessage());
            } finally {
                this.preparedStatement.close();
            }
        }
    }
    @Override
    public void delete(Produit object) throws  SQLException{
        Produit produit = object;
        boolean suppression = false;

        try {
            connection = this.preparedStatement.getConnection();
            String sql = "DELETE FROM Produit WHERE Num_PRD = ?";
            statement = connection.prepareStatement(sql);
            this.preparedStatement.setLong(1, produit.getNum_PRD());
            int rowsDeleted = this.preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                suppression = true;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression du produit : " + ex.getMessage());
        } finally {
            this.preparedStatement.close();
        }

    }@Override
    public List<Produit> getAll() throws  SQLException{
        List<Produit> mylist=new ArrayList<Produit>();
        String request ="SELECT * FROM Produit";
        this.statement=this.connection.createStatement();
        this.resultSet=this.statement.executeQuery(request);
        while (this.resultSet.next()){
            mylist.add(new Produit(this.resultSet.getString(1),
                    this.resultSet.getDouble(2),
                    this.resultSet.getInt(3)));

        return mylist;
    }


        return mylist;
    }

    @Override
    public Produit getOne(Long id) throws SQLException {
        return null;
    }

    @Override
    public Commande getOne(long id) throws SQLException {
        return null;
    }


}


package ma.fstt.model;

import java.sql.SQLException;
import java.util.List;

public class Test {

    public static void main(String[] args) {

// trait bloc try catch
        try {


            LivreurDAO livreurDAO = new LivreurDAO();
          Livreur liv8 = new Livreur(8l , "liv8" , "500000000");

            livreurDAO.save(liv8);

            //Livreur liv2 = new Livreur(0l , "liv2" , "100000000");


           //livreurDAO.save(liv);


         // List<Livreur> livlist =  livreurDAO.getAll();

            //for (Livreur liv :livlist) {

              //  System.out.println(liv.toString());}



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}

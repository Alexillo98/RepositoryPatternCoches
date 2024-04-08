import java.sql.SQLException;

public class CocheService {
    static java.sql.Connection con;

    public static java.sql.Connection getCon(){
        String host = "jdbc:sqlite:src/main/resources/coche.sqlite";

        if (con == null){
            try {
                con = java.sql.DriverManager.getConnection(host);
            }catch (SQLException sql){
                System.out.println(sql.getMessage());
                System.exit(0);
            }
        }
        return con;
    }
}

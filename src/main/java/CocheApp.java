import java.sql.SQLException;
import java.util.List;

public class CocheApp {
    private static final CocheRepositoryImpl cocheRepository = new CocheRepositoryImpl();
    public static void main(String[] args) throws SQLException {
        List<Coche> coches = cocheRepository.findAll();
        coches.forEach(System.out::println);
    }
}

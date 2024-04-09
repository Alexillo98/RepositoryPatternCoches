
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CocheApp {
    private static final CocheRepositoryImpl cocheRepository = new CocheRepositoryImpl();
    public static void main(String[] args) throws SQLException {
//        List<Coche> coches = cocheRepository.findAll();
//        coches.forEach(System.out::println);

        int option;

        while (true){
            printMenu();
            option = getOption();

            if (option == 0) break;
            switch (option){
                case 1:
                    insertar();
                    break;
                case 2:
                    cocheRepository.delete(select());
                    ver();
                    break;
                case 3:
                    actualizar();
                    break;
                case 4:
                    ver();
                    break;

            }
        }
    }


    public static void printMenu(){
        System.out.println("____ ____ __   ____ ____ ___  ____ ____ __   ___  ____ ____ ____ ");
        System.out.println("| __\\|   || \\|\\| __\\| __\\| _\\ |___\\|   || \\|\\|  \\ | . \\|___\\|   |");
        System.out.println("| \\__| . ||  \\|| \\__|  ]_[__ \\| /  | . ||  \\|| . \\|  <_| /  | . |");
        System.out.println("|___/|___/|/\\_/|___/|___/|___/|/   |___/|/\\_/|/\\_/|/\\_/|/   |___/");
        System.out.println("_________________________________________________________________");
        System.out.println("0 SALIR  --  1 INSERTAR  --  2 ELIMINAR  --  3 ACTUALIZAR -- 4 VER");
        System.out.println("_________________________________________________________________");
    }

    public static int getOption(){
        Scanner escaner = new Scanner(System.in);
        return Integer.parseInt(escaner.next());
    }

    public static void insertar() throws SQLException {
        Scanner escaner = new Scanner(System.in);

        System.out.println("MARCA DE COCHE?:");
        String marca = escaner.nextLine();

        String query = "INSERT INTO coche (marca) VALUES (?)";
        PreparedStatement st = CocheService.con.prepareStatement(query);
        st.setString(1,marca);
        st.executeUpdate();
        ver();
    }

    public static void actualizar() throws SQLException {
        Scanner escaner = new Scanner(System.in);

        System.out.println("ID de coche a actualizar: ");
        int identificacion = Integer.parseInt(escaner.nextLine());

        System.out.println("Marca del coche: ");
        String marca = escaner.nextLine();

        String query = "UPDATE coche SET marca = ? WHERE id = ?";
        PreparedStatement st = CocheService.con.prepareStatement(query);
        st.setString(1,marca);
        st.setInt(2,identificacion);
        st.executeUpdate();

        ver();
    }

    public static void ver() throws SQLException {
        List<Coche> coches = cocheRepository.findAll();
        coches.forEach(System.out::println);
    }

    public static Coche select() throws SQLException {
        Scanner escaner = new Scanner(System.in);
        int id = Integer.parseInt(escaner.nextLine());
        Coche coche = cocheRepository.findById(id);
        return coche;
    }

}

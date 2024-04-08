import javax.swing.plaf.nimbus.State;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CocheRepositoryImpl implements IRepository<Coche> {

    private java.sql.Connection con;

    public CocheRepositoryImpl(){
        this.con = CocheService.getCon();
    }
    @Override
    public List<Coche> findAll() throws SQLException {
        List<Coche> coches = new ArrayList<>();

        Statement st = this.con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM coche");

        while (rs.next()){
            Coche coche = bdToEntity(rs);
            coches.add(coche);
        }
        return coches;
    }

    @Override
    public Coche findById(int id) throws SQLException {
        Coche coche = null;
        PreparedStatement st = con.prepareStatement("SELECT * FROM coche WHERE id = ?");
        st.setInt(1,id);

        ResultSet rs = st.executeQuery();

        if (rs.next()){
            coche = bdToEntity(rs);
        }
        return coche;
    }

    @Override
    public void save(Coche entity) throws SQLException {

    }

    @Override
    public void delete(Coche entity) throws SQLException {

    }

    @Override
    public Coche bdToEntity(ResultSet rs) throws SQLException {
        return new Coche(rs.getInt("id"),rs.getString("Marca"));
    }
}

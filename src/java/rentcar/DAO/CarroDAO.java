package rentcar.DAO;

/**
 *
 * @author LEONE
 */
import java.util.List;
import rentcar.UTIL.JavaWebException;
import rentcar.BEANS.Carro;

public interface CarroDAO {

    public void save(Carro c) throws JavaWebException;

    public List<Carro> getListaCarro() throws JavaWebException;

    public Carro getCarroById(int id) throws JavaWebException;

    //public void createTable() throws JavaWebException;
}
package rentcar.DAO;

/**
 *
 * @author LEONE
 */
import java.util.List;
import rentcar.UTIL.JavaWebException;
import rentcar.BEANS.Cliente;

public interface ClienteDAO {

    public void save(Cliente c) throws JavaWebException;

    public List<Cliente> getListaCliente() throws JavaWebException;

    public Cliente getClienteById(int id) throws JavaWebException;

    //public void createTable() throws JavaWebException;
}

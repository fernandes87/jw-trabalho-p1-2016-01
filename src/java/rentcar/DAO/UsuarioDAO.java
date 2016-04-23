package rentcar.DAO;

/**
 *
 * @author LEONE
 */
import java.util.List;
import rentcar.UTIL.JavaWebException;
import rentcar.BEANS.Usuario;

public interface UsuarioDAO {

    public void save(Usuario u) throws JavaWebException;

    //public List<Usuario> getListaUsuario() throws JavaWebException;

    public Usuario getUsuarioById(int cod_login) throws JavaWebException;

    //public void createTable() throws JavaWebException;
}

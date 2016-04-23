package rentcar.DAO;

/**
 *
 * @author LEONE
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rentcar.BEANS.Usuario;
import rentcar.UTIL.JavaWebException;

public class UsuarioDAOImpl{

    private final String INSERT_QUERY = "insert into login_tb (cod_login,usuario,senha) values (?,?,?)";
    private final String SELECT_ALL_QUERY = "select * from login_tb";
    private final String SELECT_USUARIO = "select * from login_tb where usuario = ? and senha = ?";
    public final void save(Usuario u) throws JavaWebException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement prepStmt = null;
        try {
            conn = GerenciadorConexoes.getConexao();
            prepStmt = conn.prepareStatement(INSERT_QUERY);
            prepStmt.setInt(1, u.getid());
            prepStmt.setString(2, u.getusuario());
            prepStmt.setString(3, u.getsenha());
            prepStmt.execute();
        } catch (SQLException e) {
            String msg = "[UsuarioDB][save(Usuario u)]: " + e.getMessage();
            JavaWebException ge = new JavaWebException(msg, e);
            throw ge;
        } finally {
            GerenciadorConexoes.closeAll(conn, prepStmt, rs);
        }
    }
    
    public Usuario getUsuario(String usuario, String senha) throws JavaWebException {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Usuario user = new Usuario(usuario,senha);
        
        try {
            
            conn = GerenciadorConexoes.getConexao();
            prepStmt = conn.prepareStatement(SELECT_USUARIO);
            prepStmt.setString(1, usuario);
            prepStmt.setString(2, senha);
            rs = prepStmt.executeQuery();
            if (rs.next()) { 
                
                return user;
            }
        } catch (SQLException e) {
            String msg = "[UsuarioDB][getUsuarioById()]: " + e.getMessage();
            JavaWebException ge = new JavaWebException(msg, e);
            throw ge;
        } finally {
            GerenciadorConexoes.closeAll(conn, prepStmt, rs);
        }
        return user;
    }

    /*
    public void createTable() throws JavaWebException {
        Connection conn = null;
        Statement stmt = null;
        try {

            conn = GerenciadorConexoes.getConexao();
            stmt = conn.createStatement();
            stmt.executeUpdate(CREATE_TABLE);

            Produto[] produtos = {
                new Produto(86, "Maquina fotografica", "maqFot001", "Maquina fotografica", 80, "maqFot001.gif"),
                new Produto(85, "CD - Meu Reino Encantado", "cd003", "Daniel", 18, "cd003.gif"),
                new Produto(82, "TV 29", "tv29philips", "29' Tela Plana", 1750, "tv001.gif"),
                new Produto(83, "CD - As Gargantas do Brasil", "cd001", "Milionario e Jose Rico", 13, "cd001.gif"),
                new Produto(79, "CD - Ta Nervoso...Vai Pesca", "cd002", "Ataide & Alexandre", 15, "cd002.gif")
            };

            String insertComId = "insert into produtos (nome,codigo,preco,descricao,image,id) values (?,?,?,?,?,?)";
            PreparedStatement prepStmt = conn.prepareStatement(insertComId);
            for (int i = 0; i < produtos.length; i++) {
                Produto p = produtos[i];
                prepStmt.setString(1, p.getNome());
                prepStmt.setString(2, p.getCodigo());
                prepStmt.setDouble(3, p.getPreco());
                prepStmt.setString(4, p.getDescricao());
                prepStmt.setString(5, p.getImage());
                prepStmt.setInt(6, p.getId());
                prepStmt.execute();
                prepStmt.clearParameters();
            }
            prepStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new JavaWebException("Erro ao criar a tabela de produtos", e);
        } finally {
            GerenciadorConexoes.closeAll(conn, stmt);
        }
    }
    */
}

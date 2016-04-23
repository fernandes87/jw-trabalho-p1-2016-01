package rentcar.DAO;

/**
 *
 * @author LEONE
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import rentcar.BEANS.Cliente;
import rentcar.UTIL.JavaWebException;

public class ClienteDAOImpl implements ClienteDAO {

    private final String INSERT_QUERY = "insert into cliente_tb (cod_cliente,nom_cliente,num_cpf,telefone,email) values (?,?,?,?,?)";
    private final String SELECT_ALL_QUERY = "select * from cliente_tb";
    private final String SELECT_BY_ID_QUERY = "select * from cliente_tb where cod_cliente = ? ";
    public final void save(Cliente c) throws JavaWebException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement prepStmt = null;
        try {
            conn = GerenciadorConexoes.getConexao();
            prepStmt = conn.prepareStatement(INSERT_QUERY);
            prepStmt.setInt(1, c.getid());
            prepStmt.setString(2, c.getnome());
            prepStmt.setString(3, c.getcpf());
            prepStmt.setString(4, c.gettelefone());
            prepStmt.setString(5, c.getemail());
            prepStmt.execute();
        } catch (SQLException e) {
            String msg = "[ClienteDB][save(Cliente c)]: " + e.getMessage();
            JavaWebException ge = new JavaWebException(msg, e);
            throw ge;
        } finally {
            GerenciadorConexoes.closeAll(conn, prepStmt, rs);
        }
    }

    
    public List<Cliente> getListaCliente() throws JavaWebException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Cliente> listaCliente = new ArrayList<Cliente>();
        try {
            conn = GerenciadorConexoes.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SELECT_ALL_QUERY);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                Cliente c = new Cliente(id, nome, cpf, telefone, email);
                listaCliente.add(c);
            }
        } catch (SQLException e) {
            String msg = "[ClienteDB][getListaCliente()]: " + e.getMessage();
            JavaWebException ge = new JavaWebException(msg, e);
            throw ge;
        } finally {
            GerenciadorConexoes.closeAll(conn, stmt, rs);
        }
        return listaCliente;
    }
    
    public Cliente getClienteById(int id) throws JavaWebException {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Cliente oCliente = null;
        try {
            conn = GerenciadorConexoes.getConexao();
            prepStmt = conn.prepareStatement(SELECT_BY_ID_QUERY);
            prepStmt.setInt(1, id);
            rs = prepStmt.executeQuery();
            if (rs.next()) {
                //int cod_login = rs.getInt("cod_login");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                oCliente = new Cliente(id, nome, cpf, telefone, email);
            }
        } catch (SQLException e) {
            String msg = "[ClienteDB][getClienteById()]: " + e.getMessage();
            JavaWebException ge = new JavaWebException(msg, e);
            throw ge;
        } finally {
            GerenciadorConexoes.closeAll(conn, prepStmt, rs);
        }
        return oCliente;
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

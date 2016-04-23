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
import rentcar.BEANS.Carro;
import rentcar.UTIL.JavaWebException;

public class CarroDAOImpl implements CarroDAO {

    private final String INSERT_QUERY = "insert into carro_tb (cod_carro,modelo_carro,marca_carro,ano_carro,disponivel, ar, qtde_porta, direcao_hid, valor_diaria ) values (?,?,?,?,?,?,?,?,?)";
    private final String SELECT_ALL_QUERY = "select * from carro_tb";
    private final String SELECT_BY_ID_QUERY = "select * from carro_tb where cod_carro = ? ";
    public final void save(Carro a) throws JavaWebException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement prepStmt = null;
        try {
            conn = GerenciadorConexoes.getConexao();
            prepStmt = conn.prepareStatement(INSERT_QUERY);
            prepStmt.setInt(1, a.getid());
            prepStmt.setString(2, a.getmodelo());
            prepStmt.setString(3, a.getmarca());
            prepStmt.setString(4, a.getano());
            prepStmt.setString(5, a.getdisponivel());
            prepStmt.setString(6, a.getar());
            prepStmt.setInt(7, a.getporta());
            prepStmt.setString(8, a.getdirecao());
            prepStmt.setDouble(9, a.getvalor());
            prepStmt.execute();
        } catch (SQLException e) {
            String msg = "[CarroDB][save(Carro a)]: " + e.getMessage();
            JavaWebException ge = new JavaWebException(msg, e);
            throw ge;
        } finally {
            GerenciadorConexoes.closeAll(conn, prepStmt, rs);
        }
    }

    
    public List<Carro> getListaCarro() throws JavaWebException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Carro> listaCarro = new ArrayList<Carro>();
        try {
            conn = GerenciadorConexoes.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SELECT_ALL_QUERY);
            while (rs.next()) {
                int id = rs.getInt("id");
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                String ano = rs.getString("ano");
                String disponivel = rs.getString("disponivel");
                String ar = rs.getString("ar");
                int porta = rs.getInt("porta");
                String direcao = rs.getString("direcao");
                double valor = rs.getDouble("valor");
                Carro a = new Carro(id, modelo, marca, ano, disponivel, ar, porta, disponivel, valor);
                listaCarro.add(a);
            }
        } catch (SQLException e) {
            String msg = "[CarroDB][getListaCarro()]: " + e.getMessage();
            JavaWebException ge = new JavaWebException(msg, e);
            throw ge;
        } finally {
            GerenciadorConexoes.closeAll(conn, stmt, rs);
        }
        return listaCarro;
    }
    
    public Carro getCarroById(int id) throws JavaWebException {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Carro oCarro = null;
        try {
            conn = GerenciadorConexoes.getConexao();
            prepStmt = conn.prepareStatement(SELECT_BY_ID_QUERY);
            prepStmt.setInt(1, id);
            rs = prepStmt.executeQuery();
            if (rs.next()) {
                //int id = rs.getInt("id");
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                String ano = rs.getString("ano");
                String disponivel = rs.getString("disponivel");
                String ar = rs.getString("ar");
                int porta = rs.getInt("porta");
                String direcao = rs.getString("direcao");
                double valor = rs.getDouble("valor");
                oCarro = new Carro(id, modelo, marca, ano, disponivel, ar, porta, disponivel, valor);
            }
        } catch (SQLException e) {
            String msg = "[CarroDB][getCarroById()]: " + e.getMessage();
            JavaWebException ge = new JavaWebException(msg, e);
            throw ge;
        } finally {
            GerenciadorConexoes.closeAll(conn, prepStmt, rs);
        }
        return oCarro;
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

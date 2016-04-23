package rentcar.BEANS;



/**
 *
 * @author LEONE
 */
public class Usuario {
    
    private int id;
    private String usuario;
    private String senha;
    
    public String getusuario(){
        return usuario;
    }

    
    public void setusuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getsenha(){
        return senha;
    }
    
    public void setsenha(String senha){
        this.senha = senha;
    }
    
    public int getid(){
        return id;
    }
    
    public void setid(int id){
        this.id = id;
    }
    
    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
}

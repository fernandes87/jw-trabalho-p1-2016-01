package rentcar.BEANS;

/**
 *
 * @author LEONE
 */

public class Cliente {
    
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    
    public String getnome(){
        return nome;
    }
    
    public void setnome(String nome){
        this.nome = nome;
    }
    
    public String getcpf(){
        return cpf;
    }
    
    public void setcpf(String cpf){
        this.cpf = cpf;
    }
    
    public String gettelefone(){
        return telefone;
    }
    
    public void settelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getemail(){
        return email;
    }
    
    public void setemail(String email){
        this.email = email;
    }
    
    public int getid(){
        return id;
    }
    
    public void setid(int id){
        this.id = id;
    }
    
    public Cliente(int id, String nome, String cpf, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }
}

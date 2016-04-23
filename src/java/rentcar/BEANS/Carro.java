package rentcar.BEANS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author LEONE
 */
public class Carro {
    
    private int id;
    private String modelo;
    private String marca;
    private String ano;
    private String disponivel;
    private String ar;
    private int porta;
    private String direcao;
    private double valor;
    
    public String getmodelo(){
        return modelo;
    }
    
    public void setmodelo(String modelo){
        this.modelo = modelo;
    }
    
    public String getmarca(){
        return marca;
    }
    
    public void setmarca(String marca){
        this.marca = marca;
    }
    
    public String getano(){
        return ano;
    }
    
    public void setano(String ano){
        this.ano = ano;
    }
    
    public String getdisponivel(){
        return disponivel;
    }
    
    public void setdisponivel(String disponivel){
        this.disponivel = disponivel;
    }
    
    public String getar(){
        return ar;
    }
    
    public void setar(String ar){
        this.ar = ar;
    }
    
    public int getporta(){
        return porta;
    }
    
    public void setporta(int porta){
        this.porta = porta;
    }
    
    public String getdirecao(){
        return direcao;
    }
    
    public void setdirecao(String direcao){
        this.direcao = direcao;
    }
    
    public double getvalor(){
        return valor;
    }
    
    public void setvalor(double valor){
        this.valor = valor;
    }
    
    public int getid(){
        return id;
    }
    
    public void setid(int id){
        this.id = id;
    }
 
    public Carro(int id, String modelo, String marca, String ano, String disponivel, String ar, int porta, String direcao, double valor) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.disponivel = disponivel;
        this.ar = ar;
        this.porta = porta;
        this.direcao = direcao;
        this.valor = valor;
    }
}

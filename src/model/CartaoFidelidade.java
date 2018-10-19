/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Enoque
 */
public class CartaoFidelidade {
    private int idcartaoFidelidade;
    private  boolean gold;
    private boolean platinum;
    private GestaoCliente cliente;

    public CartaoFidelidade(boolean gold, boolean platinum, GestaoCliente cliente) {
        this.gold = gold;
        this.platinum = platinum;
    }

    public CartaoFidelidade(int idcartaoFidelidade, boolean gold, boolean platinum, GestaoCliente cliente) {
        this.idcartaoFidelidade = idcartaoFidelidade;
        this.gold = gold;
        this.platinum = platinum;
    }

    public boolean isGold() {
        return gold;
    }

    public void setGold(boolean gold) {
        this.gold = gold;
    }

    public boolean isPlatinum() {
        return platinum;
    }

    public void setPlatinum(boolean platinum) {
        this.platinum = platinum;
    }

    public int getIdcartaoFidelidade() {
        return idcartaoFidelidade;
    }

    public void setIdcartaoFidelidade(int idcartaoFidelidade) {
        this.idcartaoFidelidade = idcartaoFidelidade;
    }

    public GestaoCliente getCliente() {
        return cliente;
    }

    public void setCliente(GestaoCliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    
}

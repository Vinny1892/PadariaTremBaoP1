/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Enoque
 */
public class CartaoFidelidade {
    private  boolean gold;
    private boolean platinum;

    public CartaoFidelidade(boolean gold, boolean platinum) {
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
    
    
    
    
}

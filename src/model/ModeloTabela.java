/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vinny
 */
public class ModeloTabela extends AbstractTableModel {
    private  ArrayList <Object> linhas;
    private String [] colunas;
    
    public ModeloTabela(ArrayList lin , String[] col){
        setLinhas(lin);
        setColunas(col);
        
    }
    

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
       return colunas.length;
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        ArrayList<Object> linha = (ArrayList<Object>) getLinhas().get(numLin);
        return linha.get(numLin);
        
    }
    public String getColumnName(int numCol){
        return colunas[numCol];
    }
    
    
    
    
    
 }

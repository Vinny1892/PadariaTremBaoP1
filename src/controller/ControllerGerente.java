package controller;

import model.GestaoGerente;
import dao.DaoGerente;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerGerente {

    /*
    Metodo usado para chamar o metodo salvar() da classe DaoGerente,
    passando como parametro o objeto GestaoGerente a ser salvo.
     */
    public void salvar(String nome, String cpf, String endereco, String telefone, float salarioBaseMensal, int porcentagemGratificacao) throws SQLException {
        GestaoGerente gerente = new GestaoGerente(nome, cpf, endereco, telefone, salarioBaseMensal, porcentagemGratificacao);
        new DaoGerente().salvar(gerente);
        System.out.println("Metodo salvar ControllerGerente realizado");
    }
    
    
    /*
    Metodo utilizado para chamar o metodo deletar() da classe DaoGerente,
    passando como parametro o id, para saber qual gerente sera deletado.
    */
    public void deletar(String id) throws SQLException {
        new DaoGerente().deletar(id);
        System.out.println("Metodo deletar ControllerGerente realizado");
    }

    /*
    Metodo utilizado para chamar o metodo atuzalizar() da classe DaoGerente,
    passando como parametro o objeto GestaoGerente a ser editado,
    de acordo com idGerente deste objeto.
     */
    public void editar(String nome, String cpf, String endereco, String telefone, float salarioBaseMensal, int porcentagemGratificacao) throws SQLException {
        GestaoGerente gerente = new GestaoGerente(nome, cpf, endereco, telefone, salarioBaseMensal, porcentagemGratificacao);
        new DaoGerente().atualizar(gerente);
        System.out.println("Metodo editar ControllerGerente realizado");
    }

    public ArrayList<GestaoGerente> getAll() throws SQLException {
        ArrayList<GestaoGerente> gerentes = (ArrayList<GestaoGerente>) (ArrayList<?>) new DaoGerente().getAll();
        System.out.println("Metodo getAll() ControllerGerente realizado");
        return gerentes;
    }

    public Object selecionaObjeto(int id) throws SQLException {
        GestaoGerente gerente = (GestaoGerente) new DaoGerente().getById(id);
        System.out.println("Metodo selecionaObjeto ControllerGerente realizado");
        return gerente;
    }


    
    public static void main(String[] args)throws SQLException {
        ControllerGerente cg = new ControllerGerente();
        //cg.salvar("nomeGerente", "22222233333", "rua gerente", "556732323232", 3000.00f, 10);
        //cg.editar("eduardogomes", "22222233333", "rua gerente1", "556700323232", 3000.00f, 5);
       // cg.deletar("11111111111");
        ArrayList<GestaoGerente> gerentes = cg.getAll();
        for (int i = 0 ; i <gerentes.size();i++){
            System.out.println(gerentes.get(i).getNome());
        }
    }
}

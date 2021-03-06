package controller;

import model.GestaoGerente;
import dao.DaoGerente;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerGerente {

    /*
    Metodo utilizado para calcular o salario final do gerente,
    recebendo como parametro o objeto GestaoGerente,
    e retornando o salario final float.
     */
    public float salarioFinal(GestaoGerente gerente) {
        float salarioFinal = gerente.getSalarioBaseMensal();
        return salarioFinal += gratificacao(gerente.getSalarioBaseMensal());
    }

    /*
    Metodo utilizado para calcular a gratificacao do gerente,
    recebendo como parametro salarioBase,
    retornando a gratificacao.
     */
    public float gratificacao(float salarioBase) {
        float gratificacao = 0f;
        return gratificacao = salarioBase * 0.2f;
    }

    /*
    Metodo usado para chamar o metodo salvar() da classe DaoGerente,
    passando como parametro o objeto GestaoGerente a ser salvo.
     */
    public void salvar(String nome, String cpf, String endereco, String telefone, float salarioBaseMensal/*, int porcentagemGratificacao*/) throws SQLException {
        GestaoGerente gerente = new GestaoGerente(nome, cpf, endereco, telefone, salarioBaseMensal/*, porcentagemGratificacao*/);
        new DaoGerente().salvar(gerente);
        System.out.println("Metodo salvar ControllerGerente realizado");
    }

    /*
    Metodo utilizado para chamar o metodo deletar() da classe DaoGerente,
    passando como parametro o id, para saber qual gerente sera deletado.
     */
    public void deletar(String cpf) throws SQLException {
        new DaoGerente().deletar(cpf);
        System.out.println("Metodo deletar ControllerGerente realizado");
    }

    /*
    Metodo utilizado para chamar o metodo atuzalizar() da classe DaoGerente,
    passando como parametro o objeto GestaoGerente a ser editado,
    de acordo com idGerente deste objeto.
     */
    public void editar(String nome, String cpf, String endereco, String telefone, float salarioBaseMensal/*, int porcentagemGratificacao*/) throws SQLException {
        GestaoGerente gerente = new GestaoGerente(nome, cpf, endereco, telefone, salarioBaseMensal/*, porcentagemGratificacao*/);
        new DaoGerente().atualizar(gerente);
        System.out.println("Metodo editar ControllerGerente realizado");
    }

    /*
    Metodo utilizado para chamar o metodo getAll() da classe DaoGerente,
    retornando um ArrayList de objetos do tipo GestaoGerente.
     */
    public ArrayList<GestaoGerente> getAll() throws SQLException {
        ArrayList<GestaoGerente> gerentes = (ArrayList<GestaoGerente>) (ArrayList<?>) new DaoGerente().getAll();
        System.out.println("Metodo getAll() ControllerGerente realizado");
        return gerentes;
    }

    /*
    Metodo utilizado para chamar o metodo getById() da classe DaoGerente,
    passando como parametro o idGerente a pegar,
    retornando o objeto GestaoGerente encontrado.
     */
    public Object selecionaObjeto(int id) throws SQLException {
        GestaoGerente gerente = (GestaoGerente) new DaoGerente().getById(id);
        System.out.println("Metodo selecionaObjeto ControllerGerente realizado");
        return gerente;
    }

}

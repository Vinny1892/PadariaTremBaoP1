/*
8. Gestão de impostos a pagar: a padaria deve poder manter o controle de todos os impostos
que deve pagar. São valores tributáveis os valores sobre as vendas realizadas, num percentual
de 15%, bem como os salários brutos pagos aos funcionários (base adicionado de eventuais
bonificações), num total de 18%.

 */
package controller;

import dao.DaoPadeiro;
import dao.DaoVendedor;
import java.sql.SQLException;
import java.util.ArrayList;
import model.GestaoGerente;
import model.GestaoVenda;
import model.Padeiro;
import model.Vendedor;

public class ControllerImpostos {

    /*
    Metodo chama o metodo getAll() ControllerVenda,
    acumula o valor a ser pago como tributo de cada venda,
    retorna valor de tributo total de todas as vendas do "mes".
     */
    //venda realizada 15%
    public float tributoTodasVendas() throws SQLException {
        ArrayList< GestaoVenda> vendas = (ArrayList<GestaoVenda>) (ArrayList<?>) new ControllerVenda().getAll();
        float valorTributo = 0;
        for (int i = 0; i < vendas.size(); i++) {
            valorTributo = +vendas.get(i).getValorTotalVenda() * 0.15f;
        }
        return valorTributo;
    }

    /*
    Metodo chama metodos getAll() do ControllerGerente, ControllerPadeiro e ControllerVendedor,
    acumulando o tribudo do salario,
    com salario + gratificacao,
    retornando todo o tributo.
     */
    public float tributoTodosSalariosFuncionarios() throws SQLException {
        ArrayList<GestaoGerente> gerentes = (ArrayList<GestaoGerente>) (ArrayList<?>) new ControllerGerente().getAll();//gerente
        ArrayList<Padeiro> padeiros = (ArrayList<Padeiro>) (ArrayList<?>) new ControllerPadeiro().getAll();//padeiro
        ArrayList<Vendedor> vendedores = (ArrayList<Vendedor>) (ArrayList<?>) new DaoVendedor().getAll();//vendedor
        float tributoTodosSalariosFuncionarios = 0;

        for (int i = 0; i < gerentes.size(); i++) {
            tributoTodosSalariosFuncionarios += gerentes.get(i).getSalarioBaseMensal() + gerentes.get(i).gratificacao();
        }
        for (int i = 0; i < padeiros.size(); i++) {
            tributoTodosSalariosFuncionarios += padeiros.get(i).getSalarioBaseMensal() + padeiros.get(i).gratificacao();
        }
        for (int i = 0; i < vendedores.size(); i++) {
            tributoTodosSalariosFuncionarios += vendedores.get(i).getSalarioBaseMensal() + vendedores.get(i).gratificacao();
        }

        return tributoTodosSalariosFuncionarios;
    }

}

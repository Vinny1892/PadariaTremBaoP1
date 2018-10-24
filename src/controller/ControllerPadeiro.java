package controller;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import dao.DaoPadeiro;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Padeiro;

public class ControllerPadeiro {

    /*
    Metodo utilizado para calcular a gratificacao do padeiro,
    recebendo como parametro o objeto Padeiro,
    retornando o valor da gratificacai.
     */
    public float gratificacao(Padeiro padeiro) {
        float gratificacao = 0;
        gratificacao = (padeiro.getSalarioBaseMensal() * 0.25f) * padeiro.getHorasTrabalhadaNoturno();
        return gratificacao;
    }

    /*
    Metodo usado para chamar o metodo salvar() da classe DaoPadeiro,
    passando como parametro o objeto Padeiro a ser salvo.
     */
    public void salvar(String nome, String endereco, String cpf, String telefone, float salarioBaseMensal, float horasEmHorarioAlternativo) throws SQLException {
        try {
            Padeiro padeiro = new Padeiro(nome, endereco, cpf, telefone, salarioBaseMensal, horasEmHorarioAlternativo);
            new DaoPadeiro().salvar(padeiro);
            System.out.println("Metodo salvar ControllerPadeiro realizado");
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("CPF Ja existe");
            JOptionPane.showMessageDialog(null, "CPF ja existe no Banco de Dados");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Padeiro");
        }
    }

    /*
    Metodo utilizado para chamar o metodo atualizar() da classe DaoPadeiro,
    passando como parametro o objeto Padeiro a ser editado,
    de acordo com idPadeiro deste objeto.
     */
    public void editar(String nome, String endereco, String cpf, String telefone, float salarioBaseMensal, float horasEmHorarioAlternativo) throws SQLException {
        Padeiro padeiro = new Padeiro(nome, endereco, cpf, telefone, salarioBaseMensal, horasEmHorarioAlternativo);
        new DaoPadeiro().atualizar(padeiro);
        System.out.println("Metodo editar ControllerPadeiro realizado");
    }

    /*
    Metodo utilizado para chamar o metodo deletar() da classe DaoPadeiro,
    passando como parametro o idPadeiro, para saber qual padeiro sera deletado.
     */
    public void deletar(String cpf) throws SQLException {
        new DaoPadeiro().deletar(cpf);
        System.out.println("Metodo deletar ControllerPadeiro realizado");
    }

    /*
    Metodo utilizado para chamar o metodo getById() da classe DaoPadeiro,
    passando como parametro o idPadeiro a pegar,
    retornando o objeto Padeiro encontrado.
     */
    public Object selecionaObjeto(int id) throws SQLException {
        Padeiro padeiro = (Padeiro) new DaoPadeiro().getById(id);
        System.out.println("Metodo selecionaObjeto ControllerFornecedor realizado");
        return padeiro;
    }

    /*
    Metodo utilizado para chamar o metodo getAll() da classe DaoPadeiro,
    retornando um ArrayList de objetos do tipo Padeiro.
     */
    public ArrayList<Padeiro> getAll() throws SQLException {
        ArrayList<Padeiro> padeiros = (ArrayList<Padeiro>) (ArrayList<?>) new DaoPadeiro().getAll();
        return padeiros;
    }

}

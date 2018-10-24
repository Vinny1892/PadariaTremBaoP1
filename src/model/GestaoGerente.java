package model;

/*
Gerentes, por sua vez, tem um aumento no salario base em 20%,
como gratiﬁcaco por funcao de conﬁanca.
 */
public class GestaoGerente extends GestaoFuncionario {

    private int idGerente;
    private int porcentagemGratificacao;

    public GestaoGerente(int idGerente, String nome, String cpf, String endereco, String telefone, float salarioBaseMensal, int PorcentagemGratificacao) {
        super(salarioBaseMensal, cpf, telefone, nome, endereco);
        this.idGerente = idGerente;
        this.porcentagemGratificacao = PorcentagemGratificacao;
    }

    public GestaoGerente(String nome, String cpf, String endereco, String telefone, float salarioBaseMensal, int PorcentagemGratificacao) {
        super(salarioBaseMensal, cpf, telefone, nome, endereco);
        this.porcentagemGratificacao = PorcentagemGratificacao;
    }

    @Override
    public int gratificacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long getId() {
        return idGerente;
    }

    public void setId(int idGerente) {
        this.idGerente = idGerente;
    }

    public int getPorcentagemGratificacao() {
        return porcentagemGratificacao;
    }

    public void setPorcentagemGratificacao(int porcentagemGratificacao) {
        this.porcentagemGratificacao = porcentagemGratificacao;
    }

    @Override
    public String toString() {
        return getNome();
    }

}

package model;
/*
Gerentes, por sua vez, tem um aumento no salario base em 20%,
como gratiﬁcaco por funcao de conﬁanca.
*/
public class GestaoGerente extends GestaoFuncionario{
    private long id;
    private int PorcentagemGratificacao;

    public GestaoGerente(long id, String nome, String cpf, String endereco,  String telefone, float salarioBaseMensal,int PorcentagemGratificacao) {
        super(salarioBaseMensal, cpf, telefone, nome, endereco);
        this.id = id;
        this.PorcentagemGratificacao = PorcentagemGratificacao;
    }

    @Override
    public int gratificacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPorcentagemGratificacao() {
        return PorcentagemGratificacao;
    }

    public void setPorcentagemGratificacao(int PorcentagemGratificacao) {
        this.PorcentagemGratificacao = PorcentagemGratificacao;
    }

    
    
}

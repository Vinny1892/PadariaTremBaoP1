package Model;

public class GestaoFornecedor {
    String nome;
    String cnpj;
    String endereco;
    boolean recorrente;
    
    
    //aplicavel no preco de custo de todos os produtos por eles fornecidos.
    public float recorrenteNegociarDesconto(float precoCusto, float valorNegociado){
        float valorDesconto = precoCusto * valorNegociado;
        return valorDesconto;
    }
}

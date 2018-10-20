package model;
public abstract class PessoaJuridica  extends Pessoa{
    private String cnpj;

    public PessoaJuridica(String cnpj, String nome, String endereco) {
        super(nome, endereco);
        if (cnpj.length() == 14) {
            this.cnpj = cnpj;
        } else {
            System.out.println("CNPJ menor que 14 digitos");
        }
    }



    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}

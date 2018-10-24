package model;

/*
Padeiros, por ﬁm,
tem uma jornada de trabalho em horario alternativo,
cumprindo algumas horas em horarios noturnos (madrugada).
Padeiros devem receber uma gratiﬁcacao de 25% sobre o salario base,
como adicional noturno, para cada hora trabalhada em horario alternativo.
 */
public class Padeiro extends GestaoFuncionario {

    private float horasEmHorarioAlternativo;
    int idPadeiro;

    /*Construtor da classe Padeiro // Recebe por parametro nome, endereco, cpf, telefone, salario base mensal e horas em horario alternativo //
    Utilizado em cojunto com metodos que nao necessitam do ID como parametro // Ex: salvar()*/

    public Padeiro(String nome, String endereco, String cpf, String telefone, float salarioBaseMensal, float horasEmHorarioAlternativo) {
        super(salarioBaseMensal, cpf, telefone, nome, endereco);
        this.horasEmHorarioAlternativo = horasEmHorarioAlternativo;
    }

    /*Construtor da classe Padeiro // Recebe por parametro id, nome, endereco, cpf, telefone, salario base mensal e horas em horario alternativo //
    Utilizado em cojunto com metodos que necessitam do ID como parametro // Ex: atualizar()*/

    public Padeiro(float horasEmHorarioAlternativo, int idPadeiro, float salarioBaseMensal, String cpf, String telefone, String nome, String endereco) {
        super(salarioBaseMensal, cpf, telefone, nome, endereco);
        this.horasEmHorarioAlternativo = horasEmHorarioAlternativo;
        this.idPadeiro = idPadeiro;
    }

    //Getters and Setters

    public int getIdPadeiro() {
        return idPadeiro;
    }

    public void setIdPadeiro(int idPadeiro) {
        this.idPadeiro = idPadeiro;
    }
 
    public float getHorasTrabalhadaNoturno() {
        return horasEmHorarioAlternativo;
    }

    public void sethorarioAlternativo(float horasEmHorarioAlternativo) {
        this.horasEmHorarioAlternativo = horasEmHorarioAlternativo;
    }

}

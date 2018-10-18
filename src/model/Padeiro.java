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

    public Padeiro(String nome, String endereco, String cpf, String telefone, float salarioBaseMensal, float horasEmHorarioAlternativo) {
        super(salarioBaseMensal, cpf, telefone, nome, endereco);
        this.horasEmHorarioAlternativo = horasEmHorarioAlternativo;

    }

    public Padeiro(float horasEmHorarioAlternativo, float salarioBaseMensal, String cpf, String telefone, String nome, String endereco) {
        super(salarioBaseMensal, cpf, telefone, nome, endereco);
        this.horasEmHorarioAlternativo = horasEmHorarioAlternativo;

    }

    @Override
    public int gratificacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //metodos getters e setters 
    public float getHorasTrabalhadaNoturno() {
        return horasEmHorarioAlternativo;
    }

    //deve acumular horas trabalhadas durante o mes
    public void sethorarioAlternativo(float horasEmHorarioAlternativo) {
        this.horasEmHorarioAlternativo = horasEmHorarioAlternativo;
    }

 

}

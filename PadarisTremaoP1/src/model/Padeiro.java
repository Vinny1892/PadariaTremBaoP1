package model;
/*
Padeiros, por ﬁm,
tem uma jornada de trabalho em horario alternativo,
cumprindo algumas horas em horarios noturnos (madrugada).
Padeiros devem receber uma gratiﬁcacao de 25% sobre o salario base,
como adicional noturno, para cada hora trabalhada em horario alternativo.
*/
public class Padeiro extends model.GestaoFuncionario{
    private float horasTrabalhadaNoturno;
    
    
    
    
    
    
    
    @Override
    public float gratificacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    public float getHorasTrabalhadaNoturno() {
        return horasTrabalhadaNoturno;
    }
    //deve acumular horas trabalhadas durante o mes
    public void setHorasTrabalhadaNoturno(float horasTrabalhadaNoturno) {
        this.horasTrabalhadaNoturno = horasTrabalhadaNoturno;
    }
    
}

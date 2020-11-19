package CRUD.Crud03.entidades;

import java.util.Calendar;
import java.util.Random;

public class Aluno{
        private String Cpf;
        private String Nome;
        private String Matricula;
        private String Curso;


    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula() {

        Calendar calendar = Calendar.getInstance();

        String ano = Integer.toString(calendar.get(Calendar.YEAR));
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        int minuto = calendar.get(Calendar.MINUTE);
        int segundo = calendar.get(Calendar.SECOND);
        String Mes = format(mes);
        String Dia = format(dia);
        String Hora = format(hora);
        String Minuto =format(minuto);
        String Segundo = format(segundo);

        int MesInt = Integer.parseInt(Mes);

        String sem = "01";
        if(MesInt > 5)
            sem = "02";


        Random random = new Random();
        Integer aleatorio = random.nextInt((99 - 1) + 1)+ 1;

        String Mat = format(aleatorio);

        String data = ano + Mes + Dia + Hora + Minuto + Segundo ;
        this.Matricula = data +"-"+ Mat +"-" +  sem;


    }

    public String getCurso() {return Curso; }

    public void setCurso(String curso) {
        Curso = curso;
    }

    public String format( int dado){

        String DadoFormat;
        DadoFormat =  String.format("%02d",dado);
        return DadoFormat ;
    } //posso retirar.
}



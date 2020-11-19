package CRUD.Crud03.controller;

import CRUD.Crud03.Connection.DataBaseConnection;
import CRUD.Crud03.entidades.Aluno;
import CRUD.Crud03.interfaces.AlunoContract;
import com.mysql.cj.PreparedQuery;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class AlunoController implements AlunoContract {

    @Override
    public Aluno criarAluno(Aluno aluno) {

        aluno.setMatricula();
        PreparedStatement preparedStatement;
       try{
           preparedStatement = DataBaseConnection.getInstance().criarPreparedStatement(
                   "insert into Aluno values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS
           );
           preparedStatement.setString(1,aluno.getNome());
           preparedStatement.setString(2,aluno.getCurso());
           preparedStatement.setString(3,aluno.getCpf());
           preparedStatement.setString(4,aluno.getMatricula());

           preparedStatement.executeUpdate();
           preparedStatement.close();

       }catch (SQLException f){

           f.printStackTrace();
       }

        return aluno;
    }

    @Override
    public String recuperarAluno() {

     return lerArquivo("06422233311");

    }

    @Override
    public Aluno atualizarAluno(String Nome,String Curso ,String  Cpf) {


        PreparedStatement preparedStatement;
        try{
            preparedStatement = DataBaseConnection.getInstance().criarPreparedStatement(
                    "update Aluno set Nome = ?,Curso = ? where Cpf = ?", Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setString(1,Nome);
            preparedStatement.setString(2,Curso);
            preparedStatement.setString(3,Cpf);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (SQLException f){

            f.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deletarAluno(String Cpf) {
        PreparedStatement preparedStatement;
        try{
            preparedStatement = DataBaseConnection.getInstance().criarPreparedStatement(
                    "Delete from Aluno where Cpf=? ", Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setString(1,Cpf);

            preparedStatement.execute();
            preparedStatement.close();

        }catch (SQLException f){

            f.printStackTrace();
        }
        return  true;

    }



    private void gravaRegistroArquivo(Aluno aluno){
      /*  StringBuilder sb = new StringBuilder();
        sb.append(aluno.getNome())
               // .append(SEPARADOS)
                //.append(aluno.getCurso())
               // .append(SEPARADOS)
                //.append(aluno.getCpf())
                //.append(SEPARADOS)
                //.append(aluno.getMatricula());
       try{
           //FileWriter fw = new FileWriter(ARQUIVO_CSV,true);
           //BufferedWriter bw = new BufferedWriter(fw);
           //bw.write(sb.toString());
          // bw.newLine();
           //bw.close();
       }catch (IOException e){
           e.printStackTrace();
       }*/
    }

    public String lerArquivo(String Cpf){
        Connection ler = DataBaseConnection.getConnetion();

        try{
            Statement view = ler.createStatement();
            ResultSet result = view.executeQuery("select * from Aluno where Cpf = '"+Cpf+"';");

            if (result.next()){
                System.out.println(result.getString("Nome"));
                System.out.println(result.getString("Curso"));
                System.out.println(result.getString("Cpf"));
                System.out.println(result.getString("Matricula"));

            }

        }catch (SQLException e){

            e.printStackTrace();

        }
        return null;
    }

}

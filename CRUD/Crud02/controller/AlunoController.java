package CRUD.Crud02.controller;

import CRUD.Crud02.entidades.Aluno;

import CRUD.Crud02.interfaces.AlunoContract;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AlunoController implements AlunoContract {
    private final String ARQUIVO_CSV = "Alunos.csv";
    private final String SEPARADOS = ";";

    @Override
    public Aluno criarAluno(Aluno aluno) {

        aluno.setMatricula();
        gravaRegistroArquivo(aluno);

        return aluno;
    }

    @Override
    public String recuperarAluno() {

     return lerArquivo();

    }

    @Override
    public Aluno atualizarAluno(Aluno aluno) {


        return null;
    }

    @Override
    public boolean deletarAluno() {
        File CaminhoDelete = new File(ARQUIVO_CSV);
        return  CaminhoDelete.delete();

    }



    private void gravaRegistroArquivo(Aluno aluno){
        StringBuilder sb = new StringBuilder();
        sb.append(aluno.getNome())
                .append(SEPARADOS)
                .append(aluno.getCurso())
                .append(SEPARADOS)
                .append(aluno.getCpf())
                .append(SEPARADOS)
                .append(aluno.getMatricula());
       try{
           FileWriter fw = new FileWriter(ARQUIVO_CSV,true);
           BufferedWriter bw = new BufferedWriter(fw);
           bw.write(sb.toString());
           bw.newLine();
           bw.close();
       }catch (IOException e){
           e.printStackTrace();
       }
    }

    public String lerArquivo(){
        File file = new File(ARQUIVO_CSV);
        try{
           return FileUtils.readFileToString(file, StandardCharsets.UTF_8);

        }catch (FileNotFoundException h){
            System.out.println("Arquivo não encontrado");
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

}

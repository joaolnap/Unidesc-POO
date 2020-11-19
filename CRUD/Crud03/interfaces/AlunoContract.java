package CRUD.Crud03.interfaces;

import CRUD.Crud03.entidades.Aluno;

public interface AlunoContract {
    Aluno criarAluno(Aluno aluno);//C REATE
    String recuperarAluno();   //R EAD
    Aluno atualizarAluno(String Nome,String Curso,String Cpf);   //U PDATE
    boolean deletarAluno(String Cpf);      //D ELETE
}


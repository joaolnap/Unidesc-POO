package CRUD.Crud02.interfaces;

import CRUD.Crud02.entidades.Aluno;

public interface AlunoContract {
    Aluno criarAluno(Aluno aluno);//C REATE
    String recuperarAluno();   //R EAD
    Aluno atualizarAluno(Aluno aluno);   //U PDATE
    boolean deletarAluno();      //D ELETE
}


package CRUD.Crud01.interfaces;

import CRUD.Crud01.entidades.Aluno;

public interface AlunoContract {
    Aluno criarAluno(Aluno aluno);//C REATE
    Aluno recuperarAluno(String cpf);   //R EAD
    Aluno atualizarAluno(Aluno aluno);   //U PDATE
    boolean deletarAluno(String cpf);      //D ELETE
}


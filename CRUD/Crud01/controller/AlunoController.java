package CRUD.Crud01.controller;

import CRUD.Crud01.entidades.Aluno;
import CRUD.Crud01.interfaces.AlunoContract;

import java.util.ArrayList;
import java.util.List;

public class AlunoController implements AlunoContract {

    private List<Aluno> alunos = new ArrayList<Aluno>();


    @Override
    public Aluno criarAluno(Aluno aluno) {

        aluno.setMatricula();

       salvarEntidade(aluno);

        return aluno;
    }

    @Override
    public Aluno recuperarAluno(String cpf) {
        for(Aluno aluno : alunos){
            if(cpf.equals(aluno.getCpf())){
                return aluno;
            }
        }
        return null;
    }

    @Override
    public Aluno atualizarAluno(Aluno aluno) {

        for(Aluno item : alunos){
            if(aluno.getCpf().equals(item.getCpf())){
                item.setNome(aluno.getNome());
                item.setCurso(aluno.getCurso());
            }
        }
        return aluno;
    }

    @Override
    public boolean deletarAluno(String cpf) {

        Aluno alunorecuperado =  recuperarAluno(cpf);
        if(alunorecuperado != null){
            alunos.remove(alunorecuperado);
            return true;
        }
        return false;
    }

    private void salvarEntidade(Aluno aluno) {
        alunos.add(aluno);
    }



}

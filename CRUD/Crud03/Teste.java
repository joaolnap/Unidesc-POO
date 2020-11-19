package CRUD.Crud03;

import CRUD.Crud03.controller.AlunoController;
import CRUD.Crud03.entidades.Aluno;

public class Teste {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.setNome("joao");
        aluno.setCurso("Sistemas de informação");
        aluno.setCpf("06422233311");

        AlunoController controller = new AlunoController();

        //controller.criarAluno(aluno);
    //controller.recuperarAluno();

      //  controller.atualizarAluno("atualizar","Curso","06422233311");

        controller.recuperarAluno();
        controller.deletarAluno("06422233311");
        controller.deletarAluno("06422233311");
    }


}

package CRUD.Crud02;

import CRUD.Crud02.controller.AlunoController;
import CRUD.Crud02.entidades.Aluno;

import java.io.IOException;

public class Teste {

    public static void main(String[] args) throws IOException {

        Aluno aluno = new Aluno();
        aluno.setNome("joao");
        aluno.setCpf("05664237255");
        aluno.setCurso("Ciencia da Computação");

        AlunoController controller = new AlunoController();
        controller.criarAluno(aluno);
        String conteudo = controller.recuperarAluno();
        System.out.println(conteudo);
        controller.deletarAluno();
        controller.recuperarAluno();

    }
}

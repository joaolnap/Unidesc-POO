package CRUD.Crud01;

import CRUD.Crud01.controller.AlunoController;
import CRUD.Crud01.entidades.Aluno;

public class Teste {

    public static void main(String[] args) {

        Aluno aluno = new Aluno();
        aluno.setNome("joao");
        aluno.setCpf("06523005123");
        aluno.setCurso("sistemas");

        //Criar aluno
        AlunoController controller = new AlunoController();

        aluno = controller.criarAluno(aluno);

        System.out.println("Matricula gerada é :"+ aluno.getMatricula());

        //atualizando aluno
        aluno.setNome("jose");

        aluno = controller.atualizarAluno(aluno);

        if(aluno == null)
            System.out.println("Aluno nao encontrado");
        else
            System.out.println("aluno atualizado para " + aluno.getNome());

        //deletando aluno
        boolean deletou = controller.deletarAluno(aluno.getCpf());

        if(deletou)
            System.out.println("Aluno deletado");
        else
            System.out.println("aluno nao encontrado ");

        deletou = controller.deletarAluno(aluno.getCpf());

        if(deletou)
            System.out.println("Aluno deletado");
        else
            System.out.println("aluno nao encontrado ");

    }
}

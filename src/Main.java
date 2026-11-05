import Package.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("   SISTEMA DE GERENCIAMENTO DE NOTAS ACADÊMICAS - DEMONSTRAÇÃO DO CENÁRIO \n");

        System.out.println("Criando professor com seus dados");
        Teacher professor = new Teacher("Carlos Eduardo Silva", "111.222.333-44", "carlos.silva@universidade.edu.br");
        System.out.println("Professor criado com sucesso: " + professor.getName() + " | Registro: " + professor.getRegistrationTeacher());
        System.out.println();

        System.out.println("Utilizando o professor para cadastrar uma disciplina");
        Discipline disciplina = professor.registerDiscipline("Programação Orientada a Objetos", 80);
        System.out.println("Disciplina cadastrada pelo professor: " + disciplina.getName() + " | Código: " + disciplina.getCodeDiscipline() + " | Carga: " + disciplina.getWorkload() + "h");
        System.out.println();

        System.out.println("Criando turma vinculada à disciplina cadastrada");
        Classroom turma = new Classroom(disciplina, professor);
        System.out.println("Turma criada: " + turma.getCode() + " vinculada à disciplina '" + turma.getDiscipline().getName() + "' com o professor " + turma.getTeacher().getName());
        System.out.println();

        System.out.println("Cadastrando pelo menos três alunos");
        Student aluno1 = professor.registerStudent("Ana Beatriz Souza", "222.333.444-55", "ana.souza@aluno.universidade.edu.br");
        Student aluno2 = new Student("Bruno Martins Costa", "333.444.555-66", "bruno.costa@aluno.universidade.edu.br");
        Student aluno3 = new Student("Carla Ferreira Lima", "444.555.666-77", "carla.lima@aluno.universidade.edu.br");

        System.out.println("Aluno 1 cadastrado: " + aluno1.getName() + " | Matrícula: " + aluno1.getRegistration());
        System.out.println("Aluno 2 cadastrado: " + aluno2.getName() + " | Matrícula: " + aluno2.getRegistration());
        System.out.println("Aluno 3 cadastrado: " + aluno3.getName() + " | Matrícula: " + aluno3.getRegistration());
        System.out.println();

        System.out.println("Adicionando os três alunos à turma");
        turma.registerStudent(aluno1);
        turma.registerStudent(aluno2);
        turma.registerStudent(aluno3);
        System.out.println("Os 3 alunos foram adicionados à turma com sucesso!");

        System.out.println("\n[Teste de Regra] Tentando adicionar novamente a aluna 'Ana Beatriz Souza' na mesma turma:");
        boolean duplicadoAdicionado = turma.registerStudent(aluno1);
        System.out.println("Resultado da tentativa de duplicidade: " + (duplicadoAdicionado ? "Incorretamente adicionado!" : "Bloqueado com sucesso!"));
        System.out.println();

        System.out.println("Exibindo a relação de alunos cadastrados na turma");
        turma.listStudents();
        System.out.println();

        System.out.println("Registrando pelo menos duas notas para cada aluno com descrições diferentes");

        Test nota1Aluno1 = professor.registerTest(aluno1, 8.5, "Avaliação Teórica 1 (AV1)");
        Test nota2Aluno1 = professor.registerTest(aluno1, 9.0, "Projeto Prático POO (AV2)");

        Test nota1Aluno2 = new Test(aluno2, 7.0, "Avaliação Teórica 1 (AV1)");
        Test nota2Aluno2 = new Test(aluno2, 8.0, "Seminário de Modelagem (AV2)");

        Test nota1Aluno3 = new Test(aluno3, 9.5, "Avaliação Teórica 1 (AV1)");
        Test nota2Aluno3 = new Test(aluno3, 10.0, "Estudo de Caso Prático (AV2)");

        System.out.println("Notas criadas para os 3 alunos com sucesso.");

        System.out.println("\n[Teste de Regra] Testando validação de nota inválida fora da faixa (11.5 e -1.0):");
        try {
            new Test(aluno1, 11.5, "Atividade Extra Inválida");
        } catch (IllegalArgumentException e) {
            System.out.println("  Exceção capturada com sucesso para nota 11.5: " + e.getMessage());
        }
        try {
            new Test(aluno1, -1.0, "Atividade Extra Inválida");
        } catch (IllegalArgumentException e) {
            System.out.println("  Exceção capturada com sucesso para nota -1.0: " + e.getMessage());
        }
        System.out.println();

        System.out.println("Adicionando as notas registradas à turma");
        turma.registerTest(nota1Aluno1);
        turma.registerTest(nota2Aluno1);
        turma.registerTest(nota1Aluno2);
        turma.registerTest(nota2Aluno2);
        turma.registerTest(nota1Aluno3);
        turma.registerTest(nota2Aluno3);
        System.out.println("Todas as notas foram vinculadas à turma com sucesso!");

        System.out.println("\n[Teste de Regra] Tentando adicionar à turma a nota de um aluno não matriculado:");
        Student alunoNaoMatriculado = new Student("Lucas Rocha", "999.888.777-66", "lucas@aluno.universidade.edu.br");
        Test notaAlunoNaoMatriculado = new Test(alunoNaoMatriculado, 8.0, "Prova Externa");
        turma.registerTest(notaAlunoNaoMatriculado);
        System.out.println();

        System.out.println("Exibindo as notas da turma");
        turma.listTests();
        System.out.println();

        System.out.println("Executando a consulta de notas de pelo menos um aluno");
        aluno1.getTest();
        System.out.println();

        System.out.println("Executando a consulta de turmas de pelo menos um aluno");
        aluno1.getClassroom();
        System.out.println();

        System.out.println("Demonstrando os métodos previstos na modelagem para apresentação de dados");
        System.out.println("\n[Apresentação de Dados - Professor]");
        professor.getData();

        System.out.println("\n[Apresentação de Dados - Disciplina]");
        disciplina.getData();

        System.out.println("\n[Apresentação de Dados - Turma]");
        turma.getData();

        System.out.println("\n[Apresentação de Dados - Alunos (getData)]");
        aluno1.getData();
        aluno2.getData();
        aluno3.getData();

        System.out.println("\n[Apresentação de Dados - Avaliações (showTest)]");
        nota1Aluno1.showTest();
        nota2Aluno1.showTest();
        nota1Aluno2.showTest();
        nota2Aluno2.showTest();
        nota1Aluno3.showTest();
        nota2Aluno3.showTest();

    }
}

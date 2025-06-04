package main;

import entity.GerenciamentoAlunos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcao = "";
        GerenciamentoAlunos gerenciamento = new GerenciamentoAlunos(scanner);

        while (!opcao.equals("3")) {
            System.out.println("\nEscolha uma das opções:");
            System.out.println("1 - Adicionar novo aluno");
            System.out.println("2 - Gerar relatório");
            System.out.println("3 - Encerrar aplicação");

            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    gerenciamento.adicionarAluno();
                    break;
                case "2":
                    gerenciamento.criarRelatorio();
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, selecione outra opção.");
            }
        }
    }
}
package com.ciandt.feedfront.application;

public class UI {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void menuInicial() {
        System.out.println("1. Menu Employee");
        System.out.println("2. Menu Feedback");
        System.out.println("3. Sair");
    }

    public static void menuDetalhado(int opcao) {
        if (opcao == 1) {
            System.out.println("---------- Menu Employee ----------");
        } else {
            System.out.println("---------- Menu Feedback ----------");
        }
        System.out.println("1. Listar registros");
        System.out.println("2. Cadastrar");
        System.out.println("3. Consultar");
        System.out.println("4. Editar");
        System.out.println("5. Excluir");
        System.out.println("6. Voltar ao menu anterior");
    }

    public static void realizarAcao(int opcao, int opcaoDetalhe) {
        switch (opcaoDetalhe) {
            case 1:
                if (opcao == 1) {
                    System.out.println("---------- Employees ----------");
                    UIEmployee.listarEmployee();
                } else {
                    System.out.println("---------- Feedbacks ----------");
                    UIFeedback.listarFeedback();
                }
                System.out.println("---------- Ação concluida ----------");
                clearScreen();
                break;
            case 2:
                if (opcao == 1) {
                    System.out.println("---------- Cadastrar Employee ----------");
                    UIEmployee.cadastrarEmployee();
                } else {
                    System.out.println("---------- Cadastrar Feedback ----------");
                    UIFeedback.cadastrarFeedBack();
                }
                System.out.println("---------- Ação concluida ----------");
                clearScreen();
                break;
            case 3:
                if (opcao == 1) {
                    System.out.println("---------- Consultar Employee ----------");
                    UIEmployee.consultarEmployee();
                } else {
                    System.out.println("---------- Consultar Feedback ----------");
                    UIFeedback.consultarFeedback();
                }
                System.out.println("---------- Ação concluida ----------");
                clearScreen();
                break;
            case 4:
                if (opcao == 1) {
                    System.out.println("---------- Editar Employee ----------");
                    UIEmployee.editarEmployee();
                } else {
                    System.out.println("---------- Editar Feedback ----------");
                    UIFeedback.editarFeedback();
                }
                System.out.println("---------- Ação concluida ----------");
                clearScreen();
                break;
            case 5:
                if (opcao == 1) {
                    System.out.println("---------- Excluir Employee ----------");
                    UIEmployee.excluirEmployee();
                } else {
                    System.out.println("---------- Excluir Feedback ----------");
                    UIFeedback.excluirFeedback();
                }
                System.out.println("---------- Ação concluida ----------");
                clearScreen();
                break;
            default:
        }
    }
}
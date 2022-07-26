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
        System.out.println("1. Cadastrar");
        System.out.println("2. Consultar");
        System.out.println("3. Editar");
        System.out.println("4. Excluir");
        System.out.println("5. Voltar ao menu anterior");
    }

    public static void realizarAcao(int opcao, int opcaoDetalhe) {
        switch (opcaoDetalhe) {
            case 1:
                if (opcao == 1) {
                    UIEmployee.cadastrarEmployee();
                } else {
                    UIFeedback.cadastrarFeedBack();
                }
                System.out.println("---------- Ação concluida ----------");
                clearScreen();
                break;
            case 2:
                if (opcao == 1) {
                    UIEmployee.consultarEmployee();
                } else {
                    UIFeedback.buscarFeedBack();
                }
                System.out.println("---------- Ação concluida ----------");
                clearScreen();
                break;
            case 3:
                if (opcao == 1) {
                    UIEmployee.editarEmployee();
                } else {
                    UIFeedback.editarFeedback();
                }
                System.out.println("---------- Ação concluida ----------");
                clearScreen();
                // atualizar
                break;
            case 4:
                if (opcao == 1) {
                    UIEmployee.excluirEmployee();
                } else {
                    UIFeedback.excluirFeedback();
                }
                System.out.println("---------- Ação concluida ----------");
                clearScreen();
                break;
            default:
        }
    }
}
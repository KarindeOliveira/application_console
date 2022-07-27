package com.ciandt.feedfront.application;


import com.ciandt.feedfront.controller.FeedbackController;
import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import com.ciandt.feedfront.models.Feedback;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UIFeedback {

    public static void cadastrarFeedBack() {
        long autor, proprietario;
        String descricao, oqueMelhora, comoMelhora;
        LocalDate data = LocalDate.now();
        FeedbackController feedBackController = new FeedbackController();

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID do Employee autor:");
        autor = Integer.parseInt(sc.nextLine());
        System.out.println("Digite o ID do Employee que receberá o Feedback:");
        proprietario = Integer.parseInt(sc.nextLine());
        System.out.println("Digite a descrição do Feedback:");
        descricao = sc.nextLine();
        System.out.println("Digite pontos em que você acha o Employee pode melhorar:");
        oqueMelhora = sc.nextLine();
        System.out.println("Digite sugestões do que Employee pode fazer para melhorar:");
        comoMelhora = sc.nextLine();

        try {
//            feedBackController.salvar(new Feedback(data, autor, proprietario, descricao, oqueMelhora, comoMelhora));
        } catch (Exception e) {
            // ToDo: tratar as diferentes exceções
            System.out.println("Não foi possível cadastrar o Feedback");
        }
    }

    public static Feedback consultarFeedback() {
        FeedbackController feedbackController = new FeedbackController();
        Feedback feedback = null;

        Scanner sc = new Scanner(System.in);
        String id;
        System.out.println("Entre com o ID do Feedback:");
        id = sc.next();

        try {
            feedback = feedbackController.buscar(id);
            System.out.println(feedback.toString());
        } catch (Exception e) {
            System.out.println("Não foi possível encontrar o Feedback");
        }
        return feedback;
    }

    public static void editarFeedback() {
        FeedbackController feedbackController = new FeedbackController();
        Feedback feedback = consultarFeedback();

        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        menuCampoEdicao();
        opcao = Integer.parseInt(sc.nextLine());

        while (opcao != 4) {
            try {
                switch (opcao) {
                    case 1:
                        System.out.println("Digite a nova descrição do feedback:");
                        String descricao = sc.nextLine();
                        feedback.setDescricao(descricao);
                        System.out.println("Campo atualizado.");
                        break;
                    case 2:
                        System.out.println("Digite sua nova versão do que melhorar:");
                        String queMelhorar = sc.nextLine();
                        feedback.setoQueMelhora(queMelhorar);
                        System.out.println("Campo atualizado.");
                        break;
                    case 3:
                        System.out.println("Digite sua nova versão de como melhorar:");
                        String comoMelhorar = sc.nextLine();
                        feedback.setComoMelhora(comoMelhorar);
                        System.out.println("Campo atualizado.");
                        break;
                    default:
                        System.out.println("Opção inválida. Digite novamente");
                        opcao = sc.nextInt();
                }

            } catch (ComprimentoInvalidoException e) {
                System.out.println("O dado informado é inválido");
            }

            if (opcao >0 && opcao <4) {
                menuCampoEdicao();
                opcao = sc.nextInt();
            }
        }

        try {
            feedbackController.apagar(feedback.getId());
        } catch (Exception e){
            System.out.println("Não foi possível apagar");
        }

        try {
            feedbackController.salvar(feedback);
            System.out.println("Feedback salvo: " + feedback.getId());
        } catch (Exception e){
            System.out.println("Não foi possível atualizar");
        }

    }

    public static void excluirFeedback() {
        Scanner sc = new Scanner(System.in);
        FeedbackController feedBackController = new FeedbackController();

        Feedback feedback = consultarFeedback();

        System.out.println("Tem certeza que deseja excluir esse registro?");
        System.out.println("1. Confirmar");
        System.out.println("2. Cancelar");

        int opcao = sc.nextInt();

        while (opcao != 2) {
            if (opcao == 1) {
                try {
                    feedBackController.apagar(feedback.getId());
                } catch (Exception e){
                    // ToDo: tratar exceções
                }
                opcao = 2;
            } else {
                System.out.println("Opção inválida. Digite novamente");
                opcao = sc.nextInt();
            }
        }


    }

    public static void listarFeedback() {
        FeedbackController feedBackController = new FeedbackController();

        System.out.println("---------- Feedbacks ----------");
        try {
            List<Feedback> feedbacks = feedBackController.listar();
            // ToDo: printar bonitinho?
            System.out.println(feedbacks);
        } catch (Exception e) {
            // ToDo: tratar exceções
        }
    }

    public static void menuCampoEdicao(){
        System.out.println("Selecione o campo que deseja editar:");
        System.out.println("1. Descrição");
        System.out.println("2. O que melhorar");
        System.out.println("3. Como melhorar");
        System.out.println("4. Finalizar edição");
    }
}

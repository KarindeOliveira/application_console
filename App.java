package com.ciandt.feedfront.application;

import com.ciandt.feedfront.controller.EmployeeController;
import com.ciandt.feedfront.controller.FeedbackController;
import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.BusinessException;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws BusinessException, ArquivoException {
        FeedbackController feedBackController = new FeedbackController();
        EmployeeController employeeController = new EmployeeController();

        Scanner sc = new Scanner(System.in);
        int opcao;

        System.out.println("---------- Seja bem-vindo ao FeedFront! ----------");

        // Menu 1
        System.out.println("1. Menu Employee");
        System.out.println("2. Menu Feedback");
        opcao = sc.nextInt();
        if(opcao ==1){
            System.out.println("1. Cadastrar");
            System.out.println("2. Consultar");
            System.out.println("3. Editar");
            System.out.println("4. Excluir");
            System.out.println("Digite sua opção:");
            opcao = sc.nextInt();
            switch (opcao) {
                    case 1:
                        UI.createEmployee();
                        System.out.println("Ação concluida");
                        UI.clearScreen();
                        break;
                    case 2:
                        UI.buscarEmployee();
                        System.out.println("Ação concluida");
                        UI.clearScreen();
                        break;
                    case 3:
                        // atualizar
                        break;
                    case 4:
                        UI.excluirEmployee();
                        System.out.println("Ação concluida");
                        UI.clearScreen();
                        break;
                    default:
                }

        } else if (opcao == 2 ) {
            System.out.println("1. Cadastrar");
            System.out.println("2. Consultar");
            System.out.println("3. Editar");
            System.out.println("4. Excluir");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    UI.createFeedBack();
                    System.out.println("Ação concluida");
                    UI.clearScreen();
                    break;
                case 2:
                    UI.buscarFeedBack();
                    System.out.println("Ação concluida");
                    UI.clearScreen();
                    break;
                case 3:
                    // atualizar
                    break;
                case 4: UI.excluirFeedBack();
                    System.out.println("Ação concluida");
                    UI.clearScreen();
                    break;
                default:
            }
        } else {

            System.out.println("Opção inválida. Digite novamente");
            opcao = sc.nextInt();


            sc.close();
        }
    }}


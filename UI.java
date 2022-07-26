package com.ciandt.feedfront.application;

import com.ciandt.feedfront.controller.EmployeeController;
import com.ciandt.feedfront.controller.FeedbackController;
import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.BusinessException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.models.Feedback;

import java.time.LocalDate;
import java.util.Scanner;

public class UI {


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static void createEmployee() throws BusinessException, ArquivoException {
        String nome;
        String sobrenome;
        String email;
        Employee salvarNome;
        EmployeeController employeeController = new EmployeeController();
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre com o nome:");
        nome = sc.next();
        System.out.println("Entre com o sobrenome:");
        sobrenome = sc.next();
        System.out.println("Entre com o email:");
        email = sc.nextLine();
        salvarNome = employeeController.salvar(new Employee(nome, sobrenome, email));
    }

    public static Employee buscarEmployee() throws BusinessException, ArquivoException {
        FeedbackController feedBackController = new FeedbackController();
        EmployeeController employeeController = new EmployeeController();

        Scanner sc = new Scanner(System.in);
        String id;
        Employee buscarNome;
        System.out.println("Entre com o id:");
        id = sc.next();

        buscarNome = employeeController.buscar(id);
        return buscarNome;
    }

    public static Employee editarEmployee(Employee employee) throws BusinessException, ArquivoException {
        return null;
    }


    public static void excluirEmployee() throws BusinessException, ArquivoException {

        EmployeeController employeeController = new EmployeeController();
        Scanner sc = new Scanner(System.in);
        String id;
        System.out.println("Entre com o id:");
        id = sc.next();

        employeeController.apagar(id);

    }

    public static void createFeedBack() throws BusinessException, ArquivoException {
        String id;
        LocalDate data;
         String autor;
         String proprietario;
         String descricao;
         String arquivo;
         String oqueMelhora;
         String comoMelhora;
        Feedback salvarNome;
        FeedbackController feedBackController = new FeedbackController();
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre com o data:");
        data = LocalDate.parse(sc.next());
        System.out.println("Entre com o autor:");
        autor = sc.next();
        System.out.println("Entre com o proprietario:");
        proprietario = sc.nextLine();
        System.out.println("Entre com o arquivo:");
        arquivo = sc.next();
        System.out.println("Entre com o descricao:");
        descricao = sc.next();
        System.out.println("Entre com o oqueMelhora:");
        oqueMelhora = sc.next();
        System.out.println("Entre com o comoMelhora:");
        comoMelhora = sc.nextLine();
        salvarNome = feedBackController.salvar(new Feedback(data, autor, proprietario, descricao, oqueMelhora, comoMelhora));
    }

    public static Feedback buscarFeedBack() throws BusinessException, ArquivoException {
        FeedbackController feedbackController = new FeedbackController();
        EmployeeController employeeController = new EmployeeController();

        Scanner sc = new Scanner(System.in);
        String id;
        Feedback buscarNome;
        System.out.println("Entre com o id:");
        id = sc.next();

        buscarNome = feedbackController.buscar(id);
        return buscarNome;
    }

    public static Feedback editarEmployee(Feedback feedback) throws BusinessException, ArquivoException {
        return null;
    }


    public static void excluirFeedBack() throws BusinessException, ArquivoException {

        FeedbackController feedBackController = new FeedbackController();
        Scanner sc = new Scanner(System.in);
        String id;
        System.out.println("Entre com o id:");
        id = sc.next();

        feedBackController.apagar(id);

    }
}
package com.ciandt.feedfront.application;

import com.ciandt.feedfront.controller.EmployeeController;
import com.ciandt.feedfront.models.Employee;

import java.time.LocalDate;
import java.util.Scanner;

public class UIEmployee {

    public static void cadastrarEmployee() {
        EmployeeController employeeController = new EmployeeController();
        System.out.println("---------- Cadastrar Employee ----------");
        String nome, sobrenome, email;
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre com o nome:");
        nome = sc.next();
        System.out.println("Entre com o sobrenome:");
        sobrenome = sc.next();
        System.out.println("Entre com o email:");
        email = sc.next();
        Employee salvarNome;

        try {
       salvarNome = employeeController.salvar(new Employee(nome, sobrenome, email));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void consultarEmployee() {
        System.out.println("---------- Consultar Employee ----------");
        String id;
        Scanner sc = new Scanner(System.in);
        EmployeeController employeeController = new EmployeeController();
        Employee buscarNome;
        System.out.println("Entre com o id:");
        id = sc.next();
        try {
            buscarNome = employeeController.buscar(id);
            System.out.println(buscarNome.toString());


        } catch (Exception e) {
            System.out.println("Não foi possível encontrar o Employee informado");
        }

    }

    public static void editarEmployee() {
        System.out.println("---------- Editar Employee ----------");

        String nome, sobrenome, email;
        Scanner sc = new Scanner(System.in);
        EmployeeController employeeController = new EmployeeController();
        String id;
        Employee buscarNome;
        System.out.println("Entre com o id:");
        id = sc.next();

        try {
            buscarNome = employeeController.buscar(id);

        } catch (Exception e) {
            System.out.println("Não foi possível encontrar o Employee informado");
        }

        // Preencher dados do Employee
        System.out.println("Entre com o nome:");
        nome = sc.next();
        System.out.println("Entre com o sobrenome:");
        sobrenome = sc.next();
        System.out.println("Entre com o email:");
        email = sc.next();

        // Salvar Employee atualizado
        try {
            // salvarNome = employeeController.salvar(new Employee(nome, sobrenome, email));
        } catch (Exception e) {
            System.out.println("Não foi possível atualizar o Employee");
        }
    }


    public static void excluirEmployee() {
        System.out.println("---------- Excluir Employee ----------");
//        EmployeeController employeeController = new EmployeeController();
        Scanner sc = new Scanner(System.in);
        String id;
        System.out.println("Entre com o id:");
        id = sc.next();

        // Buscar Employee pelo id.
        try {
            // buscarNome = employeeController.buscar(id);
            // employeeController.apagar(id);
        } catch (Exception e) {
            System.out.println("Não foi possível encontrar o Employee informado");
        }


    }
}

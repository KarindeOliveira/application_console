package com.ciandt.feedfront.application;

import com.ciandt.feedfront.controller.EmployeeController;
import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.BusinessException;
import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import com.ciandt.feedfront.models.Employee;

import java.time.LocalDate;
import java.util.Scanner;

public class UIEmployee {

    public static void cadastrarEmployee() {
        System.out.println("---------- Cadastrar Employee ----------");
        String nome, sobrenome, email;
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre com o nome:");
        nome = sc.next();
        System.out.println("Entre com o sobrenome:");
        sobrenome = sc.next();
        System.out.println("Entre com o email:");
        email = sc.next();

        EmployeeController employeeController = new EmployeeController();
        Employee salvarNome;

        try {
            salvarNome = employeeController.salvar(new Employee(nome, sobrenome, email));
            System.out.println("Employee salvo: " + salvarNome.getId());
        } catch (ArquivoException e) {
            System.out.println("Não foi possível salvar");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        } catch (ComprimentoInvalidoException e) {
            System.out.println("Não foi possível salvar");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        } catch (BusinessException e) {
            System.out.println("Não foi possível salvar");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

    public static void consultarEmployee() {
        System.out.println("---------- Consultar Employee ----------");
        String id;
        Scanner sc = new Scanner(System.in);
        EmployeeController employeeController = new EmployeeController();

        System.out.println("Entre com o id:");
        id = sc.next();
        Employee employee;
        try {

            employee = employeeController.buscar(id);
            System.out.println(employee);
        } catch (BusinessException e) {
            System.out.println("Não foi possível encontrar o Employee informado");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        } catch (ArquivoException e) {
            System.out.println("Não foi possível encontrar o Employee informado");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
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
        Employee deletarNome;

        try {
            deletarNome = employeeController.buscar(id);
            employeeController.apagar(id);
        } catch (Exception e) {
            System.out.println("Não foi possível encontrar o Employee informado");
        }


        System.out.println("Entre com o nome:");
        nome = sc.next();
        System.out.println("Entre com o sobrenome:");
        sobrenome = sc.next();
        System.out.println("Entre com o email:");
        email = sc.next();
        Employee salvarNome;

        try {
            salvarNome = employeeController.salvar(new Employee(nome, sobrenome, email));
            System.out.println("Employee salvo: " + salvarNome.getId());
        } catch (Exception e) {
            System.out.println("Não foi possível atualizar o Employee");
        }
    }


    public static void excluirEmployee() {
        System.out.println("---------- Excluir Employee ----------");
        EmployeeController employeeController = new EmployeeController();
        Scanner sc = new Scanner(System.in);
        String id;
        System.out.println("Entre com o id:");
        id = sc.next();
        Employee excluirEmployee;

        try {
            excluirEmployee = employeeController.buscar(id);
            employeeController.apagar(id);
        } catch (Exception e) {
            System.out.println("Não foi possível encontrar o Employee informado");
        }


    }
}
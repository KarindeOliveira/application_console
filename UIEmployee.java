package com.ciandt.feedfront.application;

import com.ciandt.feedfront.controller.EmployeeController;
import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.BusinessException;
import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import com.ciandt.feedfront.models.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UIEmployee {

    public static void cadastrarEmployee() {
        String nome, sobrenome, email;
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre com o nome:");
        nome = sc.nextLine();
        System.out.println("Entre com o sobrenome:");
        sobrenome = sc.nextLine();
        System.out.println("Entre com o email:");
        email = sc.nextLine();

        EmployeeController employeeController = new EmployeeController();
        Employee employee;

        try {
            employee = employeeController.salvar(new Employee(nome, sobrenome, email));
            System.out.println("Employee salvo: " + employee.getId());
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

    public static Employee consultarEmployee() {
        String id;
        Scanner sc = new Scanner(System.in);
        EmployeeController employeeController = new EmployeeController();

        System.out.println("Entre com o id:");
        id = sc.next();
        Employee employee = null;
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
        return employee;
    }

    public static void editarEmployee() {
        String nome, sobrenome, email;
        Scanner sc = new Scanner(System.in);
        EmployeeController employeeController = new EmployeeController();
        int opcao = 0;

        Employee employee = consultarEmployee();

        menuCampoEdicao();
        opcao = Integer.parseInt(sc.nextLine());

        while (opcao != 4) {

            try {
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o novo nome:");
                        nome = sc.nextLine();
                        employee.setNome(nome);
                        System.out.println("Campo atualizado.");
                        break;
                    case 2:
                        System.out.println("Digite o novo sobrenome:");
                        sobrenome = sc.nextLine();
                        employee.setSobrenome(sobrenome);
                        System.out.println("Campo atualizado.");
                        break;
                    case 3:
                        System.out.println("Digite o novo e-mail:");
                        email = sc.nextLine();
                        employee.setEmail(email);
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
            employeeController.apagar(employee.getId());
        } catch (Exception e) {
            // ToDo: verificar se precisa ter o println aqui
            System.out.println("Não foi possível encontrar o Employee informado");
        }

        try {
            employee = employeeController.salvar(employee);
            System.out.println("Employee salvo: " + employee.getId());
        } catch (Exception e) {
            System.out.println("Não foi possível atualizar o Employee");
        }
    }


    public static void excluirEmployee() {
        EmployeeController employeeController = new EmployeeController();
        Scanner sc = new Scanner(System.in);

        Employee employee = consultarEmployee();

        System.out.println("Tem certeza que deseja excluir esse registro?");
        System.out.println("1. Confirmar");
        System.out.println("2. Cancelar");


        int opcao = sc.nextInt();

        while (opcao != 2) {
            if (opcao == 1) {
                try {
                    employeeController.apagar(employee.getId());
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

    public static void listarEmployee() {
        EmployeeController employeeController = new EmployeeController();
        try {
            List<Employee> employees = employeeController.listar();
            System.out.println(employees);
        } catch (Exception e) {

        }
    }

    public static void menuCampoEdicao(){
        System.out.println("Selecione o campo que deseja editar:");
        System.out.println("1. Nome");
        System.out.println("2. Sobrenome");
        System.out.println("3. E-mail");
        System.out.println("4. Finalizar edição");
    }
}
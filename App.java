package com.ciandt.feedfront.application;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int opcao, opcaoDetalhe = 0;

        System.out.println("---------- Seja bem-vindo ao FeedFront! ----------");

        UI.menuInicial();
        opcao = sc.nextInt();

        while (opcao != 3) {
            if (opcao == 1 || opcao == 2) {
                UI.menuDetalhado(opcao);
                opcaoDetalhe = sc.nextInt();
                while (opcaoDetalhe != 5) {
                    if (opcaoDetalhe > 0 && opcaoDetalhe < 6) {
                        UI.realizarAcao(opcao, opcaoDetalhe);
                        UI.clearScreen();
                        UI.menuDetalhado(opcao);
                        opcaoDetalhe = sc.nextInt();
                    } else {
                        System.out.println("Opção inválida. Digite novamente");
                        opcaoDetalhe = sc.nextInt();
                    }
                }
                opcao = 0;
            } else {
                if (opcaoDetalhe == 5) {
                    UI.menuInicial();
                    opcaoDetalhe = 0;
                } else  {
                    System.out.println("Opção inválida. Digite novamente");
                }
                opcao = sc.nextInt();
            }
        }

        sc.close();
    }}
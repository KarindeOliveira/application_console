package com.ciandt.feedfront.application;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int opcao, opcaoDetalhe = 0, maxOpcoes;
        boolean loopDetalhe = true;
        System.out.println("---------- Seja bem-vindo ao FeedFront! ----------");

        UI.menuInicial();
        opcao = sc.nextInt();

        while (opcao != 3) {
            if (opcao == 1 || opcao == 2) {
                if (opcao == 1) {
                    maxOpcoes = 7;
                } else {
                    maxOpcoes = 5;
                }
                UI.menuDetalhado(opcao);
                opcaoDetalhe = sc.nextInt();
                while (loopDetalhe) {
                    if (opcaoDetalhe > 0 && opcaoDetalhe < maxOpcoes) {
                        loopDetalhe = UI.realizarAcao(opcao, opcaoDetalhe);
                        UI.clearScreen();
                        if (loopDetalhe) {
                            UI.menuDetalhado(opcao);
                            opcaoDetalhe = sc.nextInt();
                        }
                    } else {
                        System.out.println("Opção inválida. Digite novamente");
                        opcaoDetalhe = sc.nextInt();
                    }
                }
                opcao = 0;
            } else {
                if (!loopDetalhe) {
                    UI.menuInicial();
                    loopDetalhe = true;
                } else  {
                    System.out.println("Opção inválida. Digite novamente");
                }
                opcao = sc.nextInt();
            }
        }

        sc.close();
    }}
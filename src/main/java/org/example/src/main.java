package org.example.src;

import org.example.src.model.Conversor;

import java.io.IOException;

import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException, InterruptedException {
        boolean manter = true;
        while (manter) {
            Conversor conversor = new Conversor();

            Scanner sc = new Scanner(System.in);

            System.out.println("""
                    Conversor de moeda :)

                    escolha uma moeda pra você converter:

                    1)Dólar --> Real.
                    2)Dólar --> Peso Argentino.
                    3)Peso Argentino --> Real.
                    4)Euro --> Real.
                    5)Euro --> Dólar.
                    6)Peso Argentino --> Euro.
                    7)sair
                    """);


            float valor = 0;
            float mostrar = 0;
            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    conversor.setMoeda("USD");
                    System.out.println("Qual a quantidade de valor convertido");
                    valor = sc.nextFloat();
                    mostrar = conversor.valorDesejado(valor, "BRL");
                    System.out.println(mostrar);
                    break;
                case 2:
                    conversor.setMoeda("USD");
                    System.out.println("Qual a quantidade de valor convertido");
                    valor = sc.nextFloat();
                    mostrar = conversor.valorDesejado(valor, "ARS");
                    System.out.println(mostrar);
                    break;
                case 3:
                    conversor.setMoeda("ARS");
                    System.out.println("Qual a quantidade de valor convertido");
                    valor = sc.nextFloat();
                    mostrar = conversor.valorDesejado(valor, "BRL");
                    System.out.println(mostrar);
                    break;
                case 4:
                    conversor.setMoeda("EUR");
                    System.out.println("Qual a quantidade de valor convertido");
                    valor = sc.nextFloat();
                    mostrar = conversor.valorDesejado(valor, "BRL");
                    System.out.println(mostrar);
                    break;
                case 5:
                    conversor.setMoeda("EUR");
                    System.out.println("Qual a quantidade de valor convertido");
                    valor = sc.nextFloat();
                    mostrar = conversor.valorDesejado(valor, "USD");
                    System.out.println(mostrar);
                    break;
                case 6:
                    conversor.setMoeda("ARS");
                    System.out.println("Qual a quantidade de valor convertido");
                    valor = sc.nextFloat();
                    mostrar = conversor.valorDesejado(valor, "EUR");
                    System.out.println(mostrar);
                    break;
                case 7:
                    manter = false;
                    break;
                default:
                    System.out.println("opção invalida");
                    System.out.println("escolha novamente");

            }

        }
    }
}

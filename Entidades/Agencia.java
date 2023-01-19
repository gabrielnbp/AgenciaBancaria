package Entidades;

import java.util.ArrayList;
import java.util.Scanner;

public class Agencia {

	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Conta> contasDoBanco;
	
	public static void main(String[] args) {
		contasDoBanco = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		
		System.out.println("===============================================================");
		System.out.println("========== Sejam bem vindos a nossa Agência Bancária ==========");
		System.out.println("===============================================================");
		System.out.println("=============== Escolha uma operação a realizar ===============");
		System.out.println("===============================================================");
		System.out.println("#          Opção 1 - Criar Conta          #");
		System.out.println("#          Opção 2 - Depositar            #");
		System.out.println("#          Opção 3 - Sacar                #");
		System.out.println("#          Opção 4 - Transferir           #");
		System.out.println("#          Opção 5 - Listar               #");
		System.out.println("#          Opção 6 - Sair                 #");
		
		int opcao = entrada.nextInt();
		
		switch(opcao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listar();
			break;
		case 6:
			System.out.println("Obrigado por utilizar nossos serviços!");
			System.exit(0);
		default:
			System.out.println("Opção inválida!");
			operacoes();
			break;
		}
		
		
	}
	
}


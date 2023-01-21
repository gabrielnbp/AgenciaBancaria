package Entidades;

/*
 * Esta atividade foi realizada com base em uma aula online, no YouTube, com auxílio do canal Zé codes"
 */

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Agencia {

	static ArrayList<Conta> contasDoBanco;
	
	public static void main(String[] args) {
		contasDoBanco = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("# === Selecione uma operação === #" + 
																	"\nOpção 1 - Criar Conta" +
																	"\nOpção 2 - Depositar" +
																	"\nOpção 3 - Sacar" +
																	"\nOpção 4 - Transferir" +
																	"\nOpção 5 - Listar" +
																	"\nOpção 6 - Sair"));
		
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
			JOptionPane.showMessageDialog(null, "Obrigado por utilizar nossos serviços!");
			System.exit(0);
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!");
			operacoes();
			break;
		}
		
		
	}
	
	public static void criarConta() {
		PessoaFisica pessoaFisica = new PessoaFisica();
			
		pessoaFisica.setNome(JOptionPane.showInputDialog("Nome:"));
		pessoaFisica.setCpf(JOptionPane.showInputDialog("CPF:"));
		pessoaFisica.setEmail(JOptionPane.showInputDialog("Email:"));
		
		Conta conta = new Conta(pessoaFisica);
		contasDoBanco.add(conta);
		JOptionPane.showMessageDialog(null, "Sua conta foi criada!");
		 
		operacoes();
	}
	
	private static Conta encontrarConta(int numConta) {
		Conta conta = null;
		if(contasDoBanco.size() > 0) {
			for(Conta c : contasDoBanco) {
				if(c.getNumeroConta() == numConta) {
					conta = c;
				}
			}
		}
		
		return conta;
	}
	
	public static void depositar() {
		int numConta = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta para depósito:"));
		
		Conta conta = encontrarConta(numConta);
		
		if(conta != null) {
			double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor que deseja depositar:"));
			conta.depositar(valorDeposito);
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível localizar a conta informada!");
			System.out.println("Não foi possível localizar a conta informada!");
		}
		
		operacoes();
	}
	
	public static void sacar() {
		int numConta = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta para sacar:"));
		
		Conta conta = encontrarConta(numConta);
		
		if(conta != null) {
			double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor que deseja sacar:"));
			conta.sacar(valorSaque);
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível localizar a conta informada!");
		}
		
		operacoes();
	}
	
	public static void transferir() {
		int numContaRemetente = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta remetente:"));
		
		Conta contaRemetente = encontrarConta(numContaRemetente);
		
		if(contaRemetente != null) {
			int numContaDestinatario = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta do destinatário:"));
			
			Conta contaDestinatario = encontrarConta(numContaDestinatario);
			
			if(contaDestinatario != null) {
				double valorTransf = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da transferência:"));
				
				contaRemetente.transferir(contaDestinatario, valorTransf);
			} else {
				JOptionPane.showMessageDialog(null, "A conta do destinatário não foi localizada!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "A conta do remetente não foi localizada!");
		}	
		
		operacoes();
	}
	
	public static void listar() {
		if(contasDoBanco.size() > 0) {
			for(Conta c : contasDoBanco) {
				JOptionPane.showMessageDialog(null, c);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Não possuímos contas cadastradas!");
		}
		
		operacoes();
	}
}


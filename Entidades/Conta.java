package Entidades;

/*
 * Esta atividade foi realizada com base em uma aula online, no YouTube, com auxílio do canal Zé codes"
 */

import javax.swing.JOptionPane;

import Utilitarios.ConverteSaldo;

public class Conta {
	
	private static int contDeContas = 1;
	
	private int numeroConta;
	private PessoaFisica pessoaFisica;
	private double saldo = 0.0;
	
	public Conta(PessoaFisica pessoaFisica) {
		this.numeroConta = contDeContas;
		this.pessoaFisica = pessoaFisica;
		contDeContas += 1;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "\nNúmero da Conta: " + this.getNumeroConta() +
				"\nNome: " + this.pessoaFisica.getNome() +
				"\nCPF: " + this.pessoaFisica.getCpf() +
				"\nEmail: " + this.pessoaFisica.getEmail() +
				"\nSaldo: " + ConverteSaldo.doubleToString(this.getSaldo()) +
				"\n";
	}
	
	public void depositar(double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
			JOptionPane.showMessageDialog(null, "Seu depósito foi finalizado!");
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível efetuar o depósito!");
		}
	}
	
	public void sacar(double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			JOptionPane.showMessageDialog(null, "Seu saque foi finalizado!");
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível efetuar o saque!");
		}
	}
	
	public void transferir(Conta contaRecebeDeposito, double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			
			contaRecebeDeposito.saldo = contaRecebeDeposito.getSaldo() + valor;
			JOptionPane.showMessageDialog(null, "Transferência efetuada com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transferência!");
		}
	}
	
}

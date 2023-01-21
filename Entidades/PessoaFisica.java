package Entidades;

/*
 * Esta atividade foi realizada com base em uma aula online, no YouTube, com auxílio do canal Zé codes"
 */

public class PessoaFisica {
	
	private static int contDeClientes = 1;
	
	private String nome;
	private String cpf;
	private String email;
	
	public PessoaFisica() {}
	
	public PessoaFisica(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		contDeClientes += 1;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "\nNome: " + this.getNome() + 
				"\nCPF: " + this.getCpf() +
				"\nEmail: " + this.getEmail();
	}
	
}

package evolucao;

public class Pessoa {

	private String nome;
	private String cpf;
	private double salario;
	private int numeroFilhos;

	public Pessoa(String nome, String cpf, double salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}

	public Pessoa() {
	}

	void modificaNome(String nome) {
		this.nome = nome;
	}

	public void setNumeroDeFilhos(int num) {
		this.numeroFilhos = num;
	}

	public int getNumeroFilhos() {
		return numeroFilhos;
	}

	public double aumetaSalario(double qtdSalario) {
		this.salario += qtdSalario;
		return salario;
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	private class Mae {
	}

	public class Pai {

	}

	class Filho {

	}

	class Neto {

	}

}

public class Pessoa {
	
	String nome;
	String telefone;

	/**
	 * Construtor Default
	 */
	public Pessoa() {
	}

	/**
	 * Construtor Espec�fico
	 * @param nome
	 * @param telefone
	 */
	public Pessoa(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}

	/**
	 * Retona o nome da pessoa
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Seta o nome da pessoa
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o telefone da pessoa
	 * @return
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Seta o telefone da pessoa
	 * @param telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", telefone=" + telefone + "]";
	}

}

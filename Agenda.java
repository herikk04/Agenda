package Agenda;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Agenda {
	
	String nome;
	ArrayList<Pessoa> pessoas;
	HashMap<String, ArrayList<Pessoa>> contatos;
	String[] chaves = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
			"T", "U", "V", "W", "Y", "Z" };

	/**
	 * Construtor Específico
	 */
	public Agenda() {
		this.pessoas = new ArrayList<Pessoa>();
		this.contatos = new HashMap<String, ArrayList<Pessoa>>();
	}
	

	/**
	 * Método para inicializar os contatos na Agenda
	 */
	public void inicializandoContatos() {
		for (String chave : chaves) {
			contatos.put(chave, pessoas);
		}
		System.out.println("Lista de chaves adicionadas: " + contatos.toString());
	}

	/**
	 * Método para adicionar pessoas na Agenda
	 * @param pessoa
	 */
	public void adicionarContato(Pessoa pessoa) {
		String chave = null;
		chave = pessoa.getNome().substring(0, 1);
		
		pessoas = new ArrayList<Pessoa>();
		pessoas.addAll(contatos.get(chave));
		pessoas.add(pessoa);
		

		if (contatos.containsKey(chave)) {
			contatos.put(chave, pessoas);
			JOptionPane.showMessageDialog(null, "Os dados fornecidos foram adicionados na agenda","Contato Adicionado",1);
		} else {
			System.out.println("Chave não existe!");
		}

	}
	
	/**
	 * Método para consular pessoas na Agenda
	 * @param nome
	 */
	public void consultarContato(String nome) {
		String chave = null;
		chave = nome.substring(0,1);
		String procuraContato = "";
	
		if (contatos.containsKey(chave)) {
			for (Pessoa pessoa: pessoas) {
				if (pessoa.getNome().contains(nome)) {
					procuraContato += pessoa.toString();
				} 
			}
			if (!procuraContato.equals("")) {
				JOptionPane.showMessageDialog(null, "Contato(s) encontrado(s) na Agenda: \n\n" +procuraContato, "Resultado", 1);
				
			} else {
				JOptionPane.showMessageDialog(null, "Contato não encontrado na agenda","Resultado",0);
			}
		}
	}
	
	/**
	 * Método para remover as pessoas na Agenda
	 * @param nome
	 */
	public void removerContato(String nome) {
		String chave = null;
		chave = nome.substring(0, 1);
		
		int nomeInicial = 0;

		if (contatos.containsKey(chave)) {
			
			for (Pessoa pessoa : pessoas) {
				if (pessoa.getNome().equals(nome)) {
					nomeInicial = pessoas.indexOf(pessoa);
				}
			}
			
			if (pessoas.get(nomeInicial).getNome().substring(0, 1).equals(chave)) {
				pessoas.remove(nomeInicial);
				JOptionPane.showMessageDialog(null, "O contato " + nome + " acabou de ser removido com sucesso!");
			}
			
		}
	}
	
	
	/**
	 * Método para retornar a lista atualizada dos contatos na Agenda
	 * @return
	 */
	public String retornaListaAgenda() {
		return " Contatos integrado na Agenda Eletrônica\n\n" + contatos;
	}

	/**
	 * Método para retornar o nome da pessoa
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método para setar o nome da pessoa
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método para retornar as pessoas do ArrayList
	 * @return
	 */
	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	/**
	 * Método para setar as pessoas do Arraylist 
	 * @param pessoas
	 */
	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	/**
	 * Método para retonar os contatos
	 * @return
	 */
	public HashMap<String, ArrayList<Pessoa>> getContatos() {
		return contatos;
	}

	/**
	 * Método para setar os contatos
	 * @param contatos
	 */
	public void setContatos(HashMap<String, ArrayList<Pessoa>> contatos) {
		this.contatos = contatos;
	}
	
	

}
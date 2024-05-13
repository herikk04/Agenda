package Agenda;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {
		
		String acaoEscolhida = "";
		int continuaAcao = 0;

		Pessoa pessoa;
		String nome = "";
		String telefone = "";

		Agenda agenda = new Agenda();
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		HashMap<String, ArrayList<Pessoa>> contatos = new HashMap<String, ArrayList<Pessoa>>();

		agenda.inicializandoContatos();
		
		JOptionPane.showMessageDialog(null, "Olá, seja bem vindo a Agenda Eletrônica! ", "Saudações", 1);
		
		//Laço para realizar ações até o momento da sua finalização
		do {
			acaoEscolhida = JOptionPane.showInputDialog(null, "Informe qual ação deseja realizar no sistema: \n\n 1- Adicionar contato \n 2- Consultar contato \n 3- Remover contato \n 4- Visualizar Agenda ", "Escolha da Ação", 1);
			
			//Switch escolher a ação do usuário
			switch (acaoEscolhida) {
			case "1":
				//Laço para adiconar até o usuário não quiser adicionar mais ninguém na agenda
				do {
					nome = JOptionPane.showInputDialog(null,"Informe o nome da pessoa: ","Inserção de dados",1);
					nome = nome.toUpperCase();
					telefone = JOptionPane.showInputDialog(null,"Informe o telefone da pessoa: ","Inserção de dados",1); 
					
					pessoa = new Pessoa(nome, telefone);
					
					agenda.adicionarContato(pessoa);
					continuaAcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Gostaria de adicionar outra pessoa? \n1- Sim \n2- Não","Confirmação",1));
					
				}while(continuaAcao == 1);
				
			break;
			
			case "2":
				//Laço para consultar até o usuário não quiser consultar mais ninguém na agenda
				do {
					nome = JOptionPane.showInputDialog(null,"Informe o nome da pessoa: ","Inserção de dados",1);
					nome = nome.toUpperCase();
					
					agenda.consultarContato(nome);
					continuaAcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Gostaria de consultar outra pessoa? \n1- Sim \n2- Não","Confirmação",1));
					
				}while(continuaAcao == 1);
				
			break;
			
			case "3":
				//Laço para remover até o usuário não quiser remover mais ninguém na agenda
				do {
					nome = JOptionPane.showInputDialog(null,"Informe o nome completo da pessoa: ","Inserção de dados",1);
					nome = nome.toUpperCase();

					agenda.removerContato(nome);
					continuaAcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Gostaria de remover outra pessoa? \n1- Sim \n2- Não","Confirmação",1));
					
				} while (continuaAcao == 1);
				
			break;	
			
			case "4":
				//Mensagem retorna a lista atualizada
				JOptionPane.showMessageDialog(null, agenda.retornaListaAgenda(), "Agenda Completa", 1);
				
			break;	
			}
			
			//Pergunta ao usuário se ele quer realizar mais alguma ação, assim o laço ocorrerá novamente ou não
			continuaAcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Gostaria de realizar mais alguma ação? \n1- Sim \n2- Não","Confirmação",1));
			
		} while (continuaAcao == 1);
	}

}

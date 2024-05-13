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
		
		JOptionPane.showMessageDialog(null, "Ol�, seja bem vindo a Agenda Eletr�nica! ", "Sauda��es", 1);
		
		//La�o para realizar a��es at� o momento da sua finaliza��o
		do {
			acaoEscolhida = JOptionPane.showInputDialog(null, "Informe qual a��o deseja realizar no sistema: \n\n 1- Adicionar contato \n 2- Consultar contato \n 3- Remover contato \n 4- Visualizar Agenda ", "Escolha da A��o", 1);
			
			//Switch escolher a a��o do usu�rio
			switch (acaoEscolhida) {
			case "1":
				//La�o para adiconar at� o usu�rio n�o quiser adicionar mais ningu�m na agenda
				do {
					nome = JOptionPane.showInputDialog(null,"Informe o nome da pessoa: ","Inser��o de dados",1);
					nome = nome.toUpperCase();
					telefone = JOptionPane.showInputDialog(null,"Informe o telefone da pessoa: ","Inser��o de dados",1); 
					
					pessoa = new Pessoa(nome, telefone);
					
					agenda.adicionarContato(pessoa);
					continuaAcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Gostaria de adicionar outra pessoa? \n1- Sim \n2- N�o","Confirma��o",1));
					
				}while(continuaAcao == 1);
				
			break;
			
			case "2":
				//La�o para consultar at� o usu�rio n�o quiser consultar mais ningu�m na agenda
				do {
					nome = JOptionPane.showInputDialog(null,"Informe o nome da pessoa: ","Inser��o de dados",1);
					nome = nome.toUpperCase();
					
					agenda.consultarContato(nome);
					continuaAcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Gostaria de consultar outra pessoa? \n1- Sim \n2- N�o","Confirma��o",1));
					
				}while(continuaAcao == 1);
				
			break;
			
			case "3":
				//La�o para remover at� o usu�rio n�o quiser remover mais ningu�m na agenda
				do {
					nome = JOptionPane.showInputDialog(null,"Informe o nome completo da pessoa: ","Inser��o de dados",1);
					nome = nome.toUpperCase();

					agenda.removerContato(nome);
					continuaAcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Gostaria de remover outra pessoa? \n1- Sim \n2- N�o","Confirma��o",1));
					
				} while (continuaAcao == 1);
				
			break;	
			
			case "4":
				//Mensagem retorna a lista atualizada
				JOptionPane.showMessageDialog(null, agenda.retornaListaAgenda(), "Agenda Completa", 1);
				
			break;	
			}
			
			//Pergunta ao usu�rio se ele quer realizar mais alguma a��o, assim o la�o ocorrer� novamente ou n�o
			continuaAcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Gostaria de realizar mais alguma a��o? \n1- Sim \n2- N�o","Confirma��o",1));
			
		} while (continuaAcao == 1);
	}

}

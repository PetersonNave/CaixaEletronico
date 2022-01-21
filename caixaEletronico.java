package projeto_1;

import java.util.Scanner;

public class caixaEletronico {

	public static void main(String[] args) {
		
		// PR� SISTEMA
		// Criar uma matriz com informa��es dos clientes
		
		
		//               Numero da Conta   Nome			  Saldo Inicial
		String[][] clientes = {{"130729", "Pedro Lucas" , "50.00"},
								{"128790","Peterson Melo","100.00"},
								{"132956","Miguel Farias" ,"630.00"}};
		
		// (os valores est�o em string, mas ser�o convertidos em doubles posteriormente,
		//tinha outras op��es, mas decidi fazer uma matriz para ser mais fiel ao que a quest�o pedia.
		
		
		//SISTEMA
		//Solicitar o n�mero da conta e apresentar os valores referentes ao n�mero digitado.
		
		System.out.print("Boas-Vindas ao Banco Inter!");
		//variavel para verificar se o sistema encontrou uma conta, caso n�o, a estrutura se repetir�
		boolean logIn = false;
		do {
			
							
				System.out.print("\nInforme o n�mero da conta para continuar: ");
				
				//Captura do n�mero da conta do cliente
				Scanner sc = new Scanner(System.in);
				int numeroDaConta = sc.nextInt();
				
				//Essa vari�vel ir� funcionar como um token posteriormente, que nos dir� se o cliente j� logou e saiu da conta
				//caso seja verdadeira, uma mensagem de boas vindas ir� aparecer e em seguida capturamos o n�mero da conta
				//caso n�o, o sistema interpreta que o cliente apenas errou o n�mero da conta e ao inv�s de boas vindas novamente,
				//pediremos o n�mero da conta novamente apenas.
				boolean exitSystem = false;
				
				
				//Estrutura de repeti��o para verificar se h� alguma conta com o numero da conta digitado
				for(int i = 0; i < clientes.length; i++ ) {
					
						
					if(Integer.parseInt(clientes[i][0]) == numeroDaConta) {
						//como na matriz clientes, cada cliente representa uma linha, ao encontrarmos um n�mero da conta igual o digitado,
						//iremos usar a mesma linha "I" para todas as opera��es, mudando apenas as colunas, que representam os dados dos clientes.
						
						System.out.println("Sucesso!");				
						
															// aqui por exemplo, como sei que a coluna 1 representa o nome do cliente, o valor fica fixo.
															//o �nico valor que varia � a linha "I", que representa o "ID" do cliente logado;
						System.out.println("Bem-vindo(a) " + clientes[i][1]);
						
						
						//aqui teremos uma estrutura de repeti��o, que s� acaba quando o cliente quiser sair do sistema,
						//a� mudaremos o booleano "exitSystem" para false e a estrutura de repeti��o acabar�.
								do {
									System.out.println("##################### \nDigite uma op��o: \n1 - Exibir Saldo \n2 - Saque\n3 - Deposito \n4 = Deslogar \n5 - Encerrar o sistema");
									
									System.out.print("\nDigite uma op��o e aperte Enter: ");
									int option = sc.nextInt();
									switch(option) {
									case 1:
									System.out.println("\n \n \n \n"+clientes[i][1]+", seu saldo � de R$"+clientes[i][2]);
									break;				
									
									case 2:
										clientes[i][2] = Saque(clientes[i][2]);		
									break;	
									
									case 3:
										clientes[i][2] = Deposito(clientes[i][2]);
									break;	
									
									case 4:
										exitSystem = true;
										logIn = false;
									break;
									
									case 5:
										exitSystem = true;
										logIn = true;
									break;
										
									default:
									System.out.println("Por favor, selecione uma op��o v�lida!");	
									break;
							}}while(exitSystem == false);
								
						break;
					}
					
					
				}
				
			
				if(!logIn) {
					if(exitSystem == true) {
						System.out.print("\n\n\n\n\n\n\n\n\nBoas-Vindas ao Banco Inter!");
						exitSystem = false;
						
					}else {
						System.out.println("Ops! N�o encontramos nenhuma conta com esse n�mero... Tente novamente");
					}			
				}
			}while(!logIn); //quando a vari�vel login n�o for mais false, quer dizer que o usu�rio j� logou, mas encerrou o sistema
		
		System.out.println("Desligando o sistema...\n\n\n\n\n\n\n\nSistema encerrado");
		System.exit(0);
		
	}
	
	//FUN��ES
	
	
	//Fun��o saque
	public  static String Saque(String saldo) {
		
		//Capturar o valor do saque
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n\n######## SAQUE ########\n\n\n\n\n\n");
		System.out.print("Seu saldo: R$"+saldo+"\nDigite o valor que voc� quer sacar: ");
		double valorSaque = Double.parseDouble(sc.next());
		
		//Converter o par�metro saldo recebido como string para double;
		double saldoCliente = Double.parseDouble(saldo);
		
		//Verificar se o cliente possui saldo suficiente para sacar o valor desejado.
		if(saldoCliente - valorSaque >=0) {
			
			//Caso o cliente possua saldo suficiente, iremos retornar uma string chamada valorFinal,
			//que � a diferen�a do saldoCliente e valorSaque, que seria o saldo restante ap�s o saque;
			String valorFinal = String.valueOf(saldoCliente - valorSaque);
			System.out.println("Saque realizado!\nSeu novo saldo � R$"+ valorFinal );
			return valorFinal;
		}
		else {
			//Caso n�o, enviaremos uma mensagem de erro, e retornaremos o mesmo saldo recebido como par�metro,
			//j� que n�o alteramos nada.
			System.out.println("Dep�sito n�o realizado! Saldo insuficiente!");
			System.out.println("Seu saldo � R$"+ saldo);
			return saldo;
		}	
	}
	
	//Fun��o dep�sito:
	public  static String Deposito(String saldo) {
		
		//Capturar o valor do dep�sito
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n\n######## DEP�SITO ########\n\n\n\n\n\n");
		System.out.print("Seu saldo: R$"+saldo+"\nDigite o valor que voc� quer depositar: ");
		double valorDeposito = Double.parseDouble(sc.next());
		//Converter o par�metro saldo recebido como string para double;
		double saldoCliente = Double.parseDouble(saldo);
		
		
		//Verificar se o valor do dep�sito e maior que 0;
		if(valorDeposito>0) {
			
			//Caso seja, podemos fazer o dep�sito
			//A vari�vel "valorFinal" ir� ter a soma do valor do saldo que convertemos para double somado com o valor do dep�sito
			//Lembrando que o resultado foi convertido para String novamente, pois o retorno precisa ser String para armazenar na matriz "clientes"
			String valorFinal = String.valueOf(saldoCliente + valorDeposito);
			System.out.println("Deposito realizado!\nSeu novo saldo � R$"+ valorFinal );
			return valorFinal;
		}
		else {
			//Caso o valor seja igual ou inferior a zero, n�o podemos realizar o dep�sito.
			//mostrei uma mensagem de erro e retornei o mesmo valor recebido como par�metro, j� que n�o mexemos nele.
			System.out.println("Erro. Dep�sito minimo 1BRL");
			System.out.println("Seu saldo � R$"+ saldo);
			return saldo;
		}				
	}
}

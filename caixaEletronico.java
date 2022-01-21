package projeto_1;

import java.util.Scanner;

public class caixaEletronico {

	public static void main(String[] args) {
		
		// PRÉ SISTEMA
		// Criar uma matriz com informações dos clientes
		
		
		//               Numero da Conta   Nome			  Saldo Inicial
		String[][] clientes = {{"130729", "Pedro Lucas" , "50.00"},
								{"128790","Peterson Melo","100.00"},
								{"132956","Miguel Farias" ,"630.00"}};
		
		// (os valores estão em string, mas serão convertidos em doubles posteriormente,
		//tinha outras opções, mas decidi fazer uma matriz para ser mais fiel ao que a questão pedia.
		
		
		//SISTEMA
		//Solicitar o número da conta e apresentar os valores referentes ao número digitado.
		
		System.out.print("Boas-Vindas ao Banco Inter!");
		//variavel para verificar se o sistema encontrou uma conta, caso não, a estrutura se repetirá
		boolean logIn = false;
		do {
			
							
				System.out.print("\nInforme o número da conta para continuar: ");
				
				//Captura do número da conta do cliente
				Scanner sc = new Scanner(System.in);
				int numeroDaConta = sc.nextInt();
				
				//Essa variável irá funcionar como um token posteriormente, que nos dirá se o cliente já logou e saiu da conta
				//caso seja verdadeira, uma mensagem de boas vindas irá aparecer e em seguida capturamos o número da conta
				//caso não, o sistema interpreta que o cliente apenas errou o número da conta e ao invés de boas vindas novamente,
				//pediremos o número da conta novamente apenas.
				boolean exitSystem = false;
				
				
				//Estrutura de repetição para verificar se há alguma conta com o numero da conta digitado
				for(int i = 0; i < clientes.length; i++ ) {
					
						
					if(Integer.parseInt(clientes[i][0]) == numeroDaConta) {
						//como na matriz clientes, cada cliente representa uma linha, ao encontrarmos um número da conta igual o digitado,
						//iremos usar a mesma linha "I" para todas as operações, mudando apenas as colunas, que representam os dados dos clientes.
						
						System.out.println("Sucesso!");				
						
															// aqui por exemplo, como sei que a coluna 1 representa o nome do cliente, o valor fica fixo.
															//o único valor que varia é a linha "I", que representa o "ID" do cliente logado;
						System.out.println("Bem-vindo(a) " + clientes[i][1]);
						
						
						//aqui teremos uma estrutura de repetição, que só acaba quando o cliente quiser sair do sistema,
						//aí mudaremos o booleano "exitSystem" para false e a estrutura de repetição acabará.
								do {
									System.out.println("##################### \nDigite uma opção: \n1 - Exibir Saldo \n2 - Saque\n3 - Deposito \n4 = Deslogar \n5 - Encerrar o sistema");
									
									System.out.print("\nDigite uma opção e aperte Enter: ");
									int option = sc.nextInt();
									switch(option) {
									case 1:
									System.out.println("\n \n \n \n"+clientes[i][1]+", seu saldo é de R$"+clientes[i][2]);
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
									System.out.println("Por favor, selecione uma opção válida!");	
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
						System.out.println("Ops! Não encontramos nenhuma conta com esse número... Tente novamente");
					}			
				}
			}while(!logIn); //quando a variável login não for mais false, quer dizer que o usuário já logou, mas encerrou o sistema
		
		System.out.println("Desligando o sistema...\n\n\n\n\n\n\n\nSistema encerrado");
		System.exit(0);
		
	}
	
	//FUNÇÕES
	
	
	//Função saque
	public  static String Saque(String saldo) {
		
		//Capturar o valor do saque
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n\n######## SAQUE ########\n\n\n\n\n\n");
		System.out.print("Seu saldo: R$"+saldo+"\nDigite o valor que você quer sacar: ");
		double valorSaque = Double.parseDouble(sc.next());
		
		//Converter o parâmetro saldo recebido como string para double;
		double saldoCliente = Double.parseDouble(saldo);
		
		//Verificar se o cliente possui saldo suficiente para sacar o valor desejado.
		if(saldoCliente - valorSaque >=0) {
			
			//Caso o cliente possua saldo suficiente, iremos retornar uma string chamada valorFinal,
			//que é a diferença do saldoCliente e valorSaque, que seria o saldo restante após o saque;
			String valorFinal = String.valueOf(saldoCliente - valorSaque);
			System.out.println("Saque realizado!\nSeu novo saldo é R$"+ valorFinal );
			return valorFinal;
		}
		else {
			//Caso não, enviaremos uma mensagem de erro, e retornaremos o mesmo saldo recebido como parâmetro,
			//já que não alteramos nada.
			System.out.println("Depósito não realizado! Saldo insuficiente!");
			System.out.println("Seu saldo é R$"+ saldo);
			return saldo;
		}	
	}
	
	//Função depósito:
	public  static String Deposito(String saldo) {
		
		//Capturar o valor do depósito
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n\n######## DEPÓSITO ########\n\n\n\n\n\n");
		System.out.print("Seu saldo: R$"+saldo+"\nDigite o valor que você quer depositar: ");
		double valorDeposito = Double.parseDouble(sc.next());
		//Converter o parâmetro saldo recebido como string para double;
		double saldoCliente = Double.parseDouble(saldo);
		
		
		//Verificar se o valor do depósito e maior que 0;
		if(valorDeposito>0) {
			
			//Caso seja, podemos fazer o depósito
			//A variável "valorFinal" irá ter a soma do valor do saldo que convertemos para double somado com o valor do depósito
			//Lembrando que o resultado foi convertido para String novamente, pois o retorno precisa ser String para armazenar na matriz "clientes"
			String valorFinal = String.valueOf(saldoCliente + valorDeposito);
			System.out.println("Deposito realizado!\nSeu novo saldo é R$"+ valorFinal );
			return valorFinal;
		}
		else {
			//Caso o valor seja igual ou inferior a zero, não podemos realizar o depósito.
			//mostrei uma mensagem de erro e retornei o mesmo valor recebido como parâmetro, já que não mexemos nele.
			System.out.println("Erro. Depósito minimo 1BRL");
			System.out.println("Seu saldo é R$"+ saldo);
			return saldo;
		}				
	}
}

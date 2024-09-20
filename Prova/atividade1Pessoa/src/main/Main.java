package main;

import java.util.Scanner;

import entities.Pessoa;

public class Main {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		// LOOP - PANEL
		int escolha = -1;

		System.out.println(" ### GERENCIAMENTO DE CLIENTES ### ");

		while (escolha != 0) {
			System.out.println();
			System.out.println();
			// ENTRADA
			System.out.print("-Escolha uma ação: ");
			System.out.println("1-Cadastrar, 2-Listar todos, 3-Buscar por telefone, \n"
					+ " 4-Deletar pessoa por ID, 0-Sair ");
			System.out.print("< ");

			escolha = scan.nextInt();

			// TOMAR ACAO
			switch (escolha) {
			case 1: addPessoa();
				break;
			case 2: listarPessoas();
				break;
			case 3: buscarPessoa();
				break;
			case 4: deletarPessoa();
				break;
			case 0: System.out.println( ">saindo..." ); 
				break;
			default: System.out.println( ">Ação inválida!!!" );
			}

		}
		
		System.out.println( " FIM - GERENCIAMENTO DE CLIENTES " );

	}
	
	private static void deletarPessoa() 
	{
		int scnID;
		
		System.out.println( " -- DELETAR PESSOA -- " );
		System.out.println( "-Digite o id da pessoa a ser deletada:" );
		System.out.print( "< " );
		
		scnID = scan.nextInt();
		
		Pessoa pessoaDeletada = Pessoa.deletarPessoa(scnID);
		
		if( pessoaDeletada == null  ) //<<NÃO ENCOTROU 
		{
			System.out.println( " ID não existente! " );
			return;
		}
		System.out.println( " >A seguinte pessoa foi deletada: " );
		Pessoa.printPessoa(pessoaDeletada);
		
	}

	private static void listarPessoas() {
		System.out.println( " -- PRINTANDO PESSOAS -- " );
		Pessoa.listarPessoas();
	}
	
	private static void buscarPessoa() {
		String pTel;
		Pessoa pBuscada;
		
		System.out.println( " -- BUSCAR PESSOA POR TELEFONE -- " );
		System.out.println( "-Digite o TELEFONE da pessoa para busca-la" );
		System.out.print("< ");
		pTel = scan.next();
		
		pBuscada = Pessoa.buscarTelefone(pTel);
		
		if( pBuscada == null ) {
			System.out.println( ">TELEFONE inexistente!!!");
			return;
		}
		System.out.println( ">O TELEFONE " + pTel + " pertence a seguinte pessoa: " );
		Pessoa.printPessoa(pBuscada);
		
	}
	
	private static void addPessoa() {
		// ENTRADA - PESSOA atributos
		Pessoa nPessoa;
		
		System.out.println( " -- ADICIONAR PESSOA COM ATRIBUTOS --" );

		System.out.println("-Digite o nome da pessoa: ");
		System.out.print("< ");
		String pesNome = scan.next();

		System.out.println("-Digite a data de nascimento: ");
		System.out.print("< ");
		String pesDataNascimento = scan.next();

		System.out.println("-Digite o sexo: ");
		System.out.print("< ");
		char pesSexo = scan.next().charAt(0);

		System.out.println("-Digite o nome da mãe: ");
		System.out.print("< ");
		String pesMae = scan.next();

		System.out.println("-Digite o nome da pai: ");
		System.out.print("< ");
		String pesPai = scan.next();

		System.out.println("-Digite o endereço completo: ");
		System.out.print("< ");
		String pesEndereco = scan.next();

		System.out.println("-Digite o email: ");
		System.out.print("< ");
		String pesEmail = scan.next();

		System.out.println("-Digite o TELEFONE: ");
		System.out.print("< ");
		String pesTel = scan.next();

		System.out.println("-Digite a URL da foto: ");
		System.out.print("< ");
		String pesFoto = scan.next();

		nPessoa = new Pessoa(pesNome, pesDataNascimento, pesSexo, pesMae, pesPai, pesEndereco, pesEmail, pesTel,
				pesFoto);

		System.out.println(">A seguinte pessoa foi cadastrada: ");
		Pessoa.printPessoa(nPessoa);

	}

}
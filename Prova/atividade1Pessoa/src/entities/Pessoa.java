package entities;

import java.util.ArrayList;

public class Pessoa {
	private static ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	private static int counter_ID = pessoas.size();
	
	public int pes_id;
	public String nome;
	public String data_nascimento;
	
	private char pes_sexo;
	private String  pes_mae;
	private String pes_pai;
	
	public String endereco_completo;
	
	private String email;
	private String telefone;
	
	public String url_foto;
	//CONSTRUTORS
	public Pessoa(String nome, String data_nascimento, char pes_sexo, String pes_mae, String pes_pai,
			String endereco_completo, String email, String telefone, String url_foto) {
		this.pes_id = counter_ID++;
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.pes_sexo = pes_sexo;
		this.pes_mae = pes_mae;
		this.pes_pai = pes_pai;
		this.endereco_completo = endereco_completo;
		this.email = email;
		this.telefone = telefone;
		this.url_foto = url_foto;
		
		addPessoa( this );
		
		
	}
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
	
	//CRUD
	public static void addPessoa( Pessoa pes ) {
		pessoas.add(pes);
	}
	
	public static void listarPessoas() 
	{
		System.out.println( pessoas.size() );
		for( Pessoa iPess : pessoas ) 
		{
			printPessoa(iPess);
		}
	}
	public static Pessoa buscarTelefone( String tel ) 
	{
		
		//LOOP - BUSCA TELEFONE
		for( int i = 0; i<pessoas.size(); i++ ) 
		{
			Pessoa IPess = pessoas.get(i);
			if(  IPess.telefone.equals(tel) ) { //ACHOU
				return IPess;
			}
		}
		return null; //NÃO ACHOU
	}
	
	public static Pessoa deletarPessoa( int pessID ) 
	{
		int pessIndice= encontraIndiceDoID(pessID);
		if( pessIndice == -1 ) { //<NÃO ACHOU
			return null;
		}
		
		Pessoa pess = pessoas.get(pessIndice);
		
		pessoas.remove(pessIndice); //REMOVIDO
		return pess;
		
	}
	
	private static int encontraIndiceDoID( int pessID ) 
	{
		for( int i=0; i<pessoas.size(); i++)
		{
			Pessoa pess = pessoas.get(i);
			if( pess.pes_id == pessID )
			{
				return i; //ACHOU
			}
		}
		return -1;
	}
	
	public static void printPessoa( Pessoa pess ) 
	{
		//PRINT - PESSOA
		System.out.print(">");
		System.out.println( "Pessoa ID : " + pess.pes_id );
		System.out.println( ".nome: "  + pess.nome );
		//...outros atributos
		System.out.println( ".telefone: " + pess.telefone );
	}
	
	
	
}

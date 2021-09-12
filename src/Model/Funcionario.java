package Model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import View.InOut;

public class Funcionario {
	
	// Atributos:
	private int Cod_Func;
	private String Cpf_Func;
	private String Nome_Func;
	private String Funcao_Func;
	private double Salario;
	private static int contadorRegistros = 0;

	// Declaração dos ArrayLists:
	private static ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
/*
	public Funcionario(){
		contadorRegistros++;
		this.Cod_Func = contadorRegistros; 
	}*/

	// Construtor:
	public Funcionario(String Cpf, String Nome, String Funcao, double Salario) {
		contadorRegistros++;
		this.Cod_Func = contadorRegistros;
		this.Cpf_Func = Cpf;
		this.Nome_Func = Nome;
		this.Funcao_Func = Funcao;
		this.Salario = Salario;
	}

	// Gets e Sets:
	public int getCod_Func() {
		return Cod_Func;
	}

	public String getNome_Func() {
		return Nome_Func;
	}

	public void setNome_Func(String Nome) {
		this.Nome_Func = Nome;
	}

	public double getSalario() {
		return Salario;
	}

	public void setSalario(double Salario) {
		this.Salario = Salario;
	}

	public String getCpf_Func() {
		return Cpf_Func;
	}

	public void setCpf(String Cpf) {
		Cpf_Func = Cpf;
	}

	public String getFuncao_Func() {
		return Funcao_Func;
	}

	public void setFuncao_Func(String Funcao) {
		Funcao_Func = Funcao;
	}

	
	// Métodos para Manutenção de Funcionários:
	public static void cadastrarFunc() {
		String Nome = InOut.InString("Insira o Nome do Funcionario:");
		String Cpf = InOut.InString("Insira o CPF do Funcionario:");
		String Funcao = InOut.InString("Insira a função do Funcionario:");
		double Salario = InOut.InInt("Digite o Salario do Funcionario:");

		Funcionario funcionario = new Funcionario(Cpf, Nome, Funcao, Salario);
		listaFuncionarios.add(funcionario);
		
		
	}

	public static void listarFunc() throws IOException {
		if(listaFuncionarios.isEmpty()){
			InOut.OutMessage("Nenhum Funcionario consta no Cadastrado!");
			return;
		}

		FileWriter arq1 = new FileWriter("listafuncionarios.txt");
		PrintWriter gravaArq = new PrintWriter(arq1);
		String relatorio = "";
		gravaArq.printf("---------Lista de Funcionarios---------\r\n");
		for(int i = 0; i < listaFuncionarios.size(); i++){
			Funcionario func = listaFuncionarios.get(i);
			gravaArq.printf(" - |CODIGO| %d |CPF| %s |NOME| %s |FUNCAO| %s |SALARIO| %f\r\n", 
					func.getCod_Func(), func.getCpf_Func(), func.getNome_Func(), func.getFuncao_Func(), func.getSalario());

			relatorio += "\nCodigo do Funcionário: " + func.getCod_Func() + 
					"\nCPF: " + func.getCpf_Func() +
					"\nNome do Funcionário: " + func.getNome_Func() +
					"\nFunção: " + func.getFuncao_Func() +
					"\nSalario: R$" + func.getSalario()+
					"\n----------------------------------------------------------\r";
		}
		gravaArq.close();
		InOut.OutMessage(relatorio);
	}

	public static void alterarFunc(){
		if(listaFuncionarios.size() == 0){
			InOut.OutMessage("Lista Vazia");
			return;
		}
		String nomeFuncionarioPesquisar = InOut.InString("Digite o Nome do Funcionario que deseja pesquisar:");
		for(int i=0; i < listaFuncionarios.size(); i++){
			Funcionario funcionario = listaFuncionarios.get(i);

			if(nomeFuncionarioPesquisar.equalsIgnoreCase(funcionario.getNome_Func())){
				String nomeNovo = InOut.InString("Digite o novo Nome do Funcionario:");
				funcionario.setNome_Func(nomeNovo);
				InOut.OutMessage("Nome alterado com sucesso");
				break;
			}
		}
		InOut.OutMessage("Funcionario não encontrado");
	}

	public static void procurarFunc(){
		String exibir = "";
		String nomeArq = "listafuncionarios.txt";
		String linha = "";
		File arq = new File(nomeArq);

		if(arq.exists()){
			exibir = "RELATORIO";
			try{
				FileReader abrindo = new FileReader(nomeArq);
				BufferedReader leitor = new BufferedReader(abrindo);
				while(true){
					linha = leitor.readLine();
					if(linha == null)
						break;
					exibir += linha + "\n";
				}
				leitor.close();
			}catch(Exception e){
				InOut.OutMessage("Erro: \n"+e.getMessage(), "ERRO");
			}
			InOut.OutMessage(exibir, "LISTA DE FUNCIONARIOS");
		}else{
			InOut.OutMessage("Arquivo inexistente", "ERRO");
		}
	}

	public static void deletarFunc(){
		if(listaFuncionarios.size() == 0){
			InOut.OutMessage("Lista Vazia");
			return;
		}
		String nomeFuncionarioPesquisar = InOut.InString("Digite o Nome do Funcionario que deseja Deletar:");
		for(int i=0; i < listaFuncionarios.size(); i++){
			Funcionario funcionario = listaFuncionarios.get(i);

			if(nomeFuncionarioPesquisar.equalsIgnoreCase(funcionario.getNome_Func())){
				listaFuncionarios.remove(i);
				InOut.OutMessage("Funcionario excluido com Sucesso!");
				break;
			}
		}
		InOut.OutMessage("Nome do Funcionario alterado com sucesso");
	}

	public static void apagarFunc() {
		if(listaFuncionarios.isEmpty()){
			InOut.OutMessage("Nenhum Funcionario Cadastrado");
			return;
		}
		listaFuncionarios.clear();
		InOut.OutMessage("Todos os Funcionarios foram Apagados!");
	}
	
	
}

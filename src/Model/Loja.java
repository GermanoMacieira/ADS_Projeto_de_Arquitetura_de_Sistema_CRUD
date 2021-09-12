package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import View.InOut;

public class Loja {
	
	// Atributos:
	private int Cod_Loja;
	private String Nome_Loja;
	private String Ender_Loja;
	private double Faturamento;
	private static int ContadorRegistros = 0;

	// Declaração dos ArrayLists (Simulação de um Banco Dados):
	private static ArrayList<Loja> listaLojas = new ArrayList<Loja>();
/*
	public Loja(){
		ContadorRegistros++;
		this.Cod_Loja = ContadorRegistros;
	}*/

	// Construtor:
	public Loja(String Nome, String Ender, double Faturamento) {
		ContadorRegistros++;
		this.Cod_Loja = ContadorRegistros;
		this.Nome_Loja = Nome;
		this.Ender_Loja = Ender;
		this.Faturamento = Faturamento;

	}

	// Gets e Sets:
	public int getCod_Loja() {
		return Cod_Loja;
	}


	public String getNome_Loja() {
		return Nome_Loja;
	}

	public void setNome_Loja(String Nome) {
		this.Nome_Loja = Nome;
	}

	public String getEnder_Loja() {
		return Ender_Loja;
	}

	public void setEnder_Loja(String Ender) {
		this.Ender_Loja = Ender;
	}

	
	public double getFaturamento() {
		return Faturamento;
	}

	public void setFaturamento(double faturamento) {
		Faturamento = faturamento;
	}

	
	
	// Métodos para Manutenção de Lojas:
	public static void cadastrarLoja() {
		String Nome = InOut.InString("Insira o Nome da Loja:");
		String Ender = InOut.InString("Digite o Endereço da Loja:");
		double Faturamento = InOut.InInt("Digite o Faturamento da Loja:");
		
		Loja loja = new Loja(Nome, Ender, Faturamento);
		listaLojas.add(loja);
	}

	public static void listarLoja() throws IOException{
		if(listaLojas.isEmpty()){
			InOut.OutMessage("Nenhuma Loja consta no Cadastrado!");
			return;
		}

		FileWriter arq2 = new FileWriter("listalojas.txt");
		PrintWriter gravaArq = new PrintWriter(arq2);
		String relatorio = "";
		gravaArq.printf("---------Lista de Lojas---------\r\n");
		for(int i = 0; i < listaLojas.size(); i++){
			Loja loja = listaLojas.get(i);
			gravaArq.printf(" - |CODIGO| %d |NOMEDALOJA| %s |ENDERECO| %s |FATURAMENTO| %f\r\n", 
					loja.getCod_Loja(), loja.getNome_Loja(), loja.getEnder_Loja(), loja.getFaturamento());

			relatorio += "\nFilial: " + loja.getCod_Loja() + 
					"\nNome: " + loja.getNome_Loja() +
					"\nEndereço: " + loja.getEnder_Loja() +
					"\nFaturamento: " + loja.getFaturamento() +
					"\n----------------------------------------------------------\r";
		}
		gravaArq.close();
		InOut.OutMessage(relatorio);
	}

	public static void alterarLoja(){
		if(listaLojas.size() == 0){
			InOut.OutMessage("Lista Vazia");
			return;
		}
		String nomeLojaPesquisar = InOut.InString("Digite o Nome da Loja que deseja pesquisar:");
		for(int i=0; i < listaLojas.size(); i++){
			Loja loja = listaLojas.get(i);

			if(nomeLojaPesquisar.equalsIgnoreCase(loja.getNome_Loja())){
				String nomeNovo = InOut.InString("Digite o novo Nome da Loja:");
				loja.setNome_Loja(nomeNovo);
				InOut.OutMessage("Nome alterado com sucesso");
				break;
			}
		}
		InOut.OutMessage("Loja não encontrada");
	}

	public static void procurarLoja(){
		String exibir = "";
		String nomeArq = "listaLojas.txt";
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
			InOut.OutMessage(exibir, "LISTA DE LOJAS");
		}else{
			InOut.OutMessage("Arquivo inexistente", "ERRO");
		}
	}

	public static void deletarLoja(){
		if(listaLojas.size() == 0){
			InOut.OutMessage("Lista Vazia");
			return;
		}
		String nomeLojaPesquisar = InOut.InString("Digite o Nome da Loja que deseja Deletar:");
		for(int i=0; i < listaLojas.size(); i++){
			Loja loja = listaLojas.get(i);

			if(nomeLojaPesquisar.equalsIgnoreCase(loja.getNome_Loja())){
				listaLojas.remove(i);
				InOut.OutMessage("Loja excluida com Sucesso!");
				break;
			}
		}
		InOut.OutMessage("Nome da Loja alterada com Sucesso!");
	}

	public static void apagarLoja() {
		if(listaLojas.isEmpty()){
			InOut.OutMessage("Nenhuma Loja Cadastrada");
			return;
		}
		listaLojas.clear();
		InOut.OutMessage("Todas as Lojas foram Apagadas!");
	}
}

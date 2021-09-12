package Controller;

import Model.Funcionario;
import Model.Loja;
import View.InOut;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		// Declaração:
		int numeroDigitado;

		//Menu Principal que faz o direcionamento para os Sistemas
		do {
			String sistema = "Qual sistema deseja acessar:\n"+
					"1 - Cadastro de Funcionarios\n"+
					"2 - Cadastro de Lojas\n"+
					"0 - Sair";

			numeroDigitado = InOut.InInt(sistema);

			//SubMenu de Tratamento para manutenção de Funcionário
			switch(numeroDigitado){			
			case 1:
				do{
					String opcoes = "Digite um dos Numeros abaixo:\n"+
							"1 - Cadastrar Novo Funcionario\n"+
							"2 - Lista de todos os Funcionario\n"+
							"3 - Alterar um  Funcionarios\n"+
							"4 - Procurar por Funcionario\n"+
							"5 - Deletar um Funcionario\n"+
							"6 - Apagar Todos os funcionarios\n"+
							"0 - Finalizar ";
					numeroDigitado = InOut.InInt(opcoes);
					switch(numeroDigitado){
					case 0:
						InOut.OutMessage("O programa será Finalizado", "Atenção");
						break;
					case 1:
						Funcionario.cadastrarFunc();
						break;
					case 2:
						Funcionario.listarFunc();
						break;
					case 3:
						Funcionario.alterarFunc();
						break;
					case 4:
						Funcionario.procurarFunc();
						break;
					case 5:
						Funcionario.deletarFunc();
						break;
					case 6:
						Funcionario.apagarFunc();
						break;
					default:
						InOut.OutMessage("Opção Invalida!", "Erro!");
						break;		
					}
				}while(numeroDigitado != 0);
				break;
				
				
				//Menu de Cadastro de Lojas:
			case 2:
				do {
					String opcoes = "Digite um dos Numeros abaixo:\n"+
							"1 - Cadastrar Nova Loja \n"+
							"2 - Lista de todos as Lojas\n"+
							"3 - Alterar o nome de uma loja\n"+
							"4 - Procurar uma loja\n"+
							"5 - Deletar uma loja\n"+
							"6 - Apagar todas as lojas\n"+
							"0 - Finalizar ";
					numeroDigitado = InOut.InInt(opcoes);
					switch(numeroDigitado){
					case 0:
						InOut.OutMessage("O programa será Finalizado", "Atenção");
						break;
					case 1:
						Loja.cadastrarLoja();
						break;
					case 2:
						Loja.listarLoja();
						break;
					case 3:
						Loja.alterarLoja();
						break;
					case 4:
						Loja.procurarLoja();
						break;
					case 5:
						Loja.deletarLoja();
						break;
					case 6:
						Loja.apagarLoja();
						break;
					default:
						InOut.OutMessage("Opção Invalida!", "Erro!");
						break;	
					}
				}while(numeroDigitado != 0);
			}
		}while(numeroDigitado != 0);


		System.out.println("Programa Finzalizado");
	}
}

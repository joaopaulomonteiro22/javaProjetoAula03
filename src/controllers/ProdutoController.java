package controllers;

import java.util.Scanner;
import java.util.UUID;

import entities.Fornecedor;
import entities.Produto;
import enums.TipoProduto;
import interfaces.Produtorepository;
import repositories.ProdutoRepositoriyTxt;
import repositories.ProdutoRepositoryXml;

public class ProdutoController {

	public void cadastrarproduto() {

		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("\n cadastro de produtos \n");
			Produto produto = new Produto();
			produto.setId(UUID.randomUUID());
			produto.setFornecedor(new Fornecedor());
			System.out.println(" NOME....:");
			produto.setNome(scanner.nextLine());
			System.out.println("PREÇO.....:");
			produto.setPreco(Double.parseDouble(scanner.nextLine()));
			System.out.println("QUANTIDADE.........:");
			produto.setQuantidade(Integer.parseInt(scanner.nextLine()));
			System.out.println("INFORME (1) PERECÍVEL OU (2) PARA NÃO PERECÍVEL");
			Integer opcao = Integer.parseInt(scanner.nextLine());
			switch (opcao) {
			case 1:
				produto.setTipo(TipoProduto.PERECIVEL);
				break;
			case 2:
				produto.setTipo(TipoProduto.NAO_PERECIVEL);
				break;
			default:
				throw new Exception("opçao invalida");

			}
			System.out.println("NOME DO FORNECEDOR..........:");
			
			produto.getFornecedor().setNome(scanner.nextLine());
			System.out.println("\n ESCOLHA (1) TXT (2)XML");
			Integer tipo = Integer.parseInt(scanner.nextLine());
			
			Produtorepository produtoRepository = null;
			
			switch (tipo) {
			case 1:
				produtoRepository = new ProdutoRepositoriyTxt();
				break;

			case 2:
				produtoRepository = new ProdutoRepositoryXml();
				break;

			default:
				throw new Exception("TIPO DE ARQUIVO INVALIDO !");
			}
			
			produtoRepository.exportarDados(produto);

		} catch (Exception e) {
			System.out.println("\nFALHA AO CADASTRAR PRODUTO");
			System.out.println(e.getMessage());
		}

		finally {
			scanner.close();

		}

	}

}

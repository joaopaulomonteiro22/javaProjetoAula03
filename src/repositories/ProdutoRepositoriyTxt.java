package repositories;

import java.io.PrintWriter;

import entities.Produto;
import interfaces.Produtorepository;

public class ProdutoRepositoriyTxt implements Produtorepository {

	@Override
	public void exportarDados(Produto produto) {
		try {
			PrintWriter printwriter = new PrintWriter("c:\\temp\\produto.txt");
			printwriter.write("\n ID DO PRODUTO.........:" + produto.getId());
			printwriter.write("\n NOME...........:" + produto.getNome());
			printwriter.write("\n PREÇO..........:" + produto.getPreco());
			printwriter.write("\n QUANTIDADE...........:" + produto.getQuantidade());
			printwriter.write("\n TIPO..........:" + produto.getTipo());
			printwriter.write("\n FORNECEDOR......:" + produto.getFornecedor().getNome());
			printwriter.write("\nCNPJ" + produto.getFornecedor().getCnpj());
			printwriter.flush();
			printwriter.close();
			System.out.println("\n ARQUIVO GRAVADO COM SUCESSO! ");
			

		} catch (Exception e) {
			System.out.println("\n FALHA AO EXPORTAR PARA TXT");
			System.out.println(e.getMessage());
		}

	}

}

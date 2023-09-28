package repositories;

import java.io.PrintWriter;

import entities.Produto;
import interfaces.Produtorepository;

public class ProdutoRepositoryXml implements Produtorepository {

	@Override
	public void exportarDados(Produto produto) {
		try {
			PrintWriter printWriter = new PrintWriter("c:\\temp\\produto.xml");
			printWriter.write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			
			printWriter.write("<produto>");
				printWriter.write("<id>" + produto.getId() + "</id>");
				printWriter.write("<nome>" + produto.getNome() + "</nome>");
				printWriter.write("<preco>" + produto.getPreco() + "</preco>");
				printWriter.write("<quantidade>" + produto.getQuantidade() + "</quantidade>");
				printWriter.write("<tipo>" + produto.getTipo() + "</tipo>");
				printWriter.write("<fornecedor>" + produto.getFornecedor().getNome() + "</fornecedor>");
				printWriter.write("<cnpj>" + produto.getFornecedor().getCnpj() + "</cnpj>");
			printWriter.write("</produto>");
			
			printWriter.flush();
			printWriter.close();
			System.out.println("produto gravado com sucesso ");
			
		} catch (Exception e) {

			System.out.println("FALHA AO EXPORTAR PRA XML !");
			System.out.println(e.getMessage());
		}
	}

}

package com.alvaro;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.alvaro.DAO.CategoriaDAO;
import com.alvaro.DAO.CidadeDAO;
import com.alvaro.DAO.ClienteDAO;
import com.alvaro.DAO.EnderecoDAO;
import com.alvaro.DAO.EstadoDAO;
import com.alvaro.DAO.ItemPedidoDAO;
import com.alvaro.DAO.PagamentoDAO;
import com.alvaro.DAO.PedidoDAO;
import com.alvaro.DAO.ProdutoDAO;
import com.alvaro.domain.Categoria;
import com.alvaro.domain.Cidades;
import com.alvaro.domain.Cliente;
import com.alvaro.domain.Endereco;
import com.alvaro.domain.Estado;
import com.alvaro.domain.ItemPedido;
import com.alvaro.domain.Pagamento;
import com.alvaro.domain.PagamentoBoleto;
import com.alvaro.domain.PagamentoCartao;
import com.alvaro.domain.Pedido;
import com.alvaro.domain.Produto;
import com.alvaro.domain.enums.EstadoPagamento;
import com.alvaro.domain.enums.TipoCliente;

@SpringBootApplication
public class Teste1Application implements CommandLineRunner {

	@Autowired
	private CategoriaDAO categoriaDAO;

	@Autowired
	private ProdutoDAO produtoDAO;

	@Autowired
	private CidadeDAO cidadeDAO;

	@Autowired
	private EstadoDAO estadoDAO;

	@Autowired
	private ClienteDAO clienteDAO;

	@Autowired
	private EnderecoDAO enderecoDAO;

	@Autowired
	private PedidoDAO pedidoDAO;

	@Autowired
	private PagamentoDAO pagamentoDAO;
	
	@Autowired
	private ItemPedidoDAO itemPedidoDAO;;

	public static void main(String[] args) {
		SpringApplication.run(Teste1Application.class, args);
	}

	// na hora de criar a aplicação ele viai instanciar as categorias
	// automaticamente
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Categoria cat1 = new Categoria(null, "Sexshop");
		Categoria cat2 = new Categoria(null, "Fantasias");

		Produto p1 = new Produto(null, "vibrador", 40.00);
		Produto p2 = new Produto(null, "Conta Premium Xvideos", 60.00);
		Produto p3 = new Produto(null, "Roupa do Batman", 40.00);

		cat1.getProduto().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProduto().addAll(Arrays.asList(p2));

		p1.getCategoria().addAll(Arrays.asList(cat1));
		p2.getCategoria().addAll(Arrays.asList(cat1, cat2));
		p3.getCategoria().addAll(Arrays.asList(cat2));

		categoriaDAO.saveAll(Arrays.asList(cat1, cat2));
		produtoDAO.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Ceará");
		Estado est2 = new Estado(null, "Acre");

		Cidades cit1 = new Cidades(null, "Choró", est1);
		Cidades cit2 = new Cidades(null, "Quixadá", est1);
		Cidades cit3 = new Cidades(null, "Texas", est2);

		estadoDAO.saveAll(Arrays.asList(est1, est2));
		cidadeDAO.saveAll(Arrays.asList(cit1, cit2, cit3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.pessoafisica);

		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, cit1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, cit3);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteDAO.saveAll(Arrays.asList(cli1));
		enderecoDAO.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		Pagamento pagto1 = new PagamentoCartao(null, EstadoPagamento.quitado, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoBoleto(null, EstadoPagamento.pendente, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoDAO.saveAll(Arrays.asList(ped1, ped2));
		pagamentoDAO.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoDAO.saveAll(Arrays.asList(ip1, ip2, ip3));
	}

}

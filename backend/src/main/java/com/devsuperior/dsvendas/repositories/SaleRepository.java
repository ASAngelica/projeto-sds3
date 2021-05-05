package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("Select new com.devsuperior.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale AS obj GROUP BY obj.seller") // linguagem JPQL
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("Select new com.devsuperior.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale AS obj GROUP BY obj.seller") // linguagem JPQL
	List<SaleSuccessDTO> successGroupedBySeller();
}

// Só com isso nós já temos um objeto, SellerRepository, responsável por acessar os dados de um Seller
// vamos ter as operações de inserir, buscar, deletar, atualizar tudo isso já vem implementado por padrão
// pelo framework. Também a consulta agrupada da soma por vendedor.
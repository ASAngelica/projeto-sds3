package com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}

// Só com isso nós já temos um objeto, SellerRepository, responsável por acessar os dados de um Seller
// vamos ter as operações de inserir, buscar, deletar, atualizar tudo isso já vem implementado por padrão
// pelo framework.
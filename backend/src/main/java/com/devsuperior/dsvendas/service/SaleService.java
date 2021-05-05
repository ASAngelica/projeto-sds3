package com.devsuperior.dsvendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired // O Autowired vai injetar de forma transparente a dependência "respository".
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true) //Esta anottation vai garantir que toda operacao com o banco seja resolvida neste momento e o readOnly=true é para não fazer lock no banco já que é só uma operacao de leitura e portanto n precisa fazer lock de escrita.
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll(); //Neste projeto que são poucos vendedores, esta solucao resolve problema da repeticao de consulta dos Sellers
		Page<Sale> result = repository.findAll(pageable); 
		return result.map(x -> new SaleDTO(x));
	}
	

}

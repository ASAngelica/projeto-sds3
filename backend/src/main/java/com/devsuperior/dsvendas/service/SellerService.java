package com.devsuperior.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired // O Autowired vai injetar de forma transparente a dependência "respository".
	private SellerRepository repository;
	
//  Vamos querer retornar uma lista de SellerDTO
//	agora vamos convertar a lista de Seller para uma lista de SellerDTO
//	vamos retornar no método esta lista result só que vamos converter esta lista para SellerDTO
//	usando o metodo stream().map, a função map vai Converter a nossa coleção original para uma nova coleção
//	que pode ser de outro tipo inclusive, no caso vai ser uma lista de SellerDTO, basicamente para cada "x"
//	da minha lista original, eu quero criar um novo objeto (new ...) passando esse "x" como argumento
//	ou seja eu vou pegar todo "x" da minha lista de Seller e converter para SellerDTO chamando o construtor
//	x -> new SellerDTO(x) agora para fechar temos que converter denovo para lista 
//	chamando .collect(Collectors.toList())
	
	public List<SellerDTO> findAll(){
		List<Seller> result = repository.findAll(); 
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
	

}

package br.edu.infnet.loja;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProdutoService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<ProdutoDTO> lista(){
		
		ResponseEntity<List<ProdutoDTO>> response =
				restTemplate.exchange("http://catalogo/produtos",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<ProdutoDTO>>() {});
		
		return response.getBody();
	}
}
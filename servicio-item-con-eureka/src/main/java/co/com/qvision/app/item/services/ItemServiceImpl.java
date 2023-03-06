package co.com.qvision.app.item.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.com.qvision.app.item.models.Item;
import co.com.qvision.app.item.models.Producto;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private RestTemplate clienteRestTemplate;
	
	@Override
	public List<Item> findAll() {
		//Este lo usamos para Balanceo con Feign
		//List<Producto> response = Arrays.asList(clienteRestTemplate.getForObject("http://localhost:8001/listar", Producto[].class ));
		//Este lo usamos para Balanceo con RestTemplate
		List<Producto> response = Arrays.asList(clienteRestTemplate.getForObject("http://servicio-productos/listar", Producto[].class ));
		
		
		/**
		 * Aquí tenemos la lista de productos
		 * debeco
		 */
		
		return response.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		
		//Este lo usamos para Balanceo con Feign
		//Producto producto =clienteRestTemplate.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables);
		
		//Este lo usamos para Balanceo con RestTemplate
		Producto producto =clienteRestTemplate.getForObject("http://servicio-productos/ver/{id}", Producto.class, pathVariables);
		return new Item(producto, cantidad);
	}

}

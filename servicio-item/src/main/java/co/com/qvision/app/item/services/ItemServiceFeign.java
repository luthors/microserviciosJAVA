package co.com.qvision.app.item.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.com.qvision.app.item.clientefeign.ProductoClienteRestFeign;
import co.com.qvision.app.item.models.Item;

@Service
//@Primary
public class ItemServiceFeign implements ItemService {
	
	@Autowired
	private ProductoClienteRestFeign clienteFeign;

	@Override
	public List<Item> findAll() {
		return clienteFeign.listar().stream().map(p -> new Item(p,0)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		// TODO Auto-generated method stub
		return new Item(clienteFeign.detalle(id), cantidad);
	}

}

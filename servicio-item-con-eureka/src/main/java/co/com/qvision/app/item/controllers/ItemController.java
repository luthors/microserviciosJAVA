package co.com.qvision.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import co.com.qvision.app.item.models.Item;
import co.com.qvision.app.item.models.Producto;
import co.com.qvision.app.item.services.ItemService;

@RestController
public class ItemController {
	@Autowired
	@Qualifier("serviceRestTemplate")
	private ItemService itemService;
	
//	@Value("${server.port}")
//    private String projectName;
	
	
	
	
	
	@GetMapping("/listar")
	public List<Item> listar(@RequestParam(name="nombre", required = false) String nombre, @RequestHeader(name="token-request", required = false) String token){
		System.out.println(nombre);
		System.out.println(token);
//		System.out.println(projectName);
		System.out.println(System.getProperty("server.port"));

		return itemService.findAll();
	}
	
	
	@HystrixCommand(fallbackMethod = "miMetodoAlternativo")
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
	
	public Item miMetodoAlternativo(Long id,Integer cantidad) {
		Item item = new Item();
		Producto p=new Producto();
		item.setCantidad(cantidad);
		p.setId(id);
		p.setNombre("Camara Manual puesta por mi");
		p.setPrecio(500.00);
		item.setProducto(p);
		return item;
	}
}

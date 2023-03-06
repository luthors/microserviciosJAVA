package co.com.qvision.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.com.qvision.app.item.models.Item;
import co.com.qvision.app.item.services.ItemService;

@RestController
public class ItemController {
	@Autowired
	@Qualifier("serviceRestTemplate")
	private ItemService itemService;
	
//	@Value("${server.port}")
//    private String projectName;
	
	
	
	
	
	@GetMapping("/listar")
	public List<Item> listar(){
//		System.out.println(projectName);
		System.out.println(System.getProperty("server.port"));

		return itemService.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
}

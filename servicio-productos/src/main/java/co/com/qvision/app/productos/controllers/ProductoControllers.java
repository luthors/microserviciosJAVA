package co.com.qvision.app.productos.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.qvision.app.productos.models.entity.Producto;
import co.com.qvision.app.productos.service.IProductoService;

@RestController
public class ProductoControllers {

	@Autowired
	private IProductoService productoService;
	
	//@Autowired
	//private Environment env;
		
	
	@Value("${server.port}")
	private Integer port;
	
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		
		//ResponseEntity<?> response= ResponseEntity.ok(productoService.findAll());
		return productoService.findAll().stream().map(p ->{
			//p.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			p.setPort(port);

			return p;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto p=productoService.findById(id);
		//p.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		p.setPort(port);
		return p;
	}
	
	@PostMapping("/save")
	public Producto save(@RequestBody Producto p) {
		
		
		LocalDateTime localDateTime = LocalDateTime.now();
		LocalDate localDate = localDateTime.toLocalDate();
		
		System.out.println(localDateTime);
		System.out.println(localDate);
		p.setCreateAt(localDate);
		return productoService.save(p);
	}
	
	
 }

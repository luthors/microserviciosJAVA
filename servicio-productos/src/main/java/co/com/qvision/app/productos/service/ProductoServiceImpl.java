package co.com.qvision.app.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.qvision.app.productos.models.entity.Producto;
import co.com.qvision.app.productos.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		List<Producto> response=productoRepository.findAll();
		return response;
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		Producto response=productoRepository.findById(id).orElse(null);
		return response;	
	}

	@Override
	public Producto save(Producto p) {
		Producto response=productoRepository.save(p);
		return response;	
	}

}

package co.com.qvision.app.productos.service;

import java.util.List;

import co.com.qvision.app.productos.models.entity.Producto;

public interface IProductoService {
	public List<Producto> findAll();
	public Producto findById(Long id);
	public Producto save(Producto p);
}

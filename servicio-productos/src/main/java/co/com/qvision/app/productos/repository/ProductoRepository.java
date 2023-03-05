package co.com.qvision.app.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.qvision.app.productos.models.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
}

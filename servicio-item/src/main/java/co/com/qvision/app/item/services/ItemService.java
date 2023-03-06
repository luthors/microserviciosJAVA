package co.com.qvision.app.item.services;

import java.util.List;

import co.com.qvision.app.item.models.Item;

public interface ItemService {
	public List<Item> findAll();
	public Item findById(Long id, Integer cantidad);
	
}

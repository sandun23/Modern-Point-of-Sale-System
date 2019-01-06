package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ItemBO;
import lk.ijse.dao.custom.ItemDAO;
import lk.ijse.dao.custom.impl.ItemDAOImpl;
import lk.ijse.entity.Item;
import lk.ijse.model.ItemDTO;

import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    private ItemDAO itemDAO;
    public ItemBOImpl() {
        itemDAO=new ItemDAOImpl();
    }

    @Override
    public boolean addItem(ItemDTO itemDTO) throws Exception {
        return itemDAO.save(new Item(itemDTO.getItemCode(),itemDTO.getItemName(),itemDTO.getQty(),itemDTO.getUnitPrice()));
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws Exception {
        return itemDAO.update(new Item(itemDTO.getItemCode(),itemDTO.getItemName(),itemDTO.getQty(),itemDTO.getUnitPrice()));
    }

    @Override
    public boolean deleteItem(ItemDTO itemDTO) throws Exception {
        return itemDAO.delete(new Item(itemDTO.getItemCode(),itemDTO.getItemName(),itemDTO.getQty(),itemDTO.getUnitPrice()));
    }

    @Override
    public ItemDTO searchItem(int id) throws Exception {
       Item item=itemDAO.search(id);
       return new ItemDTO(item.getItemCode(),item.getItemName(),item.getQty(),item.getUnitPrice());
    }

    @Override
    public ItemDTO searchItemByID(int id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<ItemDTO> getAll() throws Exception {
        List<Item> all=itemDAO.getAll();
        ArrayList<ItemDTO>itemDTOS=new ArrayList<>();
        for (Item i:all){
           itemDTOS.add(new ItemDTO(i.getItemCode(),i.getItemName(),i.getQty(),i.getUnitPrice()));
        }
        return itemDTOS;
    }
}

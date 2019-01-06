package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.model.ItemDTO;

import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    public boolean addItem(ItemDTO itemDTO)throws Exception;
    public boolean updateItem(ItemDTO itemDTO)throws Exception;
    public boolean deleteItem(ItemDTO itemDTO)throws Exception;
    public ItemDTO searchItem(int name)throws Exception;
    public ItemDTO searchItemByID(int id)throws Exception;
    public ArrayList<ItemDTO> getAll()throws Exception;
}

package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.model.CustomerDTO;

import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public boolean addCustomer(CustomerDTO customerDTO)throws Exception;
    public boolean updateCustomer(CustomerDTO customerDTO)throws Exception;
    public boolean deleteCustomer(int id)throws Exception;
    public CustomerDTO searchCustomer(String name)throws Exception;
    public CustomerDTO searchCustomerByID(int id)throws Exception;
    public ArrayList<CustomerDTO> getAll()throws Exception;
}

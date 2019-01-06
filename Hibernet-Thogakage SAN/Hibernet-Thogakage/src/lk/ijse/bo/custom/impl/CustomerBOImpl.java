package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.entity.Customer;
import lk.ijse.model.CustomerDTO;

import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    private CustomerDAO customerDAO;
    public CustomerBOImpl() {

        customerDAO=new CustomerDAOImpl();
    }

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
       return customerDAO.save(new Customer(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress()));

    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteCustomer(int id) throws Exception {
        return false;
    }

    @Override
    public CustomerDTO searchCustomer(String name) throws Exception {
        return null;
    }

    @Override
    public CustomerDTO searchCustomerByID(int id) throws Exception {
        Customer customer=customerDAO.search(id);
        return new CustomerDTO(customer.getCustID(),customer.getName(),customer.getAddress());
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws Exception {
        return null;
    }
}

package myRemote;

import java.rmi.server.UnicastRemoteObject;

public class OrderServiceImplementor extends UnicastRemoteObject implements OrderService {

    public OrderServiceImplementor() throws Exception {

    }

    @Override
    public void save(Order order) throws Exception {
        OrderRepo orderRepo = new OrderRepo();
        orderRepo.insert(order);
        orderRepo.close();
    }
}

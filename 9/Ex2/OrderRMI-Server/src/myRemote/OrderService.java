package myRemote;

import java.rmi.Remote;

public interface OrderService extends Remote {
    void save(Order order) throws Exception;
}
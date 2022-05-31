package myRemote;

import java.rmi.Remote;
import java.util.List;

public interface UserService extends Remote {
    void save(User user) throws Exception;
    void edit(User user) throws Exception;
    List<User> report() throws Exception;
}

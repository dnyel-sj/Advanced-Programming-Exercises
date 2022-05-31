package myRemote;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class UserServiceImplementor extends UnicastRemoteObject implements UserService {

    public UserServiceImplementor() throws Exception {

    }

    @Override
    public void save(User user) throws Exception {
        UserRepo userRepo = new UserRepo();
        userRepo.insert(user);
        userRepo.close();
    }

    @Override
    public void edit(User user) throws Exception {
        UserRepo userRepo = new UserRepo();
        userRepo.update(user);
        userRepo.close();
    }

    @Override
    public List<User> report() throws Exception {
        UserRepo userRepo = new UserRepo();
        List<User> userList = userRepo.select();
        userRepo.close();
        return userList;
    }
}

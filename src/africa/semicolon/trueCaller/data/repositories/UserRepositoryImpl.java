package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository{
    private Map<Integer, User> users = new HashMap<>();
    private int counter;
    @Override
    public User save(User user) {
        if(user.getId() ==0){
            counter++;
            user.setId(counter);
            users.put(counter,user);
            return user;
        }
        delete(user.getId());
        users.put(user.getId(),user);
        return user;
    }

    @Override
    public void delete(User user) {
        users.remove(user.getId());
    }

    @Override
    public void delete(int id) {
        users.remove(id);
    }

    @Override
    public User findById(int id) {
        return users.get(id);
    }

    @Override
    public List<User> findByEmail(String email) {
        return users.values().stream()
                .filter((user -> user.getEmail()
                        .equalsIgnoreCase(email))).collect(Collectors.toList());
    }

    @Override
    public List<User> findAll() {
        return users.values().stream().toList();
    }

    @Override
    public int count() {
        return users.size();
    }
}

package vnct.projects.financiall.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnct.projects.financiall.entities.User;
import vnct.projects.financiall.execeptions.UserNotFoundException;
import vnct.projects.financiall.model.UserDTO;
import vnct.projects.financiall.repositories.UserRepository;

@Slf4j
@Service
public class UserService {

    @Autowired
    private final transient UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(UserDTO dto) {
        return userRepository.save(new User(
                dto.getName()
        ));
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No such user exists."));
    }

    public User updateUser(User details) {
        User user = getUser(details.getId());
        String newName = details.getName();
        if (newName != null && newName.length() > 0) {
            user.setName(newName);
        }
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        User user = getUser(id);
        userRepository.delete(user);
    }
}

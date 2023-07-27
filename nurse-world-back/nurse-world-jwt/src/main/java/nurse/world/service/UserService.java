package nurse.world.service;

import nurse.world.model.User;
import nurse.world.repository.UserRepository;
import io.quarkus.elytron.security.common.BcryptUtil;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String generateJWT(User user){

    }

    public User registerUser(User user) {
        if(userRepository.findByUsername(user.getUsername())){
            return null;
        }
        String userPassword = BcryptUtil.bcryptHash(user.password);
        User userEncoded =
        userRepository.saveUser(user);
    }
}

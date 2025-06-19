package UISP.service;

import UISP.domain.Role;
import UISP.domain.User;
import UISP.DTO.response.UserDTO;
import UISP.repository.RoleRepository;
import UISP.repository.UserRepository;
import jakarta.transaction.Transactional;


import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository=roleRepository;
    }
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
    public User Save(User user) {
        return this.userRepository.save(user);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }
    public UserDTO UserToDTO(User user) {
        UserDTO userDTO=new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setFullname(user.getFullname());
        userDTO.setAddress(user.getAddress());
        if(user.getRole()!=null){
            userDTO.setRoleName(user.getRole().getRoleName());
        }

        return userDTO;
    }
    public void updateUserToken(String refresh_token, String email){
        User user=this.findByEmail(email);
        user.setRefreshToken(refresh_token);
        this.userRepository.save(user);
    }
    public User getUserByRefreshTokenAndEmail(String email,String refreshToken)
    {
        return this.userRepository.findByEmailAndRefreshToken(email,refreshToken);
    }

    public boolean deleteUserByEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            return userRepository.deleteByEmail(email);
        }
        return false;
    }
}

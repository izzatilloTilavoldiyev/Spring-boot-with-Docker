package uz.pdp.springbootwithdocker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.springbootwithdocker.dto.UserDTO;
import uz.pdp.springbootwithdocker.entity.UserEntity;
import uz.pdp.springbootwithdocker.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDTO create(UserDTO userDTO) {

        if (userDTO.name() != null && userDTO.age() != null) {
            UserEntity user = UserEntity.builder()
                    .id(UUID.randomUUID())
                    .name(userDTO.name())
                    .age(userDTO.age())
                    .build();
            UserEntity savedUser = userRepository.save(user);
            return UserDTO.builder()
                    .name(savedUser.getName())
                    .age(savedUser.getAge())
                    .build();
        }

        return null;
    }

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }
}

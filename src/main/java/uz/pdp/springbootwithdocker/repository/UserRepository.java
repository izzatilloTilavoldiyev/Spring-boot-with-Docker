package uz.pdp.springbootwithdocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootwithdocker.entity.UserEntity;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}

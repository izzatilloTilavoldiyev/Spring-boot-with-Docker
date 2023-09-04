package uz.pdp.springbootwithdocker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootwithdocker.dto.UserDTO;
import uz.pdp.springbootwithdocker.entity.UserEntity;
import uz.pdp.springbootwithdocker.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class HelloController {

    private final UserService userService;

    @GetMapping("/greet")
    public String hello() {
        return "So guys, you did it.";
    }

    @PostMapping()
    public ResponseEntity<UserDTO> create(
            @RequestBody UserDTO userDTO
    ) {
        UserDTO createdUser = userService.create(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAll() {
        List<UserEntity> allUsers = userService.getAll();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/{userID}")
    public ResponseEntity<UserEntity> getById(
            @PathVariable UUID userID
    ) {
        UserEntity user = userService.getById(userID);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{userID}")
    public ResponseEntity<String> delete(
            @PathVariable UUID userID
    ) {
        userService.deleteUser(userID);
        return ResponseEntity.ok("Successfully deleted");
    }
}

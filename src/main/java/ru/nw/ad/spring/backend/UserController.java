package ru.nw.ad.spring.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController()
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("")
    Iterable<UserEntity> getAll() {
        return this.userRepository.findAll();
    }
    @PostMapping("")
    UserEntity create(@RequestBody UserEntity user) {
        if (Objects.isNull(user)) {
            throw new IllegalArgumentException("Введенные данные неверны. Проверьте их и попробуйте еще раз.");
        }
        boolean existsUser = this.userRepository.existsById(user.getId());
        if (existsUser) {
            throw new IllegalArgumentException("Пользователь с такими данными уже существует. Проверьте данные и попробуйте еще раз.");
        }
        this.userRepository.saveAndFlush(user);

        return user;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity sendMessage(IllegalArgumentException exception) {
       return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}

package UISP.controller.admin;

import UISP.domain.User;
import UISP.util.ApiMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import UISP.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    private final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/user")
    @ApiMessage("Get All User ")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(this.userService.findAll());
    }

    @DeleteMapping("/user/{email}")
    @ApiMessage("Delete User")
    public ResponseEntity<String> deleteUserByEmail(@PathVariable String email) {
        System.out.println(email + " 1277");
        boolean deleted = userService.deleteUserByEmail(email);
        System.out.println(email + " deleted: " + deleted);
        if (deleted) {
            return ResponseEntity.ok("User with email " + email + " has been deleted.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
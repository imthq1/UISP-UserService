package UISP.controller.user;

import UISP.DTO.request.RegiserDTO;
import UISP.service.KeycloakService.KeycloakUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthController {
    private final KeycloakUserService keycloakUserService;

    public AuthController(KeycloakUserService keycloakUserService) {
        this.keycloakUserService = keycloakUserService;
    }
    @PostMapping("/auth/register")
    public ResponseEntity<String> register(@RequestBody RegiserDTO request) {
        keycloakUserService.registerUser(request.getUserName(), request.getPassword(), request.getEmail());
        return ResponseEntity.ok("User registered successfully");
    }
}

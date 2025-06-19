package UISP.domain;



import UISP.util.constant.Enable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;


    private String password;

    @Column(columnDefinition = "TEXT")
    private String refreshToken;

    private String fullname;
    private Instant createdAt;
    private Instant updatedAt;
    private String createdBy;
    private String updatedBy;

    @Enumerated(EnumType.STRING)
    private Enable enable;

    private String providerId;

    private String image_url;
    private String address;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;



}
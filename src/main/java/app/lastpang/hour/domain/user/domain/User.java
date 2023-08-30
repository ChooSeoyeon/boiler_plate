package app.lastpang.hour.domain.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    @Embedded
    private Profile profile;

    @Builder
    public User(Profile profile) {
        this.profile = profile;
    }

    public static User createUser(Profile profile) {
        return User.builder()
                .profile(profile)
                .build();
    }

}

package app.lastpang.hour.domain.user.presentation;

import app.lastpang.hour.domain.user.presentation.dto.request.UserFindOneRequest;
import app.lastpang.hour.domain.user.presentation.dto.response.UserFindOneResponse;
import app.lastpang.hour.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<UserFindOneResponse> findOneUser(@RequestBody UserFindOneRequest request) {

        UserFindOneResponse response = userService.findOneUser(request);
        return ResponseEntity.ok().body(response);
    }
}

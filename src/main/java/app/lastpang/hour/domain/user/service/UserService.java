package app.lastpang.hour.domain.user.service;

import app.lastpang.hour.domain.user.domain.User;
import app.lastpang.hour.domain.user.domain.repository.UserRepository;
import app.lastpang.hour.domain.user.presentation.dto.request.UserFindOneRequest;
import app.lastpang.hour.domain.user.presentation.dto.response.UserFindOneResponse;
import app.lastpang.hour.global.exception.CustomException;
import app.lastpang.hour.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserFindOneResponse findOneUser(UserFindOneRequest request) {

        User user = userRepository.findById(request.getId()) // TODO: 인증 서버 구축 후엔 로그인한 유저 사용
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_USER));

        return new UserFindOneResponse(user);
    }
}

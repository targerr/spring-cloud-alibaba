package com.wanggs.alibaba.controller.user;

        import com.wanggs.alibaba.domain.entity.user.User;
        import com.wanggs.alibaba.service.user.UserService;
        import lombok.RequiredArgsConstructor;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wgs
 * @Date: 2021/2/12
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }
}

package cn.duojunrui.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/15 0:19
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException() {

    }

    public NotFoundException(String message) {
        super(message);

    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);

    }
}

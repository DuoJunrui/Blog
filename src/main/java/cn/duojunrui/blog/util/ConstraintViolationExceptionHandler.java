package cn.duojunrui.blog.util;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @className: ConstraintViolationExceptionHandler
 * @author: Duojunrui
 * @date: 2019-04-26 23:56
 */

public class ConstraintViolationExceptionHandler {

    public static String getMessage(ConstraintViolationException e){
        List<String> msgList = new ArrayList<>();
        for (ConstraintViolation constraintViolation : e.getConstraintViolations()) {
            msgList.add(constraintViolation.getMessage());
        }
        String message = StringUtils.join(msgList.toArray(), ";");
        return message;

    }
}

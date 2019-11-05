package com.github.avancee.admin.util;

import com.github.avancee.admin.constant.ResponseCodeConst;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RestBody
 *
 * @author byference
 * @since 2019-11-05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestBody<T> {

    /**
     * response code
     */
    private int code;

    /**
     * response message
     */
    private String message;

    /**
     * response data
     */
    private T data;


    public static <T> RestBody<T> ok() {
        return ok(null);
    }

    public static <T> RestBody<T> ok(T data) {
        return new RestBody<>(ResponseCodeConst.SUCCESS, "", data);
    }

    public static <T> RestBody<T> fail() {
        return fail(null);
    }

    public static <T> RestBody<T> fail(String message) {
        return new RestBody<>(ResponseCodeConst.FAIL, message, null);
    }

}

package com.github.avancee.admin.constant;

/**
 * SecurityConst
 *
 * @author byference
 * @since 2019-11-03
 */
public interface SecurityConst {

    /**
     * default resource id
     */
    String ADMIN_RESOURCE_ID = "ADMIN_RESOURCE_ID";

    /**
     * default client id
     */
    String ADMIN_CLIENT_ID = "ADMIN_CLIENT_ID";

    /**
     * default secret
     */
    String ADMIN_SECRET = "ADMIN_SECRET";

    /**
     * default access token validity seconds
     */
    int ACCESS_TOKEN_VALIDITY_SECONDS = 3600 * 2;

    /**
     * default refresh token validity seconds
     */
    int REFRESH_TOKEN_VALIDITY_SECONDS = 3600 * 8;

    /**
     * anonymous user
     */
    String ANONYMOUS_USER = "anonymousUser";

    /**
     * account status
     */
    int ACCOUNT_LOCKED = 2;
}

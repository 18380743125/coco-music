package com.tangl.music.core.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;

/**
 * Jwt工具类
 */
public class JwtUtil {

    /**
     * 生成token
     *
     * @param iss        Jwt签发者
     * @param sub        jwt主题-jwt所面向的用户
     * @param claimKey   XX前缀，例如 LOGIN_USER_ID
     * @param claimValue uuid
     * @param secret     token私钥
     * @return token
     */
    public static String generateToken(
            String iss,
            String sub,
            String claimKey,
            String claimValue,
            String secret
    ) {
        // 秘钥实例
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
        // 生成不带过期时间的token，过期时间由redis控制
        return Jwts.builder()
                .header()  // 设置头部信息
                .add("typ", "JWT")
                .add("alg", "HS256")
                .and()  // 设置自定义负载信息payload
                .claim(claimKey, claimValue)
                // 签发时间
                .issuedAt(new Date())
                // 主题
                .subject(sub)
                // 签发者
                .issuer(iss)
                // 签名
                .signWith(key, Jwts.SIG.HS512) // // 加密算法
                .compact();
    }

    /**
     * 生成带过期时间的token
     *
     * @param id         令牌id
     * @param iss        Jwt签发者
     * @param sub        jwt主题-jwt所面向的用户
     * @param claimKey   XX前缀，例如 LOGIN_USER_ID
     * @param claimValue 用户ID值
     * @param expireTime 过期时间
     * @param secret     token私钥
     * @return token
     */
    @Deprecated
    public static String generateToken(
            String id,
            String iss,
            String sub,
            String claimKey,
            long claimValue,
            long expireTime,
            String secret
    ) {
        // 秘钥实例
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
        // 生成不带过期时间的token，过期时间由redis控制
        return Jwts.builder()
                .header()  // 设置头部信息
                .add("typ", "JWT")
                .add("alg", "HS256")
                .and()  // 设置自定义负载信息payload
                .claim(claimKey, claimValue)
                .id(id)  // 令牌id
                .expiration(Date.from(Instant.now().plusSeconds(expireTime)))  // 过期时间
                // 签发时间
                .issuedAt(new Date())
                // 主题
                .subject(sub)
                // 签发者
                .issuer(iss)
                // 签名
                .signWith(key, Jwts.SIG.HS512) // 加密算法
                .compact();
    }

    /**
     * 解析token
     *
     * @param token token
     * @return Jws<Claims>
     */
    public static Jws<Claims> parseClaim(String token, String secret) {
        // 秘钥实例
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);
    }

    public static JwsHeader parseHeader(String token, String secret) {
        return parseClaim(token, secret).getHeader();
    }

    public static Claims parsePayload(String token, String secret) {
        return parseClaim(token, secret).getPayload();
    }

    @Deprecated
    public static String parseId(String token, String secret) {
        return parsePayload(token, secret).getId();
    }

    @Deprecated
    public static Long parseUserId(String token, String secret, String claimKey) {
        return parsePayload(token, secret).get(claimKey, Long.class);
    }

    public static String parseUUId(String token, String secret, String claimKey) {
        return parsePayload(token, secret).get(claimKey, String.class);
    }

    public static String parseUsername(String token, String secret) {
        return parsePayload(token, secret).getSubject();
    }
}

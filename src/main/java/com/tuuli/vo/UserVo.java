package com.tuuli.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author tuuli
 * @time Created in 2024/4/13 20:28
 * @description
 */
@Setter
@Getter
@ToString
public class UserVo extends User {
    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    /**
     * 身份
     */
    private String role;

    public UserVo(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserVo(String username, String password, Collection<? extends GrantedAuthority> authorities, Integer id, String role) {
        super(username, password, authorities);
        this.id = id;
        this.role = role;
    }

    public UserVo(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}

package cn.duojunrui.blog.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 用户实体类
 * @Author: Duojunrui
 * @Date: 2019/8/17 22:16
 */
@Entity
@Table(name = "t_user")
public class User {

    // ID
    @Id
    @GeneratedValue
    private Long id;

    // 用户名
    private String username;

    // 账号
    private String account;

    // 密码
    private String password;

    // 邮箱
    private String email;

    // 头像
    private String avatar;

    // 用户类型
    private Integer type;

    // 创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date creatTime;

    // 更新时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    // 是否注销或删除
    private boolean deleteFlag;

    // 构建用户与博客关联关系，一对多
    @OneToMany(mappedBy = "user")
    private List<Blog> blogs = new ArrayList<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", type=" + type +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}

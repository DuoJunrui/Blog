package cn.duojunrui.blog.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 评论实体类
 * @Author: Duojunrui
 * @Date: 2019/8/17 22:08
 */
@Entity
@Table(name = "t_comment")
public class Comment {

    // ID
    @Id
    @GeneratedValue
    private Long id;

    // 昵称
    private String nickname;

    // 邮箱
    private String email;

    // 评论内容
    private String content;

    // 头像
    private String avatar;

    // 创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date creatTime;

    // 构建评论与博客关联关系，多对一
    @ManyToOne
    private Blog blog;

    // 构建父级评论与子级评论内部关联关系，一对多
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments = new ArrayList<>();

    // 构建子级评论与父级评论内部关联关系，多对一
    @ManyToOne
    private Comment parentComment;

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<Comment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Comment> replyComments) {
        this.replyComments = replyComments;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", creatTime=" + creatTime +
                '}';
    }
}

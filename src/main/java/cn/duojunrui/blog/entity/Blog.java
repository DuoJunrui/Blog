package cn.duojunrui.blog.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 博客文章实体类
 * @Author: Duojunrui
 * @Date: 2019/8/17 21:37
 */
@Entity
@Table(name = "t_blog")
public class Blog {

    // ID
    @Id
    @GeneratedValue
    private Long id;

    // 标题
    private String title;

    // 内容
    private String content;

    // 首图
    private String firstImage;

    // 标记
    private String flag;

    // 浏览次数
    private Integer views;

    // 赞赏开启
    private boolean appreciation;

    // 版权开启
    private boolean copyright;

    // 评论开启
    private boolean comment;

    // 发布
    private boolean published;

    // 推荐
    private boolean recommend;

    // 创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date creatTime;

    // 更新时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    // 是否删除
    private boolean deleteFlag;

    // 构建博客与分类关联关系，多对一
    @ManyToOne
    private Type type;

    // 构建博客与标签关联关系，多对多 (级联新增)
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    // 构建博客与用户关联关系，多对一
    @ManyToOne
    private User user;

    // 构建博客与评论关联关系，一对多
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();

    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstImage() {
        return firstImage;
    }

    public void setFirstImage(String firstImage) {
        this.firstImage = firstImage;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isAppreciation() {
        return appreciation;
    }

    public void setAppreciation(boolean appreciation) {
        this.appreciation = appreciation;
    }

    public boolean isCopyright() {
        return copyright;
    }

    public void setCopyright(boolean copyright) {
        this.copyright = copyright;
    }

    public boolean isComment() {
        return comment;
    }

    public void setComment(boolean comment) {
        this.comment = comment;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstImage='" + firstImage + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", copyright=" + copyright +
                ", comment=" + comment +
                ", published=" + published +
                ", recommend=" + recommend +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}

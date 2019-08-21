package cn.duojunrui.blog.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 博客标签实体类
 * @Author: Duojunrui
 * @Date: 2019/8/17 22:05
 */
@Entity
@Table(name = "t_tag")
public class Tag {

    // ID
    @Id
    @GeneratedValue
    private Long id;

    // 标签名称
    @NotBlank(message = "标签名称不能为空")
    private String name;

    // 构建标签与博客关联关系，多对多
    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();

    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

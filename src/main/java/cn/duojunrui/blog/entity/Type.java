package cn.duojunrui.blog.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 博客分类实体类
 * @Author: Duojunrui
 * @Date: 2019/8/17 22:01
 */
@Entity
@Table(name = "t_type")
public class Type {

    // ID
    @Id
    @GeneratedValue
    private Long id;

    // 类型名称
    private String name;

    // 构建类型与博客关联关系，一对多
    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();

    public Type() {
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
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

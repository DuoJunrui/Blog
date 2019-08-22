package cn.duojunrui.blog.service;

import cn.duojunrui.blog.entity.Blog;
import cn.duojunrui.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/22 21:36
 */
public interface BlogService {

    /**
     * 根据ID获取博客信息
     *
     * @param id
     * @return
     */
    Blog getBlog(Long id);

    /**
     * 查询博客列表并分页展示(动态组合查询)
     *
     * @param blog
     * @param pageable
     * @return
     */
    Page<Blog> listBlog(BlogQuery blog, Pageable pageable);

    /**
     * 保存博客信息
     *
     * @param blog
     * @return
     */
    Blog saveBlog(Blog blog);

    /**
     * 根据ID更新/修改博客信息
     *
     * @param id
     * @param blog
     * @return
     */
    Blog updateBlog(Long id, Blog blog);

    /**
     * 删除博客信息
     *
     * @param id
     */
    void removeBlog(Long id);
}

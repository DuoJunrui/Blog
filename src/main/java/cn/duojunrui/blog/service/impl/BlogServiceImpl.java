package cn.duojunrui.blog.service.impl;

import cn.duojunrui.blog.dao.BlogRepository;
import cn.duojunrui.blog.entity.Blog;
import cn.duojunrui.blog.entity.Type;
import cn.duojunrui.blog.exception.NotFoundException;
import cn.duojunrui.blog.service.BlogService;
import cn.duojunrui.blog.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/22 21:40
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog getBlog(Long id) {
        return blogRepository.getOne(id);
    }


    @Override
    public Page<Blog> listBlog(BlogQuery blog, Pageable pageable) {
        // JPA提供的Specification方法可以进行动态拼接查询
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                // 判断是否传入博客标题
                if (!"".equals(blog.getTitle()) && blog.getTitle() != null) {
                    predicateList.add(criteriaBuilder.like(root.<String>get("title"), "%" + blog.getTitle() + "%"));
                }
                // 判断是否传入博客分类
                if (blog.getTypeId() != null) {
                    predicateList.add(criteriaBuilder.equal(root.<Type>get("type").get("id"), blog.getTypeId()));
                }
                // 判断是否勾选推荐
                if (blog.isRecommend()) {
                    predicateList.add(criteriaBuilder.equal(root.<Boolean>get("recommend"), blog.isRecommend()));
                }
                criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
                return null;
            }
        }, pageable);
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) {

        Blog blogMessage = blogRepository.getOne(id);
        if (blogMessage == null) {
            throw new NotFoundException("该博客不存在！");
        }
        BeanUtils.copyProperties(blogMessage, blog);
        return blogRepository.save(blogMessage);
    }

    @Override
    public void removeBlog(Long id) {
        blogRepository.deleteById(id);
    }
}

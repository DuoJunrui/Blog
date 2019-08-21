package cn.duojunrui.blog.dao;

import cn.duojunrui.blog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/18 23:42
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
    /**
     * 根据名称查询标签
     * @param name
     * @return
     */
    Tag findByName(String name);

}

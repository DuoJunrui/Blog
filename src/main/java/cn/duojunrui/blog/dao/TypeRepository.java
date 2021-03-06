package cn.duojunrui.blog.dao;

import cn.duojunrui.blog.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/18 23:42
 */
public interface TypeRepository extends JpaRepository<Type, Long> {
    /**
     * 根据名称查询分类
     * @param name
     * @return
     */
    Type findByName(String name);

}

package cn.duojunrui.blog.service;

import cn.duojunrui.blog.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/18 23:34
 */
public interface TypeService {

    /**
     * 新增分类
     *
     * @param type
     * @return
     */
    Type saveType(Type type);

    /**
     * 根据ID查询分类
     *
     * @param id
     * @return
     */
    Type getType(Long id);

    /**
     * 根据名称查询分类
     * @param name
     * @return
     */
    Type getTypeByName(String name);

    /**
     * 分页查询分类
     *
     * @param pageable
     * @return
     */
    Page<Type> listType(Pageable pageable);

    /**
     * 根据ID查询分类，然后修改分类
     *
     * @param id   分类主键
     * @param type 分类对象
     * @return
     */
    Type updateType(Long id, Type type);

    /**
     * 根据主键删除分类
     *
     * @param id
     */
    void deleteType(Long id);
}

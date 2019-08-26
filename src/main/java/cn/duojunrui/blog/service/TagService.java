package cn.duojunrui.blog.service;

import cn.duojunrui.blog.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/21 23:34
 */
public interface TagService {

    /**
     * 新增标签
     *
     * @param tag
     * @return
     */
    Tag saveTag(Tag tag);

    /**
     * 根据ID查询标签
     *
     * @param id
     * @return
     */
    Tag getTag(Long id);

    /**
     * 根据名称查询标签
     * @param name
     * @return
     */
    Tag getTagByName(String name);

    /**
     * 分页查询标签
     *
     * @param pageable
     * @return
     */
    Page<Tag> listTag(Pageable pageable);

    /**
     * 根据ID查询标签，然后修改标签
     *
     * @param id   标签主键
     * @param tag 标签对象
     * @return
     */
    Tag updateTag(Long id, Tag tag);

    /**
     * 根据主键删除标签
     *
     * @param id
     */
    void deleteTag(Long id);

    /**
     *
     * @return
     */
    List<Tag> listTag();
}

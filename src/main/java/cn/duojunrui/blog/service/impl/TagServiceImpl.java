package cn.duojunrui.blog.service.impl;

import cn.duojunrui.blog.dao.TagRepository;
import cn.duojunrui.blog.entity.Tag;
import cn.duojunrui.blog.exception.NotFoundException;
import cn.duojunrui.blog.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/18 23:40
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagRepository.getOne(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag tagMessage = tagRepository.getOne(id);
        if (tagMessage == null) {
            throw new NotFoundException("该标签不存在！");
        }
        BeanUtils.copyProperties(tag, tagMessage);

        return tagRepository.save(tagMessage);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {

        tagRepository.deleteById(id);

    }

    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }
}

package cn.duojunrui.blog.service.impl;

import cn.duojunrui.blog.dao.TypeRepository;
import cn.duojunrui.blog.entity.Type;
import cn.duojunrui.blog.exception.NotFoundException;
import cn.duojunrui.blog.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/18 23:40
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.getOne(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type typeMessage = typeRepository.getOne(id);
        if (typeMessage == null) {
            throw new NotFoundException("该类型不存在！");
        }
        BeanUtils.copyProperties(type, typeMessage);

        return typeRepository.save(typeMessage);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {

        typeRepository.deleteById(id);

    }
}

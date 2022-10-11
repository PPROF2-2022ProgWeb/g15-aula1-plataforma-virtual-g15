package com.saberconectar.sc.service.impl;

import com.saberconectar.sc.entity.ProvinceEntity;
import com.saberconectar.sc.exception.ParamNotFound;
import com.saberconectar.sc.dto.ProvinceDTO;
import com.saberconectar.sc.mapper.ProvinceMapper;
import com.saberconectar.sc.repository.ProvinceRepository;
import com.saberconectar.sc.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private ProvinceMapper provinceMapper;
    @Override
    public List<ProvinceDTO> getAllProvinces() {
        List<ProvinceEntity> entities = provinceRepository.findAll();
        List<ProvinceDTO> dtos = provinceMapper.provinceEntityList2DTOList(entities);
        return dtos;
    }
    @Override
    public ProvinceDTO save(ProvinceDTO dto) {
        ProvinceEntity entity = provinceMapper.provinceDTO2Entity(dto);
        ProvinceEntity entitySaved = provinceRepository.save(entity);
        ProvinceDTO result = provinceMapper.provinceEntity2DTO(entitySaved);
        return result;
    }
    public ProvinceDTO update(Long id, ProvinceDTO province){
        isCorrect(id);
        ProvinceEntity entityId = provinceRepository.getReferenceById(id);
        ProvinceEntity entity = provinceMapper.update(entityId,province);
        ProvinceEntity entityUpdated = provinceRepository.save(entity);
        ProvinceDTO result = provinceMapper.provinceEntity2DTO(entityUpdated);
        return result;
    }
    @Override
    public void delete(Long id) {
        isCorrect(id);
        this.provinceRepository.deleteById(id);
    }
    public void isCorrect(Long id){
        if(!provinceRepository.existsById(id)){
            throw new ParamNotFound("Invalid id");
        }
    }
}

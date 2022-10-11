package com.saberconectar.sc.service.impl;

import com.saberconectar.sc.dto.InvoiceTypeDTO;
import com.saberconectar.sc.entity.InvoiceTypeEntity;
import com.saberconectar.sc.exception.ParamNotFound;
import com.saberconectar.sc.mapper.InvoiceTypeMapper;
import com.saberconectar.sc.repository.InvoiceTypeRepository;
import com.saberconectar.sc.service.InvoiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceTypeServiceImpl implements InvoiceTypeService {
    @Autowired
    private InvoiceTypeRepository invoiceTypeRepository;
    @Autowired
    private InvoiceTypeMapper invoiceTypeMapper;

    public List<InvoiceTypeDTO> getAllInvoiceTypes() {
        List<InvoiceTypeEntity> entities = invoiceTypeRepository.findAll();
        List<InvoiceTypeDTO> dtos = invoiceTypeMapper.invoiceTypeEntityList2DTOList(entities);
        return dtos;
    }
    public InvoiceTypeDTO save(InvoiceTypeDTO type) {
        InvoiceTypeEntity entity = invoiceTypeMapper.invoiceTypeDTO2Entity(type);
        InvoiceTypeEntity entitySaved = invoiceTypeRepository.save(entity);
        InvoiceTypeDTO result = invoiceTypeMapper.invoiceTypeEntity2DTO(entitySaved);
        return result;
    }
    public InvoiceTypeDTO update(Long id, InvoiceTypeDTO type) {
        isCorrect(id);
        InvoiceTypeEntity entityId = invoiceTypeRepository.getReferenceById(id);
        InvoiceTypeEntity entity = invoiceTypeMapper.update(entityId,type);
        InvoiceTypeEntity entityUpdated = invoiceTypeRepository.save(entity);
        InvoiceTypeDTO result = invoiceTypeMapper.invoiceTypeEntity2DTO(entityUpdated);
        return result;
    }
    public void delete(Long id) {
        isCorrect(id);
        this.invoiceTypeRepository.deleteById(id);
    }
    public void isCorrect(Long id) {
        if(!invoiceTypeRepository.existsById(id)){
            throw new ParamNotFound("Invalid id");
        }
    }
}

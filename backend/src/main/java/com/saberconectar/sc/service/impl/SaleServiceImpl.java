package com.saberconectar.sc.service.impl;

import com.saberconectar.sc.dto.SaleDTO;
import com.saberconectar.sc.service.SaleService;
import org.springframework.stereotype.Service;
@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private SaleMapper saleMapper;
    public SaleDTO getSaleById(Long id) {
        isCorrect(id);
        SaleEntity entity = saleRepository.getReferenceById(id);
        SaleDTO dto = saleMapper.saleEntity2DTO(entity);
        return dto;
    }
    public SaleDTO save(SaleDTO sale){
        SaleEntity entity = saleMapper.saleDTO2Entity(sale);
        SaleEntity entitySaved = saleRepository.save(entity);
        SaleDTO dto = saleMapper.saleEntity2DTO(entitySaved);
        return dto;
    }
    public SaleDTO update(Long id, SaleDTO sale) {
        isCorrect(id);
        SaleEntity entityId = saleRepository.getReferenceById(id);
        SaleEntity entity = saleMapper.update(entityId,sale);
        SaleEntity entityUpdated = saleRepository.save(entity);
        SaleDTO result = saleMapper.saleEntity2DTO(entityUpdated);
        return result;
    }
    public void delete(Long id) {
        isCorrect(id);
        this.saleRepository.deleteById(id);
    }
    public void isCorrect(Long id) {
        if(!saleRepository.existsById(id)){
            throw new ParamNotFound("Invalid id.");
        }
    }
}

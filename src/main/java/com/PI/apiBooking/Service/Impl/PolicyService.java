package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.PolicyDto;
import com.PI.apiBooking.Model.Entity.Policy;
import com.PI.apiBooking.Repository.IPolicyRepository;
import com.PI.apiBooking.Service.Interfaces.IPolicyService;
import com.PI.apiBooking.Util.Mapper.PolicyMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PolicyService implements IPolicyService {
    protected final static Logger logger = Logger.getLogger(CityService.class);

    @Autowired
    private IPolicyRepository policyRepository;
    @Autowired
    private PolicyMapper policyMapper;

    @Override
    public Set<PolicyDto> findAll() {
        List<Policy> policies = policyRepository.findAll();
        Set<PolicyDto> policiesDto = policyMapper.toPolicyDtoSet(policies);
        logger.info("La búsqueda fue exitosa: "+ policiesDto);
        return policiesDto;
    }

    @Override
    public PolicyDto findById(Long id) throws ResourceNotFoundException {
        Policy policy = checkId(id);
        PolicyDto policyDto = policyMapper.toPolicyDto(policy);
        logger.info("La búsqueda fue exitosa: id("+id+")");
        return policyDto;
    }

    @Override
    public PolicyDto save(PolicyDto policyDto) {
        Policy policy = policyMapper.toPolicy(policyDto);
        policyRepository.save(policy);
        if (policyDto.getId() == null){
            policyDto.setId(policy.getId());
            logger.info("Política registrada correctamente: "+ policyDto);
        }else{
            logger.info("Política actualizada correctamente: "+ policyDto);
        }
        return policyDto;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        policyRepository.deleteById(id);
        logger.info("Se elimino la Política correctamente: id("+id+")");
    }

    @Override
    public Policy checkId(Long id) throws ResourceNotFoundException{
        Optional<Policy> policy = policyRepository.findById(id);
        if (policy.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return policy.get();
    }
}
package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.PolicyDto;
import com.PI.apiBooking.Model.Entity.Policy;
import com.PI.apiBooking.Repository.IPolicyRepository;
import com.PI.apiBooking.Service.Interfaces.IPolicyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PolicyService implements IPolicyService {
    protected final static Logger logger = Logger.getLogger(CityService.class);

    @Autowired
    private IPolicyRepository policyRepository;
    @Autowired
    private ObjectMapper mapper;

    @Override
    public Set<PolicyDto> findAll() {
        Set<PolicyDto> policiesDto = new HashSet<>();
        List<Policy> policies = policyRepository.findAll();
        for (Policy policy :policies) {
            policiesDto.add(mapper.convertValue(policy, PolicyDto.class));
        }
        logger.info("La búsqueda fue exitosa: "+ policiesDto);
        return policiesDto;
    }

    @Override
    public PolicyDto findById(Long id) throws ResourceNotFoundException {
        Policy policy = checkId(id);
        PolicyDto policyDto = mapper.convertValue(policy, PolicyDto.class);
        logger.info("La búsqueda fue exitosa: id("+id+")");
        return policyDto;
    }

    @Override
    public PolicyDto save(PolicyDto policyDto) {
        Policy policy = mapper.convertValue(policyDto, Policy.class);
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
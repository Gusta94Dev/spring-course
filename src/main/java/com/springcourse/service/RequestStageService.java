package com.springcourse.service;

import com.springcourse.domain.Request;
import com.springcourse.domain.RequestStage;
import com.springcourse.domain.enums.RequestState;
import com.springcourse.repository.RequestRepository;
import com.springcourse.repository.RequestStageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestStageService {
    @Autowired
    private RequestStageRepository requestStageRepository;

    @Autowired
    private RequestRepository requestRepository;

    public RequestStage save (RequestStage requestStage) {
        requestStage.setRealizationDate(new Date());
        RequestStage createRequestStage = requestStageRepository.save(requestStage);

        Long requestId = createRequestStage.getRequest().getId();
        RequestState state = createRequestStage.getState();
        requestRepository.updatedStatus(requestId, state);
        return createRequestStage;
    }

    public RequestStage getById(Long id) {
        Optional<RequestStage> requestStage = requestStageRepository.findById(id);
        return requestStage.get();
    }

    public List<RequestStage> getAllByRequestId(Long requestId){
        List<RequestStage> requestStages = requestStageRepository.findAllByRequestId(requestId);
        return requestStages;
    }
}

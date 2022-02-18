package com.springcourse.service;

import com.springcourse.domain.Request;
import com.springcourse.domain.enums.RequestState;
import com.springcourse.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;

    public Request save(Request request) {
        request.setState(RequestState.OPEN);
        request.setCreationDate(new Date());

        Request createRequest = requestRepository.save(request);
        return createRequest;
    }

    public Request update(Request request) {
        Request updateRequest = requestRepository.save(request);
        return updateRequest;
    }

    public Request getById(Long id) {
        Optional<Request> request = requestRepository.findById(id);
        return request.get();
    }

    public List<Request> listAll(){
        List<Request> requests = requestRepository.findAll();
        return requests;
    }

    public List<Request> listAllByOwnerId(Long id){
        List<Request> requests = requestRepository.findAllByOwnerId(id);
        return requests;
    }
}

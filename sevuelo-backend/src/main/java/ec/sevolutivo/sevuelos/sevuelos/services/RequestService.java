package ec.sevolutivo.sevuelos.sevuelos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.sevolutivo.sevuelos.sevuelos.domain.Request;
import ec.sevolutivo.sevuelos.sevuelos.repository.RequestRepository;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    public Request save(Request request) {
        return requestRepository.save(request);
    }

    public Request get(Long id) {
        return requestRepository.getOne(id);
    }

    public void delete(Long id) {
        requestRepository.deleteAll();
    }

}

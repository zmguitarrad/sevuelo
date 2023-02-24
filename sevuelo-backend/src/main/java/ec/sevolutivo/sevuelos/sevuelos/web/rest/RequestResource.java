package ec.sevolutivo.sevuelos.sevuelos.web.rest;

import ec.sevolutivo.sevuelos.sevuelos.domain.Request;
import ec.sevolutivo.sevuelos.sevuelos.domain.enumeration.RequestStatus;
import ec.sevolutivo.sevuelos.sevuelos.repository.RequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:3000" })
public class RequestResource {

    private final Logger log = LoggerFactory.getLogger(RequestResource.class);
    // @Autowired inyeccion de dependencia
    private final RequestRepository requestRepository;

    public RequestResource(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @PostMapping("/requests")
    public Request createRequest(@RequestBody Request request) {
        log.debug("REST request to save Request : {}", request);
        if (request.getId() != null) {
            throw new RuntimeException("A new request cannot already have an ID");
        }
        request.setStatus(RequestStatus.NEW);
        return requestRepository.save(request);
    }

    @GetMapping("/requests")
    public List<Request> getAllRequests() {
        log.debug("REST request to get all Requests");
        return requestRepository.findAll();
    }

    @GetMapping("/requests/{id}")
    public Request getRequest(@PathVariable Long id) {
        log.debug("REST request to get Request : {}", id);
        Optional<Request> request = requestRepository.findById(id);
        return request.get();
    }

    @PutMapping("/reserve")
    public void reserve(@RequestBody Request request) {
        log.debug("REST request to reserve a flight");
        request.setStatus(RequestStatus.RESERVED);
        requestRepository.save(request);
    }

    @PutMapping("/news")
    public void news(@RequestBody Request request) {
        log.debug("REST request to reserve a flight");
        request.setStatus(RequestStatus.NEW);
        requestRepository.save(request);
    }

}

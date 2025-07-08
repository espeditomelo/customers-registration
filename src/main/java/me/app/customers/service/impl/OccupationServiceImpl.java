package me.app.customers.service.impl;

import me.app.customers.domain.model.Occupation;
import me.app.customers.domain.repository.OccupationRepository;
import me.app.customers.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OccupationServiceImpl implements OccupationService {

    @Autowired
    private OccupationRepository occupationRepository;

    @Override
    public Iterable<Occupation> getAll() {
        return occupationRepository.findAll();
    }

    @Override
    public Occupation findById(Long id) {
        Optional<Occupation> occupation = occupationRepository.findById(id);
        return occupation.get();
    }

    @Override
    public Occupation create(Occupation occupation) {
        return occupationRepository.save(occupation);
    }

    @Override
    public Occupation update(Long id, Occupation occupationToUpdate) {
        Optional<Occupation> occupationFinded = occupationRepository.findById(id);
        if(!occupationFinded.isEmpty()){
            occupationRepository.save(occupationToUpdate);
            return occupationToUpdate;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Occupation occupationFinded = findById(id);
        if(occupationFinded != null) {
            occupationRepository.delete(occupationFinded);
        }
    }
}

package ars.cs.miu.edu.services;


import ars.cs.miu.edu.models.Person;
import ars.cs.miu.edu.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl<T extends Person>  implements AirlinesService<T> {
    @Autowired
    private PersonRepository personsRepository;

    @Override
    public List<T> findAll() {
        return personsRepository.findAll();
    }

    @Override
    public T findOne(Long i) {
        return (T)personsRepository.findById(i).orElse(null);
    }

    @Override
    public T update(Person t) {
        return  (T)personsRepository.save(t);
    }

    @Override
    public void delete(Long i) {

        personsRepository.deleteById(i);
    }

    @Override
    public T add(Person t) {
        return  (T)personsRepository.save(t);
    }
}

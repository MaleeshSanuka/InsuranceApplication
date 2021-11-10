package com.example.insuranceapplication.insurance;

import com.example.insuranceapplication.user.User;
import com.example.insuranceapplication.user.UserNotFoundException;
import com.example.insuranceapplication.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceService {
    @Autowired
    private InsuranceRepository repo;

    public List<Insurance> listAll(){
        return (List<Insurance>) repo.findAll();
    }

    public void save(Insurance insurance) {
        repo.save(insurance);
    }

    public Insurance get(Integer id) throws InsuranceNotFoundException {
        Optional<Insurance> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new InsuranceNotFoundException("Could not find any insurances with ID " + id);
    }
    public void delete(Integer id) throws InsuranceNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0){
            throw new InsuranceNotFoundException("Could not find any insurances with ID " + id);
        }
        repo.deleteById(id);
    }

}

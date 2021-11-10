package com.example.insuranceapplication.insurance;

import org.springframework.data.repository.CrudRepository;

public interface InsuranceRepository extends CrudRepository<Insurance, Integer> {
    public Long countById(Integer id);
}

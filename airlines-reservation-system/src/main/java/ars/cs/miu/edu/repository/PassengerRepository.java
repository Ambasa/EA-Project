package ars.cs.miu.edu.repository;

import ars.cs.miu.edu.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}

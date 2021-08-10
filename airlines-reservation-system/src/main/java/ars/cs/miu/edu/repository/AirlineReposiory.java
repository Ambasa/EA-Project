package ars.cs.miu.edu.repository;

import ars.cs.miu.edu.models.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AirlineReposiory extends JpaRepository<Airline, Long> {
    @Query(value = "SELECT * FROM bookings bs WHERE " +
            "EXISTS (SELECT 1 FROM customer c WHERE bs.customer_id = c.id AND c.phone = :phone) " +
            "AND EXISTS (SELECT 1 FROM books b WHERE b.id = bs.book_id AND b.author IN :authors)",
            nativeQuery = true)
    List<Airline> queryByAirportCode(@Param("airportCode") String airportCode);
}

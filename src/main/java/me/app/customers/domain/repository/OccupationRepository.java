package me.app.customers.domain.repository;

import me.app.customers.domain.model.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccupationRepository extends JpaRepository<Occupation, Long> {
}

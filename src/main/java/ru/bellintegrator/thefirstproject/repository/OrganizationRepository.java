package ru.bellintegrator.thefirstproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.thefirstproject.entity.OrganizationEntity;

@Repository
public interface OrganizationRepository extends CrudRepository<OrganizationEntity, Long> {
}

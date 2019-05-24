package ru.bellintegrator.thefirstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.bellintegrator.thefirstproject.domain.entity.UserDocEntity;

import java.util.List;

public interface UserDocXRepository extends JpaRepository<UserDocEntity, Long> {

/*    @Query("SELECT ude FROM UserDocEntity ude LEFT OUTER JOIN ude.docType dt WHERE ude.userDocIdEntity.user.id = ?1")
    List<UserDocEntity> findByLongId(Long id);*/

}

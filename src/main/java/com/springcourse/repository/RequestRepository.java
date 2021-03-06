package com.springcourse.repository;

import com.springcourse.domain.Request;
import com.springcourse.domain.enums.RequestState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    public List<Request> findAllByOwnerId(Long id);

    @Query("UPDATE request SET state = ?2 WHERE id = ?1")
    public Request updatedStatus(Long id, RequestState state);

}

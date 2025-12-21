package com.backend.yowyob.Repositories;


import com.backend.yowyob.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    List<Client> findBySegment(Client.SegmentClient segment);
    List<Client> findByActiveTrue();
    List<Client> findByActiveFalse();
}


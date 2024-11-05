package com.sw.modulith.biker;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
interface BikerRepository extends CrudRepository<Biker, Long> {

    Optional<Biker> getBikerByPiun(Integer piun);
    List<Biker> getBikerByBirthdate(Timestamp date);
}

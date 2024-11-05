package com.sw.modulith.eventpublication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomEventPublicationRepository extends CrudRepository<CustomEventPublication, Long> {
    List<CustomEventPublication> getEventPublicationsByPublicationDateNotNullAndCompletionDateIsNull();
    List<CustomEventPublication> getEventPublicationsByPublicationDateNotNullAndCompletionDateNotNull();
}
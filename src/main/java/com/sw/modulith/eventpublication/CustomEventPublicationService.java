package com.sw.modulith.eventpublication;

import java.util.List;

public interface CustomEventPublicationService {

    List<CustomEventPublication> getUncompletedEventPublications();
    List<CustomEventPublication> getCompletedEventPublications();
}
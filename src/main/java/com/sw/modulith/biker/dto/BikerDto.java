package com.sw.modulith.biker.dto;

import java.sql.Timestamp;

public record BikerDto(Long id, Long piun, String name, Timestamp birthdate) {
}

package com.sw.modulith.challenge;

public interface Mapper<I, O>{

    O map(I entity);
}

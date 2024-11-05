package com.sw.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest
class ModulithApplicationTests {

    @Test
    void contextLoads() {
        ApplicationModules.of(ModulithApplication.class).verify();
    }

}

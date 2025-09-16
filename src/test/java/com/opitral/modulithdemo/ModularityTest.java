package com.opitral.modulithdemo;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ModularityTest {
    @Test
    void createModuleDocumentation() {
        ApplicationModules modules = ApplicationModules.of(ModulithDemoApplication.class);
        new Documenter(modules)
                .writeDocumentation()
                .writeIndividualModulesAsPlantUml();
    }
}
package com.opitral.modulithdemo;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ModularityTest {
    @Test
    void verifyAndDocument() {
        var modules = ApplicationModules.of(ModulithDemoApplication.class);
        modules.verify();
        new Documenter(modules).writeDocumentation();
    }
}
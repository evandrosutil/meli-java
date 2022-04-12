package com.meli.qabugs.api;

import com.meli.qabugs.model.TestCase;
import com.meli.qabugs.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestCaseApi {

    @Autowired
    private TestService service;

    @PostMapping("/testcases/new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCase testCase) {
        service.createTestCase(testCase);

        return new ResponseEntity<>(
                "TestCase id " + testCase.getId_case() + " created.",
                HttpStatus.CREATED);
    }

    @GetMapping("/testcases")
    public ResponseEntity<List<TestCase>> getAllTestCases(
            @RequestParam(required = false) String last_update) {

        if (last_update == null) {
            List<TestCase> testCases = service.listTestCases();

            return ResponseEntity.ok(testCases);
        }

        List<TestCase> testCases = service.findTestCaseByUpdateDate(last_update);

        if (testCases.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(testCases);
    }

    @GetMapping("/testcases/{id}")
    public ResponseEntity<TestCase> getTestCaseById(@PathVariable Long id) {
        TestCase testCase = service.findTestCaseById(id);
        if (testCase == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(testCase);
    }

    @PutMapping("/testcases/{id}")
    public ResponseEntity<?> updateTestCase(
            @PathVariable Long id,
            @RequestBody TestCase updatedTestCase) {

        service.updateTestCase(id, updatedTestCase);
        TestCase testCase = service.findTestCaseById(id);
        return ResponseEntity.ok(testCase);
    }

    @DeleteMapping("/testcases/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        service.deleteTestCase(id);

        return ResponseEntity.ok("TestCase deletado com sucesso.");
    }
}



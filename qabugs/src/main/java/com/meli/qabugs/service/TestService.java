package com.meli.qabugs.service;

import com.meli.qabugs.model.TestCase;
import com.meli.qabugs.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private TestRepository repo;

    public void createTestCase(TestCase testCase) {
        System.out.println(testCase);
        repo.save(testCase);
    }

    public List<TestCase> listTestCases() {
        return repo.findAll();
    }

    public TestCase findTestCaseById(Long id) {
        Optional<TestCase> optionalTestCase = repo.findById(id);
        if (optionalTestCase.isEmpty()) {
            return null;
        }
        return optionalTestCase.get();
    }

    public void updateTestCase(Long id, TestCase updatedTestCase) {
        TestCase testCase = findTestCaseById(id);
        if (testCase != null) {
            testCase.setDescription(updatedTestCase.getDescription());
            testCase.setTested(updatedTestCase.isTested());
            testCase.setPassed(updatedTestCase.isPassed());
            testCase.setNumber_of_tries(updatedTestCase.getNumber_of_tries());
            testCase.setLast_update(LocalDate.now());

            repo.save(testCase);
        }
    }

    public void deleteTestCase(Long id) {
        repo.deleteById(id);
    }

    public List<TestCase> findTestCaseByUpdateDate(String dateStr) {
        LocalDate update = LocalDate.parse(dateStr);
        return repo.findByLastUpdateAfter(update);
    }
}

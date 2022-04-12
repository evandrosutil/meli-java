package com.meli.tutorials.api;

import com.meli.tutorials.model.Tutorial;
import com.meli.tutorials.service.TutorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tutorials")
public class TutorialsController {

    private final TutorialService tutorialService;

    @PostMapping("")
    public ResponseEntity<Tutorial> saveTutorial(
            @RequestBody Tutorial tutorial,
            UriComponentsBuilder uriBuilder) {

        Long tutorialId = tutorialService.createTutorial(tutorial);

        URI uri = uriBuilder
                .path("/api/tutorials/{id}")
                .buildAndExpand(tutorialId)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("")
    public ResponseEntity<List<Tutorial>> getAllTutorials(
            @RequestParam(required = false) String title
    ) {
        System.out.println(title);
        if (title == null) {
            List<Tutorial> tutorials = tutorialService.getAllTutorials();
            return ResponseEntity.ok(tutorials);
        }
        List<Tutorial> tutorials = tutorialService.findTutorialsByTitle(title);
        return ResponseEntity.ok(tutorials);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable Long id) {
        Tutorial tutorial = tutorialService.getTutorialById(id);
        if (tutorial == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tutorial);
    }

    @DeleteMapping("")
    public ResponseEntity<Tutorial> deleteAllTutorials() {
        tutorialService.deleteAllTutorials();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tutorial> deleteTutorialById(@PathVariable Long id) {
        tutorialService.deleteTutorial(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutorial> updateTutorial(
            @PathVariable Long id,
            @RequestBody Tutorial updatedTutorial) {

        Tutorial tutorial = tutorialService.getTutorialById(id);
        if (tutorial == null) {
            return ResponseEntity.notFound().build();
        }

        tutorialService.updateById(id, updatedTutorial);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/published")
    public ResponseEntity<List<Tutorial>> getPublishedTutorials() {
        List<Tutorial> tutorials = tutorialService.findPublishedTutorials();
        return ResponseEntity.ok(tutorials);
    }
}

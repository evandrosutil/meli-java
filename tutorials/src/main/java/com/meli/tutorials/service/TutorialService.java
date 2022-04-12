package com.meli.tutorials.service;

import com.meli.tutorials.model.Tutorial;
import com.meli.tutorials.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorialService {

    private final TutorialRepository repo;

    public Long createTutorial(Tutorial tutorial) {
        Tutorial created = repo.save(tutorial);

        return created.getId();
    }

    public List<Tutorial> getAllTutorials() {
        return repo.findAll();
    }

    public Tutorial getTutorialById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Tutorial updateById(Long id, Tutorial updatedTutorial) {
        Tutorial oldTutorial = getTutorialById(id);

        oldTutorial.setDescription(updatedTutorial.getDescription());
        oldTutorial.setStatus(updatedTutorial.getStatus());
        oldTutorial.setTitle(updatedTutorial.getTitle());

        repo.save(oldTutorial);
        return oldTutorial;
    }

    public void deleteTutorial(Long id) {
        Tutorial tutorialToDelete = getTutorialById(id);
        if (tutorialToDelete != null) {
            repo.delete(tutorialToDelete);
        }
    }

    public void deleteAllTutorials() {
        repo.deleteAll();
    }

    public List<Tutorial> findPublishedTutorials() {
        return repo.findPublished();
    }

    public List<Tutorial> findTutorialsByTitle(String title) {
        return repo.findByTitle(title);
    }
}

package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Photo;
import ru.job4j.dream.model.Post;

import java.util.Collection;
import java.util.List;

/**
 * ru.job4j.dream.store && ru.job4j.dream.store
 *
 * @author romanvohmin
 * @since 30.07.2020
 */
public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    void save(Post post);

    void save(Candidate candidate);

    Photo save(Photo photo);

    Post findPostById(int id);

    Candidate findCandidateById(int id);

    List<Photo> findAllPhoto();
}

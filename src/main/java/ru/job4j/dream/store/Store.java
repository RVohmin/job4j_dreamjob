package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Photo;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;

/**
 * ru.job4j.dream.store && ru.job4j.dream.store
 *
 * @author romanvohmin
 * @since 30.07.2020
 */
public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    void savePost(Post post);

    void saveCandidate(Candidate candidate);

    Photo savePhoto(Photo photo);

    Post findPostById(int id);

    Candidate findCandidateById(int id);

    Collection<Photo> findAllPhoto();

    Collection<User> findAllUser();

    User findUserById(int id);

    User findUserByEmail(String email);

    void saveUser(User user);
}

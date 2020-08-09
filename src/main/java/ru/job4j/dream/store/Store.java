package ru.job4j.dream.store;

import ru.job4j.dream.model.*;

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

    void deletePost(String id);

    void saveCandidate(Candidate candidate);

    Photo savePhoto(Photo photo);

    Post findPostById(int id);

    Candidate findCandidateById(int id);

    Collection<Photo> findAllPhoto();

    Collection<User> findAllUser();

    User findUserById(int id);

    User findUserByEmailPassword(String email, String password);

    void saveUser(User user);

    void deleteCandidate(String id);

    Collection<? extends City> findAllCity();

    City findCityById(int id);
}

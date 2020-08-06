package ru.job4j.dream.store;

/**
 * ru.job4j.dream.store
 *
 * @author romanvohmin
 * @since 05.08.2020
 */

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Photo;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemStore implements Store {
    private static final MemStore INST = new MemStore();
    private static final AtomicInteger POST_ID = new AtomicInteger(0);
    private static final AtomicInteger CANDIDATE_ID = new AtomicInteger(0);
    private static final AtomicInteger USER_ID = new AtomicInteger(0);
    private static final AtomicInteger PHOTOS_ID = new AtomicInteger(0);

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();
    private final Map<Integer, User> users = new ConcurrentHashMap<>();
    private final Map<Integer, Photo> photos = new ConcurrentHashMap<>();

    private MemStore() {
        posts.put(1, new Post(1, "Junior Java Job"));
        posts.put(2, new Post(2, "Middle Java Job"));
        posts.put(3, new Post(3, "Senior Java Job"));
        candidates.put(1, new Candidate(1, "Иван Петров", 1));
        candidates.put(2, new Candidate(2, "Петр Арсентьев", 1));
        candidates.put(3, new Candidate(3, "Николай Васечкин", 1));
        users.put(1, new User(1, "Alex", "root@root.com", "root"));
        photos.put(1, new Photo(1, "Саша.jpg"));
    }

    public static MemStore instOf() {
        return INST;
    }

    //POST
    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Post findPostById(int id) {
        return posts.get(id);
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    //CANDIDATES
    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    @Override
    public void savePost(Post post) {

    }

    @Override
    public void deletePost(String id) {

    }

    @Override
    public void saveCandidate(Candidate candidate) {

    }

    public Candidate findCandidateById(int id) {
        return candidates.get(id);
    }

    public void save(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(CANDIDATE_ID.incrementAndGet());
        }
        candidates.put(candidate.getId(), candidate);
    }

    //PHOTO
    @Override
    public Collection<Photo> findAllPhoto() {
        return photos.values();
    }

    //USER
    @Override
    public Collection<User> findAllUser() {
        return users.values();
    }

    @Override
    public Photo savePhoto(Photo photo) {
        return photo;
    }

    @Override
    public User findUserById(int id) {
        return null;
    }

    @Override
    public User findUserByEmailPassword(String email, String password) {
        User user = null;
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            user = entry.getValue();
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
    }

    @Override
    public void deleteCandidate(String id) {

    }
}

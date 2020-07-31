package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;

/**
 * ru.job4j.dream.store
 *
 * @author romanvohmin
 * @since 30.07.2020
 */
public class PsqlMain {
    public static void main(String[] args) {
        Store store = PsqlStore.instOf();
//        store.save(new Post(2, "Java Jobs"));
//        store.saveCandidate(new Candidate(0, "Петр Арсентьев"));
        store.save(new Candidate(2, "Роман Вохмин "));
        for (Candidate candidate : store.findAllCandidates()) {
            System.out.println(candidate.getId() + " " + candidate.getName());
        }
        Candidate candidate = store.findCandidateById(2);
        System.out.println(candidate.getId() + " " + candidate.getName());
//        Post post = store.findPostById(2);
//        System.out.println(post.getId() + " " + post.getName());
//        for (Post post : store.findAllPosts()) {
//            System.out.println(post.getId() + " " + post.getName());
//        }
    }
}

package voteSystem3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voteSystem3.domain.VoteStory;
import voteSystem3.repository.RestaurantRepository;
import voteSystem3.repository.UserRepository;
import voteSystem3.repository.VoteStoryRepository;

import javax.transaction.Transactional;


@Service
@Transactional
public class SimpleService {
    @Autowired
    VoteStoryRepository  voteStoryRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    UserRepository userRepository;

    public void testGet(){

        voteStoryRepository.save(new VoteStory(2L,2L));
        restaurantRepository.findAll().forEach(r-> System.out.println(r.toString()));
        voteStoryRepository.findAll().forEach(r -> System.out.println(r.toString()));
    }

}

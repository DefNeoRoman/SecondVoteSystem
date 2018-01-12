package voteSystem3.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voteSystem3.domain.VoteStory;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface VoteStoryRepository extends JpaRepository<VoteStory, Long> {

}

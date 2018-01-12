package voteSystem3.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
@Table(name = "votestory")
public class VoteStory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long user_id;
    @Column
    private Long restaurant_id;
    @Column(name = "vote_date", columnDefinition = "timestamp default now()")
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date voteDate;

    public VoteStory() {
    }

    public VoteStory(Long user_id, Long restaurant_id) {
        this.user_id = user_id;
        this.restaurant_id = restaurant_id;
        voteDate = new Date();
    }

    @Override
    public String toString() {
        return "VoteStory{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", restaurant_id=" + restaurant_id +
                ", voteDate=" + voteDate +
                '}';
    }
}

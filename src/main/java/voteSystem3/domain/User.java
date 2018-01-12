package voteSystem3.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.BatchSize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;
    @Column(name = "register_date", columnDefinition = "timestamp default now()")
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerDate;
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    private Set<Role> authorities;
    @Column(name = "isVote", nullable = false, columnDefinition = "bool default false")
    private boolean isVote;
    @Column(name = "canVote", nullable = false, columnDefinition = "bool default true")
    private boolean canVote;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled;
    @Column(name = "accountNonExpired", nullable = false, columnDefinition = "bool default true")
    private boolean accountNonExpired;
    @Column(name = "accountNonLocked", nullable = false, columnDefinition = "bool default true")
    private boolean accountNonLocked;
    @Column(name = "credentialsNonExpired", nullable = false, columnDefinition = "bool default true")
    private boolean credentialsNonExpired;

    public User() {

        registerDate = new Date();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

            return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}

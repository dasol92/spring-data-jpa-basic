package study.datajpa.repository;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.datajpa.entity.Team;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class TeamRepositoryTest {

    @Autowired
    TeamRepository teamRepository;

    @Test
    void basicCRUD() {
        Team team = new Team("ACE");
        teamRepository.save(team);

        Optional<Team> findTeamOpt = teamRepository.findById(team.getId());
        if (findTeamOpt.isPresent()) {
            Team findTeam = findTeamOpt.get();

            assertThat(findTeam.getId()).isEqualTo(team.getId());
            assertThat(findTeam).isEqualTo(team);
        }

    }

}
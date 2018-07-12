package pl.marcelbaungardt.naukatheamleaf.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.marcelbaungardt.naukatheamleaf.model.User;
import pl.marcelbaungardt.naukatheamleaf.repository.UserRepository;

@Component
public class Bootstrap implements CommandLineRunner {
    UserRepository userRepository;

    @Autowired
    public Bootstrap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadUser();
    }

    private void loadUser() {
        userRepository.save(User.builder().email("marcelidt1994@gmail.com").username("cosmo123").firstName("Marcel").secondName("Baumgardt").build());
        userRepository.save(User.builder().email("anka1994@gmail.com").username("anka123").firstName("Anna").secondName("Wisniewska").build());
    }
}

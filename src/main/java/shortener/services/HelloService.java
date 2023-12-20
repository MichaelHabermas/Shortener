package shortener.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import shortener.entities.Hello;
import shortener.repositories.HelloRepository;

import java.util.List;

@Service
public class HelloService {

    @Autowired
    HelloRepository helloRepository;

    public String greeting() {
        return "From Russia with SERVICE";
    }

    private String generateShortURL() {
        return "shortened URL";
    }

    public Hello save(Hello hello) {
        return helloRepository.save(hello);
    }

    public List<Hello> findAll() {
        return helloRepository.findAll();
    }

    public String delete(Long id) {
        Hello helloToDelete = helloRepository.findById(id).get();
        helloRepository.delete(helloToDelete);

        return "Successfully Deleted: " + id;
    }
}

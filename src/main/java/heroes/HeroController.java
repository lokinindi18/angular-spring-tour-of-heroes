package heroes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroController {

	@Autowired
	HeroRepository heroRepository;

	@GetMapping("/heroes")
	public Iterable<Hero> getAllHeroes() {
		return heroRepository.findAll();
	}

	@RequestMapping(value = "/hero/search", method = RequestMethod.GET)
	public Hero[] findAHero(@RequestParam String name) {
		return heroRepository.findByName(name);
	}

}

package one.digitalinnovation.beerstock.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.beerstock.dto.BeerDTO;
import one.digitalinnovation.beerstock.entity.Beer;
import one.digitalinnovation.beerstock.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BeerService {

    private BeerRepository beerRepository;
    private BeerMapper beerMapper = BeerMapper.INSTANCE;

    public BeerDTO createBeer(BeerDto beerDto) {
        verifyIfItIsRegistered(beerDto.getName());
        Beer beer = beerMapper.toModel(beerDto);
        Beer savedBeer = beerRepository.save(beer);
        return beerMapper.toDTO(savedBeer);
    }

    public BeerDTO findByName(String name) {
        Beer foundBeer = beerRepository.findByName(name);

        return beerMapper.toDTO(foundBeer);
    }

    public List<BeerDTO> listAll() {
        return beerRepository.findAll()
                .stream()
                .map(beerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        verifyIfExists(id);
        beerRepository.deleteById(id);
    }

    private void verifyIfItIsRegistered(String name) {
        Optional<Beer> optSavedBeer = beerRepository.findByName(name);

    }

    private Beer verifyIfExists(Long id) {
        return beerRepository.findById(id);
    }
}

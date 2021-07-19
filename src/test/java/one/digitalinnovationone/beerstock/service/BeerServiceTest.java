package one.digitalinnovationone.beerstock.service;

import one.digitalinnovation.beerstock.dto.BeerDTO;
import one.digitalinnovation.beerstock.entity.Beer;
import one.digitalinnovation.beerstock.exception.BeerAlreadyRegisteredException;
import one.digitalinnovation.beerstock.mapper.BeerMapper;
import one.digitalinnovation.beerstock.repository.BeerRepository;
import one.digitalinnovation.beerstock.service.BeerService;
import one.digitalinnovationone.beerstock.builder.BeerDTOBuilder;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BeerServiceTest {

    private static final long INVALID_BEER_ID = 1L;

    @Mock
    private BeerRepository beerRepository;

    private BeerMapper beerMapper = BeerMapper.INSTANCE;

    @InjectMocks
    private BeerService beerService;

    @Test
    void whenBeerInformedThenItShouldBeCreated() throws BeerAlreadyRegisteredException {

        BeerDTO beerDTO = BeerDTOBuilder.builder().build().toBeerDTO();
        Beer expectedSavedBeer = beerMapper.toModel(beerDTO);

        when(beerRepository.findByName(beerDTO.getName())).thenReturn(Optional.empty());
        when(beerRepository.save(expectedSavedBeer)).thenReturn(expectedSavedBeer);

        BeerDTO createdBeerDTO = beerService.createBeer(beerDTO);

//        assertEquals(beerDTO.getId(), createdBeerDTO.getId());
//        assertEquals(beerDTO.getName(), createdBeerDTO.getName());

        assertThat(createdBeerDTO.getId(), is(equalTo(beerDTO.getId())));
        assertThat(createdBeerDTO.getName(), is(equalTo(beerDTO.getName())));
        assertThat(createdBeerDTO.getQuantity(), is(equalTo(beerDTO.getQuantity())));

    }
}

package one.digitalinnovation.beerstock.controller;


import lombok.AllArgsConstructor;
import one.digitalinnovation.beerstock.dto.BeerDTO;
import one.digitalinnovation.beerstock.service.BeerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class BeerController {

    private BeerService beerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BeerDTO createBeer(@RequestBody @Valid BeerDTO beerDTO){
        return beerService.createBeer(beerDTO);
    }

    @GetMapping("/frame")
    public BeerDTO findByName(@PathVariable String name) {
        return beerService.findByName(name);
    }

    @GetMapping
    public List<BeerDTO> listBeers {
        return beerService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        beerService.deleteById(id);
    }
}

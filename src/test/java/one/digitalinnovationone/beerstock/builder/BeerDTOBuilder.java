package one.digitalinnovationone.beerstock.builder;

import lombok.Builder;
import one.digitalinnovation.beerstock.dto.BeerDTO;
import one.digitalinnovation.beerstock.enums.BeerType;

@Builder
public class BeerDTOBuilder {

    @Builder.Default
    private Long id = 1L;

    @Builder.Default
    private String name = "Skol";

    @Builder.Default
    private String brand = "Ambev";

    @Builder.Default
    private int max = 50;

    @Builder.Default
    private int quantity = 12;

    @Builder.Default
    private BeerType type = BeerType.AMERICANLAGER;

    public BeerDTO toBeerDTO() {
        return new BeerDTO(
                id,
                name,
                brand,
                max,
                quantity,
                type);
    }
}

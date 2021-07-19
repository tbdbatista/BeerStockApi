package one.digitalinnovationone.beerstock.builder;

import lombok.Builder;
import one.digitalinnovation.beerstock.dto.BeerDTO;
import one.digitalinnovation.beerstock.enums.BeerType;

@Builder
public class BeerDTOBuilder2 {

    @Builder.Default
    private Long id = 1L;

    @Builder.Default
    private String name = "Heineken";

    @Builder.Default
    private String brand = "FEMSA";

    @Builder.Default
    private int maximumAmout = 51;

    @Builder.Default
    private int quantity = 13;

    @Builder.Default
    private BeerType type = BeerType.IPA;

    public BeerDTO toBeerDTO2() {
        return new BeerDTO(
                id,
                name,
                brand,
                maximumAmout,
                quantity,
                type);
    }
}

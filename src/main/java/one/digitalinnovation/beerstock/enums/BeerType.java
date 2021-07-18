package one.digitalinnovation.beerstock.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BeerType {

    AMERICANLAGER("American Lager"),
    PALEALE("Pale Ale"),
    IPA("IPA"),
    STOUT("Stout"),
    WEISS("Weiss"),
    PORTER("Porter"),
    WITBIER("Witbier"),
    DUBEL("Dubel"),
    TRIPEL("Tripel"),
    QUADRUPEL("Quadrupel"),
    MALZBIER("Malzbier");

    private final String description;

}

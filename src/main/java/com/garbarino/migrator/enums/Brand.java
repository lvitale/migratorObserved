package com.garbarino.migrator.enums;

import org.jetbrains.annotations.NotNull;


public enum Brand
    
{
    NARANJA("Tarjeta Naranja", "NAR"),
    SHOPPING("Tarjeta Shopping", "SHOP"),
    VISA("Visa", "VISA"),
    MASTERCARD("MasterCard", "MAST"),
    PROPIO("CreditoPropio", "PROP"),
    AMEX("Amex", "AMEX"),
    NATIVA("Nativa", "NAT"),
    DINERS("Diners", "DIN"),
    NATIVA_MAS("Nativa Mastercard", "NATM"),
    CABAL("Cabal", "CAB");

    //~ Fields ...................................................................................................................

    @NotNull private final String label;
    @NotNull private final String id;

    //~ Constructors .............................................................................................................

    Brand(@NotNull String label, @NotNull String id) {
        this.label = label;
        this.id = id;
    }

    
}

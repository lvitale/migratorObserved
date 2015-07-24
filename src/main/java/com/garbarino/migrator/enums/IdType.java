package com.garbarino.migrator.enums;

import org.jetbrains.annotations.NotNull;


public enum IdType
    
{
    NOT_INFORMED("Not informed", true, 0, 0, false, ""),
    DNI("DNI", true, 6, 8, true, "R##.###.###"),
    LC("LC", true, 5, 8, true, "R##.###.###"),
    LE("LE", true, 5, 8, true, "R##.###.###"),
    CI("CI", true, 6, 8, true, "R##.###.###"),
    PASSPORT("Passport", true, 5, 9, false, "#########"),
    TAX_CODE("Tax Code", true, 11, 11, false, "##-##.###.###-#"),
    VENDOR_ID("EBS Vendor Id", true, 1, 10, true, "##########");

    //~ Fields ...................................................................................................................

    @NotNull private final String label;
    private final boolean unique;
    private final int minLength;
    private final int maxLength;
    private final boolean numeric;
    @NotNull private final String mask;

    //~ Constructors .............................................................................................................

    IdType(@NotNull String label, boolean unique, int minLength, int maxLength, boolean numeric, @NotNull String mask) {
        this.label = label;
        this.unique = unique;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.numeric = numeric;
        this.mask = mask;
    }

}

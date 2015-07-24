package com.garbarino.migrator.enums;

import org.jetbrains.annotations.NotNull;


public enum GenderType
   
{
    MALE("Male"),
    FEMALE("Female"),
    NONE("Not informed");

    //~ Fields ...................................................................................................................

    @NotNull private final String label;

    //~ Constructors .............................................................................................................

    GenderType(@NotNull String label) { this.label = label; }


}

package com.example.onlinelottery.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public
class Schema implements  Cloneable{
    private String schemaname;
    private String usermgrname;
    private String humansel;
    private String schemasel;

    @Override
    public Schema clone() {
        try {
            Schema clone = (Schema) super.clone();
            clone.schemaname=this.schemaname;
            clone.usermgrname=this.usermgrname;
            clone.humansel=this.humansel;
            clone.schemasel=this.schemasel;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

package com.tantec.socials.anonymousstoryapi.beans;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper=true, includeFieldNames=true)
public class PaymentMethod {

    @Getter
    @Setter    
    @NotNull
    private String type;

    @Getter
    @Setter
    @NotNull
    private Map<String, Object> details;
    
    public PaymentMethod() {
        super();
        this.type = "";
        this.details = new HashMap<String, Object>();
    }
}
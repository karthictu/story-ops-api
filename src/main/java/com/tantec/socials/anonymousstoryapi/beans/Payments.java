package com.tantec.socials.anonymousstoryapi.beans;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper=true, includeFieldNames=true)
public class Payments {

    @Getter
    @Setter    
    @NotNull
    private User user;

    @Getter
    @Setter    
    @NotNull
    private List<PaymentMethod> payments;

    public Payments() {
        super();
        this.user = new User();
        this.payments = new ArrayList<PaymentMethod>();
    }
    
}
package com.jdktomcat.pack.pattern.template.pro;

public abstract class AbstractMerchantSettle implements IMerchantSettle {

    public final void settle() {
        validate();
        makeup();
        auth();
        call();
    }

    protected void validate() {

    }

    protected void makeup() {

    }

    protected void auth() {

    }

    protected void call() {

    }

}

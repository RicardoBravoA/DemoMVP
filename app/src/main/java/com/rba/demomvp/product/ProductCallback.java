package com.rba.demomvp.product;

import com.rba.demomvp.model.response.ProductResponse;

/**
 * Created by Ricardo Bravo on 21/11/16.
 */


public interface ProductCallback {

    void onResponse(ProductResponse productResponse);

    void onFailure(String error);

}

package com.bandex.apicenter.appapi;

import com.bandex.base.dto.ApiRequest;
import com.bandex.base.dto.ApiResponse;

/**
 * Created by fanshuai on 16/10/25.
 */
public interface AppIndexDataApi {
    @SuppressWarnings("rawtypes")
    ApiResponse loadIndexData(ApiRequest apiReq);
}

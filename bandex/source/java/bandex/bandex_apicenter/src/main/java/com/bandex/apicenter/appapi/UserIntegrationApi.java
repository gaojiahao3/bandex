package com.bandex.apicenter.appapi;

import com.bandex.apicenter.model.UserIntegrationDetail;
import com.bandex.apicenter.service.impl.BaseServiceImpl;
import com.bandex.base.dto.ApiRequest;
import com.bandex.base.dto.ApiResponse;

import java.util.List;

/**
 * Created by fanshuai on 16/10/26.
 */
public interface UserIntegrationApi {
    public ApiResponse queryIntegraDetail(ApiRequest apiReq);
}

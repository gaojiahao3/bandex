package com.bandex.api.service.common;

import com.bandex.api.annotations.FunctionCode;
import com.bandex.api.dao.CommonAreaMapper;
import com.bandex.api.dto.ApiRequest;
import com.bandex.api.dto.ApiResponse;
import com.bandex.api.enums.RestResultEnum;
import com.bandex.api.model.CommonArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 2015/1/23.
 */

/**
 * Created by user on 2015/1/21.
 */
@FunctionCode(value = "area", descript = "区域相关API")
@Service
public class AreaServiceImpl implements  AreaService {

    @Autowired
    private CommonAreaMapper commonAreaMapper;

    /**
     * 根据ID获取区域信息
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "area.getArea", descript = "根据ID获取区域信息")
    @Override
    public ApiResponse<CommonArea> getArea(ApiRequest apiRequest) {
        Object obj = apiRequest.get("areaId");
        if (StringUtils.isEmpty(obj)) {
            return new ApiResponse<CommonArea>(RestResultEnum.MissParameterException);
        }
        ApiResponse<CommonArea> apiResponse = null;
        try {
            CommonArea commonArea = commonAreaMapper.selectByPrimaryKey(Long.valueOf(obj.toString()));
            if (commonArea != null) {
                apiResponse = new ApiResponse<CommonArea>(RestResultEnum.SUCCESS, 1, commonArea);
            }else{
                apiResponse = new ApiResponse<CommonArea>(RestResultEnum.SUCCESS, 1, commonArea);
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse<CommonArea>(RestResultEnum.INVOKE_ERROR);
        }
        return apiResponse;
    }

    /**
     * 区域列表获取
     * @param apiRequest
     * @return
     */
    @FunctionCode(value = "area.getAreaList", descript = "区域列表获取")
    @Override
    public ApiResponse<List<CommonArea>> queryAreaList(ApiRequest apiRequest) {
        Object parentIdObj = apiRequest.get("parentId");
        /*Object pageNoObj = apiRequest.get("pageNo");
        Object pageSizeObj = apiRequest.get("pageSize");
        Long pageNo = 1L;
        Long pageSize = 10L;
        if(!StringUtils.isEmpty(pageNoObj)){
            pageNo = Long.parseLong(pageNoObj.toString());
        }
        if(!StringUtils.isEmpty(pageSizeObj)){
            pageSize = Long.parseLong(pageSizeObj.toString());
        }*/
        HashMap<String,Object> hashMap = new HashMap<String, Object>();
       /* Pagination<CommonArea> poPagination = new Pagination<CommonArea>(pageNo, pageSize);
        hashMap.put("startIndex", (pageNo-1)*pageSize);
        hashMap.put("endIndex", pageSize);*/
       // Long count = this.commonAreaMapper.queryAreaListCount(hashMap);
       // System.out.println("******************"+count);
        if(!StringUtils.isEmpty(parentIdObj)){
            hashMap.put("parentId",parentIdObj.toString());
        }
        List<CommonArea>  commonAreas  = null;
       /* poPagination.setNumFound(count);
        poPagination.setData(commonBrands);*/
        return new ApiResponse<List<CommonArea>>(RestResultEnum.SUCCESS, (commonAreas == null ? 0 : (int) commonAreas.size()), commonAreas);
    }
}

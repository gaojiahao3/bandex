package com.bandex.apicenter.appapi.impl;

import com.bandex.apicenter.appapi.AchieveApi;
import com.bandex.apicenter.dao.CommonAchievementMapper;
import com.bandex.apicenter.dao.UserAchievementMapper;
import com.bandex.apicenter.dto.CommonAchievementDto;
import com.bandex.apicenter.model.CommonAchievement;
import com.bandex.apicenter.model.UserAchievement;
import com.bandex.apicenter.service.impl.BaseServiceImpl;
import com.bandex.base.annotations.ApiMethod;
import com.bandex.base.annotations.ApiParam;
import com.bandex.base.dto.ApiRequest;
import com.bandex.base.dto.ApiResponse;
import com.bandex.base.enums.ApiMsgEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thinkpad on 2016/11/2.
 */
public class AchieveApiImpl extends BaseServiceImpl implements AchieveApi {
    @Autowired
    private CommonAchievementMapper achievementMapper;

    @Autowired
    private UserAchievementMapper userAchievementMapper;

    @ApiMethod(descript = "成就列表", value = "achieve-list", apiParams = { @ApiParam(name = "user_token",descript = "当前用户token(*)") })
    @Override
    public ApiResponse achieveList(ApiRequest apiReq) {
        List<CommonAchievement> achievementList = achievementMapper.selectAll();
        Long userId = apiReq.getCurrentUserId();
        List<UserAchievement> userAchievementList=userAchievementMapper.selectByUserId(userId);
        List<CommonAchievementDto> dtoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(userAchievementList)){
            for (UserAchievement userAchievement:userAchievementList){
                CommonAchievement hasGetAchievement=null;
                for (CommonAchievement achievement:achievementList){
                    if (achievement.getId()==userAchievement.getAchieveId()){
                        hasGetAchievement=achievement;
                        achievementList.remove(achievement);
                        break;
                    }
                }
                if (hasGetAchievement!=null){
                    CommonAchievementDto dto = new CommonAchievementDto();
                    dto.setHasGeted(true);
                    dto.setAchieveName(hasGetAchievement.getAchieveName());
                    dto.setAchievePic(hasGetAchievement.getAchievePic());
                    dto.setAchieveType(hasGetAchievement.getAchieveType());
                    dto.setDescription(hasGetAchievement.getDescription());
                    dtoList.add(dto);
                }

            }
        }
        for (CommonAchievement achievement:achievementList){
            CommonAchievementDto dto = new CommonAchievementDto();
            dto.setHasGeted(false);
            dto.setAchieveName(achievement.getAchieveName());
            dto.setAchievePic(achievement.getAchievePic());
            dto.setAchieveType(achievement.getAchieveType());
            dto.setDescription(achievement.getDescription());
            dtoList.add(dto);
        }
        return new ApiResponse(ApiMsgEnum.SUCCESS,1,dtoList);
    }
}

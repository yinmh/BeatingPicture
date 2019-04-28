package org.game.beatingpicture.vo;

import lombok.Data;
import org.game.beatingpicture.entity.UserInfo;
@Data
public class UserInfoVo extends UserInfo {
    private String designationName;
    private String rankName;
    private String headImgPath;
}

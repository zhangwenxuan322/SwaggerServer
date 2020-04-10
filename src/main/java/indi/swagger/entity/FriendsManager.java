package indi.swagger.entity;

import java.util.Date;

/**
 * @program: Swagger
 * @description: 好友关系管理实体类
 * @author: 张文轩
 * @create: 2020-04-10 16:35
 **/
public class FriendsManager {
    private int id;
    private int mainUserId;
    private int friendUserId;
    private String remarkName;
    private String groupName;
    private Date createTime;
    private Date modifyTime;

    public FriendsManager() {
    }

    public FriendsManager(int id, int mainUserId, int friendUserId, String remarkName, String groupName, Date createTime, Date modifyTime) {
        this.id = id;
        this.mainUserId = mainUserId;
        this.friendUserId = friendUserId;
        this.remarkName = remarkName;
        this.groupName = groupName;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMainUserId() {
        return mainUserId;
    }

    public void setMainUserId(int mainUserId) {
        this.mainUserId = mainUserId;
    }

    public int getFriendUserId() {
        return friendUserId;
    }

    public void setFriendUserId(int friendUserId) {
        this.friendUserId = friendUserId;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "FriendsManager{" +
                "id=" + id +
                ", mainUserId=" + mainUserId +
                ", friendUserId=" + friendUserId +
                ", remarkName='" + remarkName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}

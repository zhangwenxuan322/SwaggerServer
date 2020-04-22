package indi.swagger.entity;

/**
 * @program: Swagger
 * @description: 好友请求实体类
 * @author: 张文轩
 * @create: 2020-04-22 14:02
 **/
public class FriendRequest {
    private int reqId;
    private int reqMainId;
    private int reqSubId;
    private String reqMsg;
    private int reqCode;

    public FriendRequest() {
    }

    public FriendRequest(int reqId, int reqMainId, int reqSubId, String reqMsg, int reqCode) {
        this.reqId = reqId;
        this.reqMainId = reqMainId;
        this.reqSubId = reqSubId;
        this.reqMsg = reqMsg;
        this.reqCode = reqCode;
    }

    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public int getReqMainId() {
        return reqMainId;
    }

    public void setReqMainId(int reqMainId) {
        this.reqMainId = reqMainId;
    }

    public int getReqSubId() {
        return reqSubId;
    }

    public void setReqSubId(int reqSubId) {
        this.reqSubId = reqSubId;
    }

    public String getReqMsg() {
        return reqMsg;
    }

    public void setReqMsg(String reqMsg) {
        this.reqMsg = reqMsg;
    }

    public int getReqCode() {
        return reqCode;
    }

    public void setReqCode(int reqCode) {
        this.reqCode = reqCode;
    }

    @Override
    public String toString() {
        return "FriendRequest{" +
                "reqId=" + reqId +
                ", reqMainId=" + reqMainId +
                ", reqSubId=" + reqSubId +
                ", reqMsg='" + reqMsg + '\'' +
                ", reqCode=" + reqCode +
                '}';
    }
}

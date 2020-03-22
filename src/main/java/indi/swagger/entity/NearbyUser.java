package indi.swagger.entity;

/**
 * @program: Swagger
 * @description: 附近的人
 * @author: 张文轩
 * @create: 2020-03-22 09:44
 **/
public class NearbyUser {
    private int nearbyId;
    private String nearbyPortrait;
    private String nearbyUserName;
    private String nearbyDistance;
    private String nearbyUserBio;

    public NearbyUser() {
    }

    public NearbyUser(int nearbyId, String nearbyPortrait, String nearbyUserName, String nearbyDistance, String nearbyUserBio) {
        this.nearbyId = nearbyId;
        this.nearbyPortrait = nearbyPortrait;
        this.nearbyUserName = nearbyUserName;
        this.nearbyDistance = nearbyDistance;
        this.nearbyUserBio = nearbyUserBio;
    }

    public int getNearbyId() {
        return nearbyId;
    }

    public void setNearbyId(int nearbyId) {
        this.nearbyId = nearbyId;
    }

    public String getNearbyPortrait() {
        return nearbyPortrait;
    }

    public void setNearbyPortrait(String nearbyPortrait) {
        this.nearbyPortrait = nearbyPortrait;
    }

    public String getNearbyUserName() {
        return nearbyUserName;
    }

    public void setNearbyUserName(String nearbyUserName) {
        this.nearbyUserName = nearbyUserName;
    }

    public String getNearbyDistance() {
        return nearbyDistance;
    }

    public void setNearbyDistance(String nearbyDistance) {
        this.nearbyDistance = nearbyDistance;
    }

    public String getNearbyUserBio() {
        return nearbyUserBio;
    }

    public void setNearbyUserBio(String nearbyUserBio) {
        this.nearbyUserBio = nearbyUserBio;
    }

    @Override
    public String toString() {
        return "NearnyUser{" +
                "nearbyId=" + nearbyId +
                ", nearbyPortrait='" + nearbyPortrait + '\'' +
                ", nearbyUserName='" + nearbyUserName + '\'' +
                ", nearbyDistance='" + nearbyDistance + '\'' +
                ", nearbyUserBio='" + nearbyUserBio + '\'' +
                '}';
    }
}

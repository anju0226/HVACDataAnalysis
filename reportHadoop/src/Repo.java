/**
 * Created by anju on 7/8/16.
 */
public class Repo {

    int buildingId;
    String manager;
    String modalNo;
    String recordDate;
    String recordTime;
    double expectedData;
    double actualData;


    public Repo() {
    }

    public Repo(int buildingId,String manager,String modalNo, String recordDate, String recordTime, double expectedData, double resultedData) {
        this.buildingId = buildingId;
        this.modalNo = modalNo;
        this.expectedData = expectedData;
        this.actualData = resultedData;
    }



    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getModalNo() {
        return modalNo;
    }

    public void setModalNo(String modalNo) {
        this.modalNo = modalNo;
    }

    public double getExpectedData() {
        return expectedData;
    }

    public void setExpectedData(double expectedData) {
        this.expectedData = expectedData;
    }

    public double getActualData() {
        return actualData;
    }

    public void setActualData(double resultedData) {
        this.actualData = resultedData;
    }
}


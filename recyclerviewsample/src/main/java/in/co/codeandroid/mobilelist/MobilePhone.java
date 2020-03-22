package in.co.codeandroid.mobilelist;

public class MobilePhone {

    private String modelName;
    private int price;
    private int modelYear;
    private String detailsLink;

    public String getModelName() {
        return modelName;
    }

    public MobilePhone setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public MobilePhone setPrice(int price) {
        this.price = price;
        return this;
    }

    public int getModelYear() {
        return modelYear;
    }

    public MobilePhone setModelYear(int modelYear) {
        this.modelYear = modelYear;
        return this;
    }

    public String getDetailsLink() {
        return detailsLink;
    }

    public MobilePhone setDetailsLink(String detailsLink) {
        this.detailsLink = detailsLink;
        return this;
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "modelName='" + modelName + '\'' +
                ", price=" + price +
                ", modelYear=" + modelYear +
                ", detailsLink='" + detailsLink + '\'' +
                '}';
    }
}

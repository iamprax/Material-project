package in.prax.tamalproject;

public class BuyerProductsPojo {

    String productname;
    String imageid;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BuyerProductsPojo(String productname, int id) {

        this.productname = productname;
        this.id = id;
    }

    public BuyerProductsPojo(String productname, String imageid) {
        this.productname = productname;
        this.imageid = imageid;
    }

    public BuyerProductsPojo(String productname) {
        this.productname = productname;
    }

    public String getProductname() {
        return productname;
    }

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String imageid) {
        this.imageid = imageid;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }
}

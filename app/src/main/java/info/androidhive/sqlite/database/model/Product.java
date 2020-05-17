package info.androidhive.sqlite.database.model;

/**
 * Created by ravi on 20/02/18.
 */

public class Product {

    //------------------------------------------------------------
    public static final String TABLE_NAME = "products";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PRODUCT_NAME = "productName";
    public static final String COLUMN_PRODUCT_DESCRIPTION = "productDescription";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_PRODUCT_NAME + " TEXT,"
                    + COLUMN_PRODUCT_DESCRIPTION + " TEXT, "
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";
    //--------------------------------------------------
    private int id;
    private String productName;
    private String productDescription;
    private String timestamp;

    public Product() {
    }

    public Product(int id, String productName, String productDescription, String timestamp) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.timestamp = timestamp;
    }

    public int getProductId() {
        return id;
    }
    public void setProductId(int id) {
        this.id = id;
    }
    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription(){
        return  productDescription;
    }
    public void setProductDescription(String productDescription){
        this.productDescription = productDescription;
    }

    public String getProductTimestamp() {
        return timestamp;
    }

    public void setProductTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

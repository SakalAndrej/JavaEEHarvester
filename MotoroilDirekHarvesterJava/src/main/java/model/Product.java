package model;

public class Product
{

    //Bild
    private String _baseImage;

    //SmallBild
    private String _smallImage;

    //Beschreibung
    private String _description;

    //Marke & Model
    private String _brand;

    //Titel des Produktes
    private String _title;

    //Verfügbarkeit
    private int _inStock;

    //Preis
    private double _price;

    //Sku
    private String _sku;

    //Container
    private double _container;

    @Override
    public String toString() {
        return  "^"+_sku+"^;" + "^3^;" + "^4^;" + "^1^;" + "^0^;" + "^base^;" + "^simple^;" + "^Default^;" +"^"+ "-"+"^" + ";" + "^"+ _description + "^"+ ";" + "^"+ _title + "^"+ ";" + "^"+ _inStock + "^"+ ";" + "^"+ _price+"^;^"+ _baseImage +"^;^" + _baseImage+"^;^" + _baseImage+"^;^" + _container + "^\n";
    }

//region Getter & Setter


    public String get_smallImage() {
        return _smallImage;
    }

    public void set_smallImage(String _smallImage) {
        this._smallImage = _smallImage;
    }

    public double get_container() {
        return _container;
    }

    public void set_container(double _container) {
        this._container = _container;
    }

    public String get_sku() {
        return _sku;
    }

    public void set_sku(String _sku) {
        this._sku = _sku;
    }

    public String get_baseImage() { return _baseImage; }

    public void set_baseImage(String _picture) { this._baseImage = _picture;}

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public int get_inStock() {
        return _inStock;
    }

    public void set_inStock(int _inStock) {
        this._inStock = _inStock;
    }

    public double get_price() {
        return _price;
    }

    public void set_price(double _price) {
        this._price = _price;
    }

    public String get_brand() {
        return _brand;
    }

    public void set_brand(String _brand) {
        this._brand = _brand;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }
    //endregion
}

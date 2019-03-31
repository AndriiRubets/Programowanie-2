package zajecie_1;

public class ZartOChukNorisie {
    public String icon_url,id,url,value;

    @Override
    public String toString() {
        return "ZartOChukNorisie{" +
                "icon_url='" + icon_url + '\'' +
                ", id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public ZartOChukNorisie(String icon_url, String id, String url, String value) {
        this.icon_url = icon_url;
        this.id = id;
        this.url = url;
        this.value = value;
    }
}

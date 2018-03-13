package ru.mbt_bs.fluffy_crm.data.json;

public class CustomerLink {
    private Integer id;
    private String name;

    public CustomerLink() {
    }

    public CustomerLink(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " : " + name;
    }
}

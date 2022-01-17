package jpabook.jpashop.valueType;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity {

    @Id @GeneratedValue
    private Long id;

    public AddressEntity(Address address){
        this.address = address;
    }

    @Embedded
    private Address address;

    public AddressEntity(){
        }

    public AddressEntity(String city, String street, String zipcode) {
        this.address = new Address(city, street, zipcode);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

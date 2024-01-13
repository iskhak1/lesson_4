package project;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="test.magic")
public class Magic {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "damage")
    private int damage;
    @Column(name = "atack")
    private int attBonus;
    @Column(name = "armor")
    private int armor;

    public Magic(String name, int damage, int attBonus,int armor) {
        this.name = name;
        this.damage = damage;
        this.attBonus = attBonus;
        this.armor = armor;
    }

    public Magic() {
    }

    @Override
    public String toString() {
        return "Magic{" +
                "idmagic=" + id +
                ", name='" + name + '\'' +
                ", damage=" + damage +
                ", attBonus=" + attBonus +
                ", armor=" + armor +
                '}';
    }
}

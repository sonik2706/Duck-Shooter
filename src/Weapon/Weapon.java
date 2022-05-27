package Weapon;

import javax.swing.*;

public class Weapon extends JLabel {
    private int weaponLevel = 1;
    private int damage = 1;
    private int cost = 0;

    public Weapon(){
        setIcon(new ImageIcon("Graphics/pistol.png"));
    }

    public int upgradeWeapon(){
        weaponLevel += 1;
        if (weaponLevel == 2) {
            this.damage = 2;
            this.cost = 200;
            setIcon(new ImageIcon("Graphics/rifle.png"));
        }
        else if (weaponLevel == 3){
            this.damage = 3;
            this.cost = 500;
            setIcon(new ImageIcon("Graphics/machinegun.png"));
        }

        return cost;
    }

    public int getWeaponLevel() {
        return weaponLevel;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

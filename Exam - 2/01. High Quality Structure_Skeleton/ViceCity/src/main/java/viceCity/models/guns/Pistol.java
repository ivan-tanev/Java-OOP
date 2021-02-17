package viceCity.models.guns;

public class Pistol extends BaseGun {

    private int bulletsPerBarrel = 10;
    private int totalBullets = 100;

    protected Pistol(String name, int bulletsPerBarrel, int totalBullets) {
        super(name, bulletsPerBarrel, totalBullets);
    }
    //Has 10 bullets per barrel and 100 total bullets.


//    public Pistol(String name) {
//        super(name);
//    }


    @Override
    public int fire() {
        return 0;
    }
}

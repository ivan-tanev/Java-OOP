package viceCity.models.guns;

public class Rifle extends BaseGun {

    private int bulletsPerBarrel = 50;
    private int totalBullets = 500;
    //Has 50 bullets per barrel and 500 total bullets.

    public Rifle(String name, int bulletsPerBarrel, int totalBullets) {
        super(name, bulletsPerBarrel, totalBullets);
    }

    @Override
    public int fire() {
        return 0;
    }
}

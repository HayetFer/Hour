public class Heure {
    private int h;
    private int min;

    public Heure() {
        h = 0;
        min = 0;
    }

    public Heure(int h, int min) {
        this.h = h;
        this.min = min;
    }

    public Heure(Heure heure) {
        heure.h = h;
        heure.min = h;
    }

    public int getH() {
        return h;
    }

    public int getMin() {
        return min;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void avance(int minute) {
        if (minute == 0) {
            return;
        }
        if (minute < 60) {

            if (minute + min > 60) {
                h += 1;
                while (min < 60) {
                    min++;
                    minute--;

                }

                min = 0;
                min += minute;

            }

            else {
                min += minute;
            }
        } else if (minute > 60) {
            h += (minute / 60);
            int temp = minute / 60;
            minute = minute - temp * 60;

            avance(minute);

        }
    }

    public void recule(int minute) {
        if (minute == 0) {
            return;
        }

        if (minute < 60) {

            if (min - minute < 0) {
                System.out.println("ici " + minute);
                h -= 1;
                while (min > 0) {
                    min--;
                    minute--;
                    System.out.println("la " + minute);
                }

                min = 60;
                min -= minute;

            }

            else {
                System.out.println("la " + minute);
                min -= minute;
            }
        } else if (minute > 60) {
            h -= (minute / 60);
            int temp = minute / 60;

            minute = minute - temp * 60;
            System.out.println(minute);
            recule(minute);

        }
    }

    public Heure duree(Heure heure) {
        Heure duree = new Heure();

        if (heure.getH() > h) {
            duree.setH(heure.getH() - h);
            if (heure.getMin() > min) {
                duree.setMin(heure.getMin() - min);

            } else if (heure.getMin() < min) {
                int temp = heure.getMin();
                int temp2 = min;
                while (temp > 0) {
                    temp--;
                    temp2--;
                }
                temp = 60;
                temp -= temp2;
                duree.setMin(temp);
                duree.setH((heure.getH() - h) - 1);
            }

        }

        if (heure.getH() < h) {
            if (min < heure.getMin()) {
                int temp = 24 - h;
                temp += heure.getH();
                duree.setH(temp);
                duree.setMin(heure.getMin() - min);
            } else if (min > heure.getMin()) {
                int temp = 24 - h;
                temp += heure.getH();
                duree.setH(temp);

                int temp1 = min;
                int temp2 = heure.getMin();
                while (temp2 > 0) {
                    temp2--;
                    temp1--;
                }
                temp2 = 60;
                temp2 -= temp1;
                duree.setH(temp - 1);
                duree.setMin(temp2);
            }

        }
        return duree;
    }

    public String toString() {
        return getH() + " " + " h " + getMin();
    }

    public static void main(String[] args) {
        Heure g1 = new Heure(18, 12);
        Heure g2 = new Heure(3, 59);

        System.out.println(g1.duree(g2));
    }
}

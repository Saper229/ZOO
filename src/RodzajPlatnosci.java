public enum RodzajPlatnosci {
    GOTOWKA,
    BLIK,
    KARTA;

    public int blikPayment(){
        int point = (int) ((Math.random()*1000)+1);
        return point;
    }
}

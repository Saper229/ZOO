public enum RodzajPlatnosci {
    GOTOWKA,
    BLIK,
    KARTA;

    public int blikPayment(){
        int point = (int) ((Math.random()*1000000)+1);
        return point;
    }

    public int cardPayment(){
        int point = 8520;
        return point;
    }
}

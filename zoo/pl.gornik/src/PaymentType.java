public enum PaymentType {
    CASH, BLIK, CARD;

    public int generateBlik() {
        return (int) (Math.random() * 900000) + 100000;
    }
}
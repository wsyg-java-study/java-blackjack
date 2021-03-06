package app.model;

public enum CardShape {
    HEART("하트"),
    SPADE("스페이드"),
    CLOVER("클로버"),
    DIAMOND("다이아몬드");

    private final String cardShape;

    CardShape(String cardShape) {
        this.cardShape = cardShape;
    }

    String getCardShape() {
        return cardShape;
    }
}

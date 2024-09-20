package com.kmhoon.common.enums.product;

import com.kmhoon.common.enums.vendingMachine.VendingMachineType;
import lombok.Getter;

@Getter
public enum ProductType {
    // 음료 자판기에 속할 물품 타입
    SODA("탄산음료", VendingMachineType.BEVERAGE),
    WATER("생수", VendingMachineType.BEVERAGE),
    JUICE("주스", VendingMachineType.BEVERAGE),
    TEA("차", VendingMachineType.BEVERAGE),
    ENERGY_DRINK("에너지 드링크", VendingMachineType.BEVERAGE),
    MILK("우유", VendingMachineType.BEVERAGE),

    // 간식 자판기에 속할 물품 타입
    CHIPS("감자칩", VendingMachineType.SNACK),
    CHOCOLATE("초콜릿", VendingMachineType.SNACK),
    NUTS("견과류", VendingMachineType.SNACK),
    CANDY("사탕", VendingMachineType.SNACK),
    COOKIES("쿠키", VendingMachineType.SNACK),
    GUM("껌", VendingMachineType.SNACK),

    // 음식 자판기에 속할 물품 타입
    SANDWICH("샌드위치", VendingMachineType.FOOD),
    SALAD("샐러드", VendingMachineType.FOOD),
    MEAL_BOX("도시락", VendingMachineType.FOOD),
    NOODLES("라면", VendingMachineType.FOOD),
    RICE_BALL("주먹밥", VendingMachineType.FOOD),
    BURGER("버거", VendingMachineType.FOOD),

    // 커피 자판기에 속할 물품 타입
    ESPRESSO("에스프레소", VendingMachineType.COFFEE),
    LATTE("라떼", VendingMachineType.COFFEE),
    AMERICANO("아메리카노", VendingMachineType.COFFEE),
    CAPPUCCINO("카푸치노", VendingMachineType.COFFEE),
    MOCHA("모카", VendingMachineType.COFFEE),
    MACCHIATO("마키아토", VendingMachineType.COFFEE),

    // 건강식품 자판기에 속할 물품 타입
    PROTEIN_BAR("단백질바", VendingMachineType.HEALTHY_FOOD),
    VITAMINS("비타민", VendingMachineType.HEALTHY_FOOD),
    ORGANIC_SNACK("유기농 간식", VendingMachineType.HEALTHY_FOOD),
    ENERGY_BAR("에너지바", VendingMachineType.HEALTHY_FOOD),
    DRIED_FRUIT("건과일", VendingMachineType.HEALTHY_FOOD),
    GLUTEN_FREE_SNACK("글루텐 프리 간식", VendingMachineType.HEALTHY_FOOD),

    // 전자제품 자판기에 속할 물품 타입
    HEADPHONES("헤드폰", VendingMachineType.ELECTRONICS),
    CHARGER("충전기", VendingMachineType.ELECTRONICS),
    USB_DRIVE("USB 드라이브", VendingMachineType.ELECTRONICS),
    POWER_BANK("보조 배터리", VendingMachineType.ELECTRONICS),
    SMARTWATCH("스마트워치", VendingMachineType.ELECTRONICS),
    BLUETOOTH_SPEAKER("블루투스 스피커", VendingMachineType.ELECTRONICS),

    // 의류 자판기에 속할 물품 타입
    T_SHIRT("티셔츠", VendingMachineType.CLOTHING),
    SOCKS("양말", VendingMachineType.CLOTHING),
    HAT("모자", VendingMachineType.CLOTHING),
    SCARF("스카프", VendingMachineType.CLOTHING),
    GLOVES("장갑", VendingMachineType.CLOTHING),
    JACKET("재킷", VendingMachineType.CLOTHING),

    // 화장품 자판기에 속할 물품 타입
    LIPSTICK("립스틱", VendingMachineType.COSMETICS),
    MOISTURIZER("보습제", VendingMachineType.COSMETICS),
    PERFUME("향수", VendingMachineType.COSMETICS),
    FOUNDATION("파운데이션", VendingMachineType.COSMETICS),
    MASCARA("마스카라", VendingMachineType.COSMETICS),
    EYE_SHADOW("아이섀도우", VendingMachineType.COSMETICS),

    // 책 자판기에 속할 물품 타입
    NOVEL("소설", VendingMachineType.BOOK),
    MAGAZINE("잡지", VendingMachineType.BOOK),
    COMIC("만화책", VendingMachineType.BOOK),
    TEXTBOOK("교과서", VendingMachineType.BOOK),
    GUIDEBOOK("가이드북", VendingMachineType.BOOK),
    JOURNAL("저널", VendingMachineType.BOOK),

    // 장난감 자판기에 속할 물품 타입
    ACTION_FIGURE("액션 피규어", VendingMachineType.TOY),
    PUZZLE("퍼즐", VendingMachineType.TOY),
    DOLL("인형", VendingMachineType.TOY),
    LEGO("레고", VendingMachineType.TOY),
    BOARD_GAME("보드 게임", VendingMachineType.TOY),
    REMOTE_CONTROL_CAR("원격 조종 자동차", VendingMachineType.TOY),

    // 약품 자판기에 속할 물품 타입
    PAINKILLER("진통제", VendingMachineType.PHARMACEUTICAL),
    BANDAGE("반창고", VendingMachineType.PHARMACEUTICAL),
    COUGH_SYRUP("기침약", VendingMachineType.PHARMACEUTICAL),
    ANTISEPTIC_WIPES("소독 물티슈", VendingMachineType.PHARMACEUTICAL),
    VITAMIN_C("비타민 C", VendingMachineType.PHARMACEUTICAL),
    ALLERGY_MEDICINE("알레르기 약", VendingMachineType.PHARMACEUTICAL),

    // 기념품 자판기에 속할 물품 타입
    KEYCHAIN("열쇠고리", VendingMachineType.SOUVENIR),
    POSTCARD("엽서", VendingMachineType.SOUVENIR),
    MUG("머그컵", VendingMachineType.SOUVENIR),
    T_SHIRT_SOUVENIR("기념 티셔츠", VendingMachineType.SOUVENIR),
    MAGNET("자석", VendingMachineType.SOUVENIR),
    MINIATURE("미니어처", VendingMachineType.SOUVENIR);

    private final String description;
    private final VendingMachineType vendingMachineType;

    ProductType(String description, VendingMachineType vendingMachineType) {
        this.description = description;
        this.vendingMachineType = vendingMachineType;
    }
}
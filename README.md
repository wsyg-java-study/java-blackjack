# java-blackjack

블랙잭 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

- 기능 요구사항
    - 블랙잭 게임에 참여할 사람의 이름을 입력 받는다.
    - 딜러와 게임 참가자들에게 2장의 카드를 공개적으로 나누어준다.
        - 이때 딜러의 카드는 한장만 공개한다.
    - 각 게임 참가자들에게 카드를 받을 것인지 물어본다.
        - 받는다면 공개적으로 한장의 카드를 준다.
        - 만약 게임 참가자가 파산했다면 더 물어보지 않을 것이다.
    - 모든 게임 참가자가 카드 받기를 멈추면 딜러 또한 선택적으로 카드를 받는다
        - 딜러의 합계가 16이하라면 한장의 카드를 더 받고 아니면 멈춘다.
    - 딜러와 게임 참가자의 카드와 합계 결과를 출력한다.
    - 딜러와 합계를 비교하여 게임 참가자들의 최종 승패를 출력한다.
        - 딜러가 파산했다면 파산하지 않은 모든 게임 참가자가 승리한다.

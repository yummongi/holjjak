import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int mylife = 10, yourlife = 10; //보유 구슬
        int myball, yourball = 0; //배팅 구슬
        String answer = "";

        Scanner scanner = new Scanner(System.in);
        System.out.println("오징어 게임에 오신것을 환영합니다.");
        System.out.println("이번 게임은 구슬 게임입니다.");
        System.out.println("당신과 나는 각각 10개의 구슬을 가지고 있습니다.");
        System.out.println("10개의 구슬을 모두 잃으면 죽습니다.");
        System.out.println("시작합니다.");
        System.out.println("배팅 하세요");
        System.out.println("=======================================");
        do {
            do {

                System.out.print("자신이 베팅할 구슬 갯수를 입력하세요: (1~10 입력)");
                myball = scanner.nextInt();
            } while (myball < 1 || myball > mylife);
            System.out.println("=======================================");
            System.out.println("시작합니다.");

            yourball = (int) (Math.random() * yourlife) + 1; // 1 ~ 10 까지

            System.out.println("상대방이 낸 구슬 갯수: " + yourball);
            System.out.println("내가 낸 구슬 갯수: " + myball);
            System.out.println("=======================================");
            if (myball > yourball) {
                mylife += yourball;
                yourlife -= yourball;
                System.out.println("승리하였습니다.");

            } else if (myball == yourball) System.out.println("비겼습니다.");
            else {
                yourlife += myball;
                mylife -= myball;
                System.out.println("상대방한테 졌습니다.");
            }
            System.out.println("=======================================");
            System.out.println("현재 나의 구슬 갯수: " + mylife);
            System.out.println("현재 상대방 구슬 갯수: " + yourlife);
        } while (mylife > 0 && yourlife > 0);

        if (mylife <= 0) {
            System.out.println("=======================================");
            System.out.println("나의 구슬을 모두 잃었습니다.");
            System.out.println("상대방 승리!");
        } else {
            System.out.println("=======================================");
            System.out.println("상대방 구슬을 모두 잃었습니다.");
            System.out.println("내가 승리!");
        }
    }
}




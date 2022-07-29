import java.util.Scanner;

public class Base {
    public int mylife, yourlife; //보유 구슬
    public int myball, yourball; //배팅 구슬
    public String myanswer, answer;

    //생성자
    Base(){
        this.mylife = 10;
        this.yourlife = 10;
        this.myball = 0;
        this.yourball = 0;
        this.myanswer = "";
        this.answer = "";
    }
    Base(int mylife, int yourlife){
        this.mylife = mylife;
        this.yourlife = yourlife;
    }

    //인트로 메세지
    public static void intro() {
        System.out.println("오징어 게임에 오신것을 환영합니다.");
        System.out.println("이번 게임은 구슬 게임입니다.");
        System.out.println("당신과 나는 각각 10개의 구슬을 가지고 있습니다.");
        System.out.println("10개의 구슬을 모두 잃으면 죽습니다.");
        System.out.println("시작합니다.");
        System.out.println("배팅 하세요");
        System.out.println("=======================================");
    }

    //승리, 패배 시 구슬 설정
    public void setBall() {
        if (myanswer.equalsIgnoreCase(answer)) {
            mylife += myball;
            yourlife -= myball;
            System.out.println("승리하였습니다.");
        } else if (!(myanswer.equalsIgnoreCase(answer))) {
            yourlife += yourball;
            mylife -= yourball;
            System.out.println("상대방한테 졌습니다.");
        } else {
            System.out.println("비겼습니다.");
        }
    }

    //승리 시 메세지
    public void victory(){
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

    //게임 시작
    public void gameStart() {
        Scanner scanner = new Scanner(System.in);
        intro();
        try {
            do {
                do {
                    System.out.print("자신이 베팅할 구슬 갯수를 입력하세요: (1~10 입력)");
                    myball = scanner.nextInt();
                } while (myball < 1 || myball > mylife); //do

                System.out.println("=======================================");
                System.out.println("시작합니다.");

                yourball = (int) (Math.random() * 10) + 1; // 1 ~ 10 까지

                System.out.print("상대방의 구슬을 홀, 짝을 입력하여 추리하세요.");
                myanswer = scanner.next();

                if (myanswer.equals("홀") || myanswer.equals("짝")) {

                    if(yourball % 2 == 0)
                        answer = "짝";
                    else
                        answer = "홀";

                    System.out.println("=======================================");
                    System.out.println("내가 낸 구슬 갯수 : " + myball);
                    System.out.println("상대가 낸 구슬 갯수 : " + yourball);
                    System.out.println("=======================================");

                    setBall();

                    System.out.println("=======================================");
                    System.out.println("현재 나의 구슬 갯수: " + mylife);
                    System.out.println("현재 상대방 구슬 갯수: " + yourlife);
                } else {
                    System.out.println("홀 또는 짝만 입력해주세요.");
                }

            } while (mylife > 0 && yourlife > 0); //do

            victory();

        } catch (Exception e) {
            System.out.println("값을 똑바로 입력해주세요.");
        }
    }
}
